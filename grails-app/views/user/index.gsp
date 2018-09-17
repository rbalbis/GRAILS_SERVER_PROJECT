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

                <header><div>Liste des utilisateurs</div></header>
                <div class="container">
                    <g:each var ="user" in="${userList}">

                        <a href="http://localhost:8081/mbdstp/user/edit/${user.id}">
                                <div class="box">

                               <img src="${grailsApplication.config.getProperty('fileUrl') + user.image}" alt="face">
                                <p class="username">${user.username}</p>
                                <p id="details">Matchs gagnés: ${user.matchWon.size()}</p>
                            </div>
                        </a>
                    </g:each>
                </div>
            </div>
        </div>


<asset:javascript src="indexUser.js"/>
<asset:stylesheet src="indexUser.css"/>

    </body>


    </html>