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
    }

    def save(User user, HttpServletRequest request){




        uploadImage(request.getFile('image'))

    }

}
