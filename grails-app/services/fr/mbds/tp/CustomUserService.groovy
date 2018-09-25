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
        String pathToFile= FILE_PATH + imageName
        f.getFile('image').transferTo(new File(pathToFile))

        String oldImageName = f.getParameter("oldImageName")
        String pathToOldFile= FILE_PATH + oldImageName
        File file = new File(pathToOldFile)
        file.delete()
        return imageName

    }

    def save(User user, HttpServletRequest request, GrailsParameterMap params){

        String imageName = user.image
        System.out.print(params.get('role'))

        def roleQuery = Role.where { authority == params.get('role') }
        Role role = roleQuery.find()

        def userQuery = User.where { id == user.id }
        User oldUser = userQuery.find()

        def newUser

        // Si c'est un update
        if(oldUser != null){
            oldUser.setUsername(user.username)
            oldUser.setPassword(user.password)
            oldUser.setImage(user.image)
            oldUser.save(flush:true, failOnError:true)
            newUser = oldUser
        }
        // Si c'est une création
        else{
            newUser = new User(username:user.username, password: user.password, image: imageName).save(flush:true, failOnError:true)
        }


        UserRole.create(newUser, role,true)
        return newUser

    }


    User getCurrentUser(){
        User user = springSecurityService.currentUser
        return user

    }
}
