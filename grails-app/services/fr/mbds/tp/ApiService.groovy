package fr.mbds.tp

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

import java.nio.file.Files
import java.nio.file.Path

@Transactional
class ApiService {

    def springSecurityService
    def grailsApplication




    //TODO creation d'un nouveau utilisateur suite requete post
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
    def editUser(GrailsParameterMap params) {


    }

    //TODO suppression utilisateur suite requete delete
    def deleteUser(GrailsParameterMap params) {

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