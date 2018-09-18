package fr.mbds.tp

import grails.converters.XML
import org.springframework.security.access.annotation.Secured

class ApiController {

    @Secured(['ROLE_ADMIN'])
    def index() {
        switch(request.getMethod())
        {
            case "POST":
                render "post"
                break;
            case "GET":
                render "get"
                break;

        }

        render 'ok' as XML
    }
}
