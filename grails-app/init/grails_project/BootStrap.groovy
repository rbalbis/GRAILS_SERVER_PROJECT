package fr.mbds.tp


class BootStrap {

    def init = { servletContext ->

        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush:true,failOnError:true)
        def gamingRole = new Role(authority: 'ROLE_USER').save(flush:true,failOnError:true)


        def adminUser = new User(username:'admin', password:'mdp').save(flush:true, failOnError:true)
        def playerUser1 = new User(username:'username1', password:'mdp').save(flush:true, failOnError:true)
        def playerUser2 = new User(username:'username2', password:'password').save(flush:true, failOnError:true)





        UserRole.create(adminUser,adminRole,true)
        UserRole.create(playerUser1,gamingRole,true)
        UserRole.create(playerUser2,gamingRole,true)




        new Resultat(winner: playerUser1,looser: playerUser2, winnerScore : 10, looserScore: 1).save(flush:true, failOnError:true)

        new Message(author: playerUser1, target: playerUser2, content: "blablabla").save(flush:true, failOnError:true)
        new Message(author: playerUser2, target: playerUser1, content: "ninini").save(flush:true, failOnError:true)
        new Message(author: adminUser, target: playerUser2, content: "Message de l'administrateur").save(flush:true, failOnError:true)


    }
    def destroy = {
    }
}
