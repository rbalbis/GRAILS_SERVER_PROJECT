<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'resultat.label', default: 'Resultat')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-resultat" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-resultat" class="content scaffold-list" role="main" style="background-color: #EFEFEF;padding-bottom: 5em">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table style="width: 80%;margin-left: 10%">
                <tr>
                    <th>Gagnant</th>
                    <th>Perdant</th>
                    <th>Score gagant</th>
                    <th>Score perdant</th>
                </tr>
            <g:each var="result" in="${resultatList}">
                <tr>
                    <th><a href="../user/show/${result.winner.id}">${result.winner.username}</a></th>
                    <th><a href="../user/show/${result.looser.id}">${result.looser.username}</a></th>
                    <th>${result.winnerScore}</th>
                    <th>${result.looserScore}</th>
                </tr>
        </g:each>
            </table>
            <div>

        </div>
    </body>
</html>