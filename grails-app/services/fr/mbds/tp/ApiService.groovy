package fr.mbds.tp

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap
import grails.plugin.springsecurity.annotation.Secured
import javax.servlet.http.HttpServletRequest
import java.nio.file.Files
import java.nio.file.Path

@Transactional
class ApiService {

    def springSecurityService
    def grailsApplication




    //creation d'un nouveau utilisateur suite requete post
    @Secured(['ROLE_USER','ROLE_ADMIN'])
    def createUser(HttpServletRequest request) {

        User newUser

        def roleQuery = Role.where { authority == request.JSON.role }
        Role role = roleQuery.find()


        if (request.JSON.image == null){
            newUser = new User(username: request.JSON.username, password: request.JSON.password).save(flush: true, failOnError: true)
        }
        else{

            def imageName = uploadImage(request.JSON.image)
            newUser = new User(username: request.JSON.username, password: request.JSON.password, image: imageName).save(flush: true, failOnError: true)
        }

        UserRole.create(newUser, role, true)
        return newUser

    }

    //TODO modification utilisateur suite requete put
    @Secured(['ROLE_ADMIN'])
    def editUser(HttpServletRequest request) {
        def userQuery = User.where { id == request.JSON.id }
        User user = userQuery.find()
        if (request.JSON.username != null) user.setUsername(request.JSON.username)
        if (request.JSON.password != null) user.setPassword(request.JSON.password)
        if (request.JSON.role != null) {
            UserRole.removeAll(user)
            UserRole.create(user: user,role: request.JSON.role, flush : true)
        }
        if(request.JSON.image != null){
            String FILE_PATH = grailsApplication.config.getProperty('filePath')
            File oldPicture = new File(FILE_PATH + user.getImage())
            oldPicture.delete()

            user.setImage(uploadImage(request.JSON.image))

        }
    }

    //suppression utilisateur suite requete delete
    @Secured(['ROLE_ADMIN'])
    def deleteUser(HttpServletRequest request) {
        def userQuery = User.where { id == request.JSON.id }
        User user = userQuery.find()
        user.setEnabled(false)
    }



    //TODO affichage des droits de l'utilisateur
    def getUserRight(){



        User currentUser = springSecurityService.getCurrentUser();
        listRole = UserRole.where { user == currentUser }



    }

    // Permet l'upload de l'image sur le serveur web
    def uploadImage(String image) {

        String imageName = UUID.randomUUID().toString() + ".png"
        String FILE_PATH = grailsApplication.config.getProperty('filePath')
        String pathToFile = FILE_PATH + imageName

        byte[] decoded = image.decodeBase64()
        new File(pathToFile).withOutputStream {
            it.write(decoded)
        }
        return imageName

    }
}

