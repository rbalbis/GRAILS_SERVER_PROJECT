
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">

<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>
<header class="mdl-layout__header">
    <div class="mdl-layout__header-row">
        <!-- Title -->
        <a class="mdl-navigation__link" href="/mbdstp"><span class="mdl-layout-title">TP Grails</span></a>
        <!-- Add spacer, to align navigation to the right -->
        <div class="mdl-layout-spacer"></div>
        <!-- Navigation. We hide it in small screens. -->
        <nav class="mdl-navigation mdl-layout--large-screen-only">
<sec:ifLoggedIn>
    <span style="margin-right: 30px">
    Bonjour <sec:loggedInUserInfo field='username'/>
    </span>

</sec:ifLoggedIn>

        <sec:ifNotLoggedIn>
            <g:link controller='login' action='auth' style="color: white;">Connection</g:link>
        </sec:ifNotLoggedIn>
        <sec:ifLoggedIn>
            <g:link controller='logout' style="color: white;">Deconnexion</g:link>
        </sec:ifLoggedIn>

        </nav>
    </div>
</header>

<g:layoutBody/>


<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>

<style>
    h1{
    border-bottom: 1px solid #CCCCCC!important;
    margin: 0.8em 1em 0.3em!important;
    padding: 0 0.25em!important;
    font-weight: normal!important;
    font-size: 1.25em!important;
    margin: 0.8em 0 0.3em 0!important;
}
.demo-card-wide:hover{
    color: gray;
    opacity: 0.4;
}

.demo-card-wide{
    background-color: white;
}

.demo-card-wide{
    color: gray;
}
.demo-card-wide.mdl-card {
    margin: 10px;
    width: 380px;
}
.demo-card-wide.mdl-card-home {
    padding: 10px;
    margin: 10px;
    width: 340px;
}
.demo-card-wide > .mdl-card__titleMessage {
    color: #fff;
    height: 176px;
    background: url('assets/message.jpg') center / cover;
}

.demo-card-wide > .mdl-card__menu {
    color: #fff;
}

.value{
    float:right;
    color: #515d6e;
    font-size: 2.1em;
    font-weight: 600;
    margin-top: 40px;
    margin-right: 20px;
}

.img-menu{
    width: 100px;
    height: 100px;
    float: left;
}

#menu{
    margin-top: 150px;
    text-align: center;
}

</style>
</body>
</html>