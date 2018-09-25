
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>



<div id="menu">
    <a href="user/index" style="text-decoration: none">
<div class="demo-card-wide mdl-card-home mdl-shadow--2dp" style="display: inline-block">
    <div class="mdl-card__titleUser">
        <img src="assets/user.png" class="img-menu"/>
        <span class="value">Utilisateurs</span>
    </div>
</div>
    </a>
    <a href="message/index" style="text-decoration: none">
        <div class="demo-card-wide mdl-card-home mdl-shadow--2dp" style="display: inline-block">
            <div class="mdl-card__titleUser">
                <img src="assets/message.png" class="img-menu"/>
                <span class="value">Messages</span>
            </div>
        </div>
    </a>
    <a href="resultat/index" style="text-decoration: none">
        <div class="demo-card-wide mdl-card-home mdl-shadow--2dp" style="display: inline-block">
            <div class="mdl-card__titleUser">
                <img src="assets/results.png" class="img-menu"/>
                <span class="value">Résultats</span>
            </div>
        </div>
    </a>
</div>

<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

</body>
</html>