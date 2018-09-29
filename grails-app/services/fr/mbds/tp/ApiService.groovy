package fr.mbds.tp

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class ApiService {

    def springSecurityService
    def grailsApplication



    //TODO creation d'un nouveau utilisateur suite requete post
    def createUser(GrailsParameterMap grailsParameterMap) {


    }

    //TODO modification utilisateur suite requete put
    def editUser(GrailsParameterMap grailsParameterMap) {


    }

    //TODO suppression utilisateur suite requete delete
    def deleteUser(GrailsParameterMap grailsParameterMap) {

    }

    //TODO affichage des droits de l'utilisateur
    def getUserRight(){



        User currentUser = springSecurityService.getCurrentUser();
        listRole = UserRole.where { user == currentUser }



    }
}
