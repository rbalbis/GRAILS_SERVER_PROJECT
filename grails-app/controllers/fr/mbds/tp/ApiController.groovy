package fr.mbds.tp

import grails.converters.JSON
import grails.converters.XML
import org.springframework.security.access.annotation.Secured

class ApiController {

    def index() {
        switch(request.getMethod())
        {
            case "POST":
                render "post"
                break
            case "GET":
                render "get"
                break

        }

        render 'ok' as XML
    }

    def user (User user){
        switch(request.getMethod())
        {
            case "GET":
                render user as JSON
                break
        }
    }
}
