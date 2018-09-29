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


                                <div class="demo-card-wide mdl-card mdl-shadow--2dp">
                                    <div>
                                        <div class="profil_pic_div"><img class="profil_pic" src="${grailsApplication.config.getProperty('fileUrl') + user.image}" alt="face"></div>

                                        <div class="mdl-card__title text_card">
                                            <h2 class="mdl-card__title-text">${user.username}</h2>
                                        </div>

                                        <div class="mdl-card__supporting-text text_card">
                                            <div class="win">Parties gagnés: ${user.matchWon.size()}</div>
                                            <div class="lost">Parties perdus : ${user.matchLost.size()}</div>
                                        </div>
                                    </div>
                                    <div class="mdl-card__actions mdl-card--border user_menu">
                                        <g:link resource="user" class="link" action="show" id="${user.id}"><img class="logo" src="../assets/show.png" alt="show"/></g:link>

                                        <g:link resource="user" class="link" action="edit" id="${user.id}"><img class="logo" src="../assets/edit.png" alt="edit"/></g:link>

                                        <g:link resource="user" class="link" action="delete" id="${user.id}"><img class="logo" src="../assets/delete.png" alt="delete/${user.id}"/>
                                        </g:link>
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

    </body>
    </html>