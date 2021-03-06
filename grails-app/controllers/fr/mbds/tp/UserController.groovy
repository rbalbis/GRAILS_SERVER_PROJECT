package fr.mbds.tp

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured(['ROLE_ADMIN'])
class UserController {

    UserService userService

    CustomUserService customUserService = getCustomUserService()

    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 120, 100)
        respond userService.list(params), model:[userCount: userService.count()]
    }

    def show(Long id) {
        respond userService.get(id)
    }

    def create() {
        respond new User(params)
    }

    def save(User user) {
        if (user == null) {
            notFound()
            return
        }
        try {
            user = customUserService.save(user, request, params)
        } catch (ValidationException e) {
            respond user.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*' { respond user, [status: CREATED] }
        }
    }

    def saveImage() {
        customUserService.uploadImage(request)
    }

    @Secured(['ROLE_USER','ROLE_ADMIN'])
    def getCurrentUser(){
        def user = customUserService.getCurrentUser()
        def jsonUser = user.toString()
        render user as JSON
    }

    def edit(Long id) {
        respond userService.get(id)
    }

    def update() {
        def user
        try {
            user = customUserService.save(request, params)
        } catch (ValidationException e) {
            respond 'Error', view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = "L'utilisateur avec l'id ${user.id} a été mise a jour"
                redirect user
            }
            '*'{ respond user, [status: OK] }
        }
    }

    @Secured(['ROLE_USER','ROLE_ADMIN'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        User user = userService.get(id)

        user.enabled = false
        user.setEnabled(false)
        user.save(flush:true, failOnError:true)


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }



}
