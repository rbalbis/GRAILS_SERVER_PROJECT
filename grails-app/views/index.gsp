
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