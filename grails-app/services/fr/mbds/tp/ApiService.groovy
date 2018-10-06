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
    def createUser(GrailsParameterMap params) {

        User newUser

        def roleQuery = Role.where { authority == params.role }
        Role role = roleQuery.find()


        if (params.image == null){
            newUser = new User(username: params.username, password: params.password).save(flush: true, failOnError: true)
        }
        else{
            def imageName = uploadImage(params)
            newUser = new User(username: params.username, password: params.password, image: imageName).save(flush: true, failOnError: true)
        }

        UserRole.create(newUser, role, true)
        return newUser

    }

    //TODO modification utilisateur suite requete put
    @Secured(['ROLE_ADMIN'])
    def editUser(GrailsParameterMap params, HttpServletRequest request) {
        def userQuery = User.where { id == request.JSON.id }
        User user = userQuery.find()
        if (request.JSON.username != null) user.setUsername(request.JSON.username)
        if (request.JSON.password != null) user.setPassword(request.JSON.password)
        if (request.JSON.role != null) {
            UserRole.removeAll(user)
            UserRole.create(user: user,role: request.JSON.role, flush : true)
        }
    }

    //suppression utilisateur suite requete delete
    @Secured(['ROLE_ADMIN'])
    def deleteUser(GrailsParameterMap params, HttpServletRequest request) {
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
    def uploadImage(params) {

        def image = params.image

        String imageName = UUID.randomUUID().toString() + "."+ image.contentType.split("/")[-1]
        String FILE_PATH = grailsApplication.config.getProperty('filePath')
        String pathToFile = FILE_PATH + imageName
        image.transferTo(new File(pathToFile))
        return imageName

    }
}

