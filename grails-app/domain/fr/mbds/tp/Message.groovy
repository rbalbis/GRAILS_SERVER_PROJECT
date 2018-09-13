package fr.mbds.tp

class Message {

    //Securiser message injection

    User author
    User target
    String content
    Boolean view = Boolean.FALSE


    static constraints = {
    }
}
