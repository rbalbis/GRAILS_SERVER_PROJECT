<%@ page import="fr.mbds.tp.Role" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-user" class="content scaffold-create" role="main">
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.user}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.user}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:uploadForm resource="${this.user}" method="POST">
                <fieldset class="form">
                    <label>Username: </label>
                    <g:textField name="username"/><br/>
                    <label>Password: </label>
                    <g:passwordField name="password"/><br/>
                    <label>Rôle de utilisateur: </label>
                    <g:select name="role" from="${fr.mbds.tp.Role.findAll().authority}" value="${authority}"/>
                    <g:textField name="image" id="imageName" style="display: none;"/>
                    <br/>
                    <label>Image: </label>
                    <br/>
                    <div class="contentDrop" ondragover="allowDrop(event)" ondrop="drop(event)" style="display:inline-block;">
                         <div class="circle">
                             <svg fill="currentColor" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg">
                                 <path d="M0 0h24v24H0z" fill="none"/>
                                 <path d="M9 16h6v-6h4l-7-7-7 7h4zm-4 2h14v2H5z"/>
                             </svg>
                         </div>
                         <drop-zone id="dropZone">
                             <section slot="label">
                                 <div class="button-wrapper">
                                     <label id="nameImg" class="label" for="fileElem">Faites glisser l'image ici OU</label>
                                     <button type="button" id="button" class="btn" onclick="load()">Choisissez votre image</button>
                                     <input type="file" name="image2" id="file" class="file" multiple accept="image/*" onchange="afterLoad(this.files)">
                                 </div>
                             </section>
                         </drop-zone>
                    </div>
                    <img id="img" ondrop="drop(event)" ondragover="allowDrop(event)"/>
                </fieldset>
                <div id="list"></div>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:uploadForm>
        </div>
    <asset:javascript src="dragCreate.js"/>
    <asset:stylesheet src="drag.css"/>

    <style>
    .content{
        background-color: transparent!important;
    }
    </style>
    </body>
</html>
