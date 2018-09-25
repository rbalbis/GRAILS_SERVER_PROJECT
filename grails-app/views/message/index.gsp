<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'message.label', default: 'Message')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-message" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-message" class="content scaffold-list" role="main">
    <h1>Liste des messages</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
%{--<f:table collection="${messageList}" />--}%
%{--        <table>
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
        </table>--}%


    <g:each var="message" in="${messageList}">

        <div class='ui'>
            <div class='widget'>
                <div class='widget-conversation'>
                    <ul id='conversation'>

                        <li class='message-left'>
                            <div class='message-avatar'>
                                <img class="img" src="http://127.0.0.1:8888/${message.author.image}">

                                <div class='name'>
                                    <span class="mdl-chip mdl-chip--contact">
                                        <span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">${message.author.username[0].toUpperCase()}</span>
                                        <span class="mdl-chip__text">
                                            ${message.author.username}</span>
                                    </span>
                                </div>
                            </div>

                            <div class='message-avatar-right'>
                                <img class="img" src="http://127.0.0.1:8888/${message.target.image}">

                                <div class='name'>
                                    <span class="mdl-chip mdl-chip--contact">
                                        <span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">${message.target.username[0].toUpperCase()}</span>
                                        <span class="mdl-chip__text">${message.target.username}</span>
                                    </span>
                                </div>
                            </div>

                            <div class='message-text'>${message.content}</div>

                            <div class='message-hour' style="visibility: hidden">08:55 <span
                                    class='ion-android-done-all'></span></div>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
    </g:each>

    <div class="pagination">
        <g:paginate total="${messageCount ?: 0}"/>
    </div>
</div>

<style>

.img {
    width: 60px;
    height: 60px;
    border-radius: 50%;
}

ul {
    list-style: none;
}

li.message-left {
    margin-bottom: 50px;
}

.message-text {
    max-width: calc(100% - 400px);
    padding: 12px;
    border-radius: 4px;
    background-color: #e7e9f2;
    line-height: 1.1;
    color: #263959;
}

li.message-left > .message-text {
    text-align: left;
    margin-left: 90px;
    margin-right: 50px;
}

li.message-right > .message-text {
    text-align: right;
}

.message-text:before {
    content: ' ';
    position: absolute;
    width: 0;
    height: 0;
    top: 10px;
    border: 8px solid;
}

li.message-left > .message-text:before {
    left: 73.5px;
    border-color: transparent #e7e9f2 transparent transparent;
}

li:nth-child(even).message-right > .message-text:before {
    right: 45px;
    border-color: transparent transparent transparent #e7e9f2;
}

li.message-left,
li.message-right {
    position: relative;
    margin-left: 120px;
}

.message-avatar {
    width: 40px;
}

li.message-left > .message-avatar {
    float: left;
}

li.message-right > .message-avatar {
    float: right;
}

li.message-left > .message-avatar-right {
    float: right;
    margin-right: 180px;
}

.avatar {
    width: 40px;
    height: 40px;
    border-radius: 20px;
    font-size: 3.1em;
    line-height: 40px;
    text-align: center;
    overflow: hidden;
}

li.message-left .avatar {
    float: left;
    color: #9bc6b6;
    background-color: #55967e;
}

li.message-right .avatar {
    float: right;
    color: #b3becc;
    background-color: #6d819c;
}

.name {
    font-size: 1em;
    color: #6d819c;
    text-align: center;
}

.message-avatar, .message-text,
.message-hour, button {
    -webkit-transition: all 0.6s ease;
    -moz-transition: all 0.6s ease;
    -ms-transition: all 0.6s ease;
    -o-transition: all 0.6s ease;
    transition: all 0.6s ease;
}
</style>
</body>
</html>