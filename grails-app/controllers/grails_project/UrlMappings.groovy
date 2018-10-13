package grails_project

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
        "/api/user"(controller: "Api", action: "createUser", method: "POST")
        "/api/user"(controller: "Api", action: "editUser", method: "PUT")
        "/api/user"(controller: "Api", action: "deleteUser", method: "DELETE")
        "/api/users"(controller: "Api", action: "getUsersList", method: "GET")
        "/api/users"(controller: "Api", action: "createUser", method: "POST")

        "/api/message"(controller: "Api", action: "createMessage", method: "POST")
        "/api/messages"(controller: "Api", action: "createMessage", method: "POST")
        "/api/message"(controller: "Api", action: "editMessage", method: "PUT")
        "/api/message"(controller: "Api", action: "deleteMessage", method: "DELETE")
        "/api/messages"(controller: "Api", action: "getMessagesList", method: "GET")

        "/api/resultat"(controller: "Api", action: "createResultat", method: "POST")
        "/api/resultats"(controller: "Api", action: "createResultat", method: "POST")
        "/api/resultat"(controller: "Api", action: "editResultat", method: "PUT")
        "/api/resultat"(controller: "Api", action: "deleteResultat", method: "DELETE")
        "/api/resultats"(controller: "Api", action: "getResultatsList", method: "GET")

    }
}
