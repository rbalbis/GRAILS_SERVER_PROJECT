package fr.mbds.tp

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

import javax.servlet.http.HttpServletRequest

@Transactional
class CustomUserService {

    def springSecurityService
    def grailsApplication


    def uploadImage(f) {

//        String imageName = UUID.randomUUID().toString() + "."+ f.getFile('image').contentType.split("/")[-1]
        String imageName = f.getParameter("imageName")
        String FILE_PATH = grailsApplication.config.getProperty('filePath')
        String pathToFile = FILE_PATH + imageName
        f.getFile('image').transferTo(new File(pathToFile))

        String oldImageName = f.getParameter("oldImageName")
        String pathToOldFile = FILE_PATH + oldImageName
        File file = new File(pathToOldFile)
        file.delete()
        return imageName

    }

    // Methode save pour la creation d'un compte
    def save(User user, HttpServletRequest request, GrailsParameterMap params) {

        String imageName = user.image

        def roleQuery = Role.where { authority == params.get('role') }
        Role role = roleQuery.find()

        def newUser = new User(username: user.username, password: user.password, image: imageName).save(flush: true, failOnError: true)

        UserRole.create(newUser, role, true)
        return newUser

    }

    // Methode save pour la modification d'un compte deja existant
    def save(HttpServletRequest request, GrailsParameterMap params) {

        System.out.print(params.get('role'))


        def roleQuery = Role.where { authority == params.get('role') }
        Role role = roleQuery.find()

        def id = params.get('id')
        def username = params.get('username')
        def password = params.get('password')
        def image = params.get('image')
        def newUser

        def userQuery = User.where { id == id }
        User oldUser = userQuery.find()
        oldUser.setUsername(username)
        if (password != null) {
            oldUser.setPassword(password)
        }
        oldUser.setImage(image)
        oldUser.save(flush: true, failOnError: true)
        newUser = oldUser

        UserRole.create(newUser, role, true)
        return newUser

    }


    User getCurrentUser() {
        User user = springSecurityService.currentUser
        return user

    }

}
