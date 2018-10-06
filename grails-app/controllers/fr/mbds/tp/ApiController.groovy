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

    def index() {
        switch (request.getMethod()) {
            case "POST":
                render "post"
                break
            case "GET":
                render "get" Secured
                break

        }

        render 'ok' as XML
    }

    // Gestion utilisateur
    def user() {
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

            case "POST":
                if (params.username == null || params.password == null || params.role == null) {
                    render(status: 400, text: 'parameter not provided')
                    break
                } else {

                    try {
                        apiService.createUser(params)
                    }
                    catch (Exception e) {
                        render(status: 500, text: "creation de l'utilisateur impossible ${e}")
                        break
                    }
                    render(status: 201, text: "utilisateur cree avec succes")
                    break
                }
                break

            case "PUT":
                params.username
                request.binary
                if (request.JSON.username == null && request.JSON.password == null && request.JSON.role == null && request.JSON.image == null || request.JSON.id == null) {
                    render(status: 400, text: 'parameter not provided')
                    break
                } else {

                    try {
                        apiService.editUser(params, request)
                    }
                    catch (Exception) {
                        render(status: 500, text: "modification de l'utilisateur impossible")
                        break
                    }
                    render(status: 200, text: "utilisateur modifie avec succes")
                    break
                }
                break

            case "DELETE":
                if (request.JSON.id == null) {
                    render(status: 400, text: 'id parameter not provided')
                    break
                } else {

                    try {
                        apiService.deleteUser(params)
                    }
                    catch (Exception) {
                        render(status: 500, text: "suppression de l'utilisateur impossible")
                        break
                    }
                    render(status: 200, text: "utilisateur supprimé avec succes")
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


    def message() {
        switch (request.getMethod()) {
            case "GET":
                if (params.id == null) {
                    render(status: 400, text: 'id number not provided')
                    break
                } else {
                    renderAsExpected(200, message, request)
                    break
                }
                break
        }
    }
}
