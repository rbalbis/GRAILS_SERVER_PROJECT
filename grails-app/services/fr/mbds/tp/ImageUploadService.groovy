package fr.mbds.tp

import grails.gorm.transactions.Transactional

import javax.servlet.http.HttpServletRequest

@Transactional
class ImageUploadService {

    def springSecurityService

    def uploadImage(f) {
        def user = springSecurityService.currentUser

        String pathToFile= "/Applications/MAMP/htdocs/image" + f.getName()

        f.transferTo(new File(pathToFile))
        user.image = pathToFile

        return pathToFile
    }

    def save(User user, HttpServletRequest request){

        def pathToFile = uploadImage(request.getFile('image'))

        def testUser = new User(username:user.username, password: user.password, image: pathToFile).save(flush:true, failOnError:true)
        return testUser

    }

}
