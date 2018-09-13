package fr.mbds.tp

import grails.gorm.services.Service

@Service(Resultat)
interface MatchService {

    Resultat get(Serializable id)

    List<Resultat> list(Map args)

    Long count()

    void delete(Serializable id)

    Resultat save(Resultat match)

}