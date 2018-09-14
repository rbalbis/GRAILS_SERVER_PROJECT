package fr.mbds.tp

import grails.gorm.transactions.Transactional


import javax.servlet.http.HttpServletRequest

@Transactional
class ImageUploadService {

    def springSecurityService
    def grailsApplication


    def uploadImage(f) {

        String imageName = UUID.randomUUID().toString() + "."+ f.contentType.split("/")[-1]

        String FILE_PATH = grailsApplication.config.getProperty('filePath')

        String pathToFile= FILE_PATH + imageName

        f.transferTo(new File(pathToFile))


        return imageName
    }

    def save(User user, HttpServletRequest request){

        def pathToFile = uploadImage(request.getFile('image'))

        def newUser = new User(username:user.username, password: user.password, image: pathToFile).save(flush:true, failOnError:true)
        return newUser

    }

}
