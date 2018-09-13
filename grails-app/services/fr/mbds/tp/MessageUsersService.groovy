package fr.mbds.tp

import grails.gorm.services.Service

class MessageUsersService {

    def springSecurityService

    MessageService messageService
    UserService userService

    Message get(Serializable id){
        return messageService.get(id)
    }

    int count(){
        messageService.count()
    }

    List<Message> list(Map args){
        def user = springSecurityService.currentUser
        def messages = messageService.list(args)
        List<Message> res = []
        for(message in messages){
            if(user.username == "admin"){
                res.push(message)
            }
            else if(message.author.username == user.username || message.target.username == user.username) {
                res.push(message)
            }

        }
        return res
    }

    void delete(Serializable id){
        messageService.delete(id)
    }

    Message save(Message message){
        message.author = springSecurityService.currentUser.username
        def mes = message
        messageService.save(message)
    }


    List<User> userList(Map args){
        List<User> res = []
        def users =  userService.list(args)
        for (user in users){
            res.push(user.username)
        }
        return res
    }
}