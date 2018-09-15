package fr.mbds.tp

import grails.gorm.transactions.Transactional


import javax.servlet.http.HttpServletRequest

@Transactional
class ImageUploadService {

    def springSecurityService
    def grailsApplication


    def uploadImage(f) {

//        String imageName = UUID.randomUUID().toString() + "."+ f.getFile('image').contentType.split("/")[-1]
        String imageName = f.getParameter("imageName")
        String FILE_PATH = grailsApplication.config.getProperty('filePath')
        String pathToFile= FILE_PATH + imageName
        f.getFile('image').transferTo(new File(pathToFile))
        return imageName

    }

    def save(User user, HttpServletRequest request){

        String imageName = user.image
        def newUser = new User(username:user.username, password: user.password, image: imageName).save(flush:true, failOnError:true)
        return newUser

    }

}
