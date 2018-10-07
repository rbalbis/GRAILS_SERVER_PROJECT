package fr.mbds.tp

import grails.converters.JSON
import grails.converters.XML
import org.springframework.security.access.annotation.Secured

import javax.servlet.http.HttpServletRequest

class ApiController {

    ApiService apiService


    def renderAsExpected(int status, Object objectToRender, HttpServletRequest request) {

        withFormat {
            json { render(status: status, contentType: "application/json", objectToRender as JSON) }
            xml { render objectToRender as XML }
        }

    }

    @Secured(['ROLE_ADMIN'])
    def createUser(){
        if (params.username == null || params.password == null || params.role == null) {
            render(status: 400, text: 'parameter not provided')
            return
        } else {

            try {
                apiService.createUser(params)
            }
            catch (Exception e) {
                render(status: 500, text: "creation de l'utilisateur impossible ${e}")
                return
            }
            render(status: 201, text: "utilisateur cree avec succes")
            return
        }
    }

    @Secured(['ROLE_ADMIN'])
    def editUser(){
        if (params.username == null && params.password == null && params.role == null && params.image == null || params.id == null) {
            render(status: 400, text: 'parameter not provided')
            return
        } else {

            try {
                apiService.editUser(params)
            }
            catch (Exception) {
                render(status: 500, text: "modification de l'utilisateur impossible")
                return
            }
            render(status: 200, text: "utilisateur modifie avec succes")
            return
        }
        return
    }

    @Secured(['ROLE_ADMIN'])
    def deleteUser(){
        if (params.id == null) {
            render(status: 400, text: 'id parameter not provided')
            return
        } else {

            try {
                apiService.deleteUser(params)
            }
            catch (Exception) {
                render(status: 500, text: "suppression de l'utilisateur impossible" + Exception)
                return
            }
            render(status: 200, text: "utilisateur supprimé avec succes")
            return
        }
        return
    }


    // Gestion utilisateur
    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def user(User user) {
        switch (request.getMethod()) {
            case "GET":
                if (params.id == null) {
                    render(status: 400, text: 'id number not provided')
                    break
                } else {
                    renderAsExpected(200, user, request)
                    break
                }
                break

            case "OPTIONS":
                apiService.getUserRight()
                render(status: 501, text: "Requete OPTION non implementé")
                break
            default:
                render(status: 501, text: "requete non implementé")
                break

        }
    }
}
