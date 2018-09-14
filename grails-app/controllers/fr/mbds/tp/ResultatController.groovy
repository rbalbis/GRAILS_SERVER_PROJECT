package fr.mbds.tp

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured(['ROLE_ADMIN', "ROLE_USER"])

class ResultatController {

    ResultatService ResultatService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ResultatService.list(params), model:[matchCount: ResultatService.count()]
    }

    def show(Long id) {
        respond ResultatService.get(id)
    }

    def create() {
        respond new Resultat(params)
    }

    def save(Resultat match) {
        if (match == null) {
            notFound()
            return
        }

        try {
            ResultatService.save(match)
        } catch (ValidationException e) {
            respond match.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'resultat.label', default: 'Resultat'), match.id])
                redirect match
            }
            '*' { respond match, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond ResultatService.get(id)
    }

    def update(Resultat match) {
        if (match == null) {
            notFound()
            return
        }

        try {
            ResultatService.save(match)
        } catch (ValidationException e) {
            respond match.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'resultat.label', default: 'Resultat'), match.id])
                redirect match
            }
            '*'{ respond match, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ResultatService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'resultat.label', default: 'Resultat'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'resultat.label', default: 'Resultat'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
