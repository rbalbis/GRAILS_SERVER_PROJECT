<%@ page import="grails.plugin.springsecurity.SpringSecurityService" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-user" class="content scaffold-list" role="main">
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>



            <div class="wrapper">

                <div class="container">
                    <h2 class="title">Liste des utilisateurs</h2>
                    <div class="profil">
                        <g:each var ="user" in="${userList}">
                            <script>console.log(${user})</script>


                                <div class="demo-card-wide mdl-card mdl-shadow--2dp">
                                    <div class="main">
                                    <img class="profil_pic" src="${grailsApplication.config.getProperty('fileUrl') + user.image}" alt="face">

                                    <div class="mdl-card__title">
                                        <h2 class="mdl-card__title-text">${user.username}</h2>
                                    </div>
                                    <div class="mdl-card__supporting-text">
                                        <div class="win">Parties gagnés: ${user.matchWon.size()}</div>
                                        <div class="lost">Parties perdus : ${user.matchLost.size()}</div>

                                    </div>
                                    </div>
                                    <div class="mdl-card__actions mdl-card--border user_menu">
                                        <a class="profil_page mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="http://localhost:8081/mbdstp/user/show/${user.id}">
                                            <img class="logo" src="../assets/show.png" alt="show"/>
                                        </a>

                                         <a class="profil_page mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="http://localhost:8081/mbdstp/user/edit/${user.id}">
                                           <img class="logo" src="../assets/edit.png" alt="edit"/>
                                        </a>

                                        <a class="profil_page mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="http://localhost:8081/mbdstp/user/delete/${user.id}">
                                            <img class="logo" src="../assets/delete.png" alt="delete"/>
                                        </a>
                                    </div>

                                </div>







                            </a>
                    </g:each>
                    </div>
                </div>
            </div>
        </div>


<asset:javascript src="indexUser.js"/>
<asset:stylesheet src="indexUser.css"/>

    <style>
    .main:hover{
        background-color: #c9ced6!important;
    }
    </style>
    </body>


    </html>