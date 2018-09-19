<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'message.label', default: 'Message')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-message" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-message" class="content scaffold-list" role="main">
            <h1>Liste des messages</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            %{--<f:table collection="${messageList}" />--}%
            <table>
                <thead>
                <tr>
                    <th class="sortable" ><a href="/mbdstp/message/index?sort=target&amp;max=10&amp;order=asc">Target</a></th>

                    <th class="sortable" ><a href="/mbdstp/message/index?sort=view&amp;max=10&amp;order=asc">View</a></th>

                    <th class="sortable" ><a href="/mbdstp/message/index?sort=content&amp;max=10&amp;order=asc">Content</a></th>

                    <th class="sortable" ><a href="/mbdstp/message/index?sort=author&amp;max=10&amp;order=asc">Author</a></th>
                </tr>
                </thead>
                <tbody>
                <g:each var ="message" in="${messageList}">
                    <tr class="even">
                        <td><a href="/mbdstp/user/show/${message.target.id}">${message.target.username}</a></td>
                        <td>${message.view}</td>
                        <td>${message.content}</td>
                        <td><a href="/mbdstp/user/show/${message.target.id}">${message.author.username}</a></td>
                    </tr>
                </g:each>
                </tbody>
            </table>

            <div class="pagination">
                <g:paginate total="${messageCount ?: 0}" />
            </div>
        </div>
    </body>
</html>