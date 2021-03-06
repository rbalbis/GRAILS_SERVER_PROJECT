<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'resultat.label', default: 'Resultat')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-resultat" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-resultat" class="content scaffold-show" role="main" style="background-color: #EFEFEF">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
           <!-- <f:display bean="resultat" /> -->
            <div>

                <ul style="padding: 5em 10% 5em 10%;list-style-type: none">
                    <li style="padding-bottom: 2em">Nom d'utilisateur : ${this.resultat.Winner}</li>
                    <li style="padding-bottom: 2em">Nombre de message reçu : ${user.messageReceived.size()}</li>
                    <li style="padding-bottom: 2em">Match gagnés : ${user.matchWon.size()}</li>
                    <li style="padding-bottom: 2em">Matchs perdus : ${user.matchLost.size()}</li>
                </ul>

            </div>
            <g:form resource="${this.resultat}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.resultat}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Voulez vous vraiment supprimer ce resultat ?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
