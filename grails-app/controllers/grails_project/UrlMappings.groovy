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
    }
}
