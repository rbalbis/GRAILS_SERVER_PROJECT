package fr.mbds.tp

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    String image
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        image nullable: true, blank: true, unique: true, size: 1..999999
    }

    static mapping = {
	    password column: '`password`'
    }

    static hasMany = [matchWon:Resultat,
                      matchLost:Resultat,
                      messageSent: Message,
                      messageReceived:Message]

    static mappedBy = [matchWon: "winner",
                       matchLost: "looser",
                       messageSent: "author",
                       messageReceived: "target"]



}
