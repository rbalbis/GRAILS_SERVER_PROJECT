
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>



<div id="menu">
    <a href="user">
<div class="demo-card-wide mdl-card mdl-shadow--2dp" onclick="user()" style="display: inline-block">
    <div class="mdl-card__titleUser">

    </div>
    <div class="mdl-card__supporting-text">
    </div>
    <div class="mdl-card__actions mdl-card--border">
        Utilisateurs
    </div>
</div>
    </a>

    <a href="message">
<div class="demo-card-wide mdl-card mdl-shadow--2dp"  style="display: inline-block">
    <div class="mdl-card__titleMessage">

    </div>
    <div class="mdl-card__supporting-text">
    </div>
    <div class="mdl-card__actions mdl-card--border">
        Message
    </div>
</div>
    </a>
</div>

<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

</body>
</html>