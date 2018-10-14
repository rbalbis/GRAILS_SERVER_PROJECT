package fr.mbds.tp

import grails.converters.JSON
import grails.converters.XML
import org.springframework.security.access.annotation.Secured

import javax.servlet.http.HttpServletRequest

class ApiController {

    ApiService apiService

    MessageUsersService messageUsersService = getMessageUsersService()

    MessageService messageService

    ResultatService resultatService

    // Pour get User
    UserService userService



    def renderAsExpected(int status, Object objectToRender, HttpServletRequest request) {

        withFormat {
            json { render(status: status, contentType: "application/json", objectToRender as JSON) }
            xml { render objectToRender as XML }
        }

    }

    @Secured(['ROLE_ADMIN'])
    def createUser(){
        if (request.JSON.username == null || request.JSON.password == null || request.JSON.role == null) {
            render(status: 400, text: 'parameter not provided')
            return
        } else {

            try {
                apiService.createUser(request)
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
        if (request.JSON.username == null && request.JSON.password == null && request.JSON.role == null && request.JSON.image == null || request.JSON.id == null) {
            render(status: 400, text: "parameter not provided")
            return
        } else {

            try {
                apiService.editUser(request)
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
        if (request.JSON.id == null) {
            render(status: 400, text: 'id parameter not provided')
            return
        } else {

            try {
                apiService.deleteUser(request)
            }
            catch (Exception) {
                render(status: 500, text: "suppression de l'utilisateur impossible")
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
                    try{renderAsExpected(200, user, request)}
                    catch (Exception e){
                        render(status: 500, text: "Get user impossible l'id n'est pas present dans la base")

                    }
                    break
                }
                break

            case "OPTIONS":
                //apiService.getUserRight()
                render(status: 501, text: "Requete OPTION non implementé")
                break
            default:
                render(status: 501, text: "requete non implementé")
                break

        }
    }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def getUsersList(){
        def jsonResp = User.all as JSON
        render(status: 200,jsonResp)
        return
    }

    // Gestion des messages
    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def message(Message message) {
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

            case "OPTIONS":
                render(status: 501, text: "Requete OPTION non implementé")
                break
            default:
                render(status: 501, text: "requete non implementé")
                break
        }
    }

    @Secured(['ROLE_ADMIN'])
    def createMessage(Message message){
        if (message.author == null || message.target == null || message.content == null) {
            render(status: 400, text: 'parameter not provided')
            return
        } else {
            try {
                messageService.save(message)
            }
            catch (Exception e) {
                render(status: 500, text: "Creation du message impossible ${e}")
                return
            }
            render(status: 201, text: "Message cree avec succes")
            return
        }
    }

    @Secured(['ROLE_ADMIN'])
    def editMessage(){
        if (request.JSON.author == null || request.JSON.target == null || request.JSON.content == null) {
            render(status: 400, text: 'parameter not provided')
            return
        } else {

            try {
                Message message = messageService.get(request.JSON.id)
                message.setAuthor(userService.get(request.JSON.author))
                message.setTarget(userService.get(request.JSON.target))
                message.setContent(request.JSON.content)
                messageService.save(message)
            }
            catch (Exception e) {
                render(status: 500, text: "creation du message impossible ${e}")
                return
            }
            render(status: 201, text: "Message cree avec succes")
            return
        }
    }

    @Secured(['ROLE_ADMIN'])
    def deleteMessage(){
        if (request.JSON.id == null) {
            render(status: 400, text: 'id parameter not provided')
            return
        } else {

            try {
                messageService.delete(request.JSON.id)
            }
            catch (Exception) {
                render(status: 500, text: "suppression du message impossible")
                return
            }
            render(status: 200, text: "Message supprimé avec succes")
            return
        }
        return
    }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def getMessagesList(){
        def jsonResp = Message.all as JSON
        render(status: 200,jsonResp)
        return
    }

// Gestion des resultats
    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def resultat(Resultat resultat) {
        switch (request.getMethod()) {
            case "GET":
                if (params.id == null) {
                    render(status: 400, text: 'id number not provided')
                    break
                } else {
                    renderAsExpected(200, resultat, request)
                    break
                }
                break

            case "OPTIONS":
                render(status: 501, text: "Requete OPTION non implementé")
                break
            default:
                render(status: 501, text: "requete non implementé")
                break
        }
    }


    @Secured(['ROLE_ADMIN'])
    def createResultat(Resultat resultat){
        if (resultat.winner == null || resultat.looser == null || resultat.winnerScore == null || resultat.looserScore == null) {
            render(status: 400, text: 'parameter not provided')
            return
        } else {
            try {
                resultatService.save(resultat)
            }
            catch (Exception e) {
                render(status: 500, text: "Creation du resultat impossible ${e}")
                return
            }
            render(status: 201, text: "Resultat cree avec succes")
            return
        }
    }

    @Secured(['ROLE_ADMIN'])
    def editResultat(){
        if (request.JSON.winner == null || request.JSON.looser == null || request.JSON.winnerScore == null || request.JSON.looserScore == null) {
            render(status: 400, text: 'parameter not provided')
            return
        } else {

            try {
                Resultat resultat = resultatService.get(request.JSON.id)
                resultat.setWinner(userService.get(request.JSON.winner))
                resultat.setLooser(userService.get(request.JSON.looser))
                resultat.setWinnerScore(request.JSON.winnerScore)
                resultat.setLooserScore(request.JSON.looserScore)
                resultatService.save(resultat)
            }
            catch (Exception e) {
                render(status: 500, text: "creation du resultat impossible ${e}")
                return
            }
            render(status: 201, text: "Resultat cree avec succes")
            return
        }
    }

    @Secured(['ROLE_ADMIN'])
    def deleteResultat(){
        if (request.JSON.id == null) {
            render(status: 400, text: 'id parameter not provided')
            return
        } else {

            try {
                resultatService.delete(request.JSON.id)
            }
            catch (Exception) {
                render(status: 500, text: "suppression du resultat impossible")
                return
            }
            render(status: 200, text: "Resultat supprimé avec succes")
            return
        }
        return
    }


    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def getResultatsList(){
        def jsonResp = Resultat.all as JSON
        render(status: 200,jsonResp)
        return
    }
}
