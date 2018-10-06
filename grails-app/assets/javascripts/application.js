// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require bootstrap
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function($) {
        $(document).ajaxStart(function() {
            $('#spinner').fadeIn();
        }).ajaxStop(function() {
            $('#spinner').fadeOut();
        });
    })(jQuery);
}


var title = document.getElementsByClassName("mdl-layout-spacer")[0];

// page utilisateur
if(window.location.pathname.includes("user/index")){
    title.innerText = "Liste des utilisateurs";
}
else if(window.location.pathname.includes("user/create")){
    title.innerText = "Création d'un utilisiteur";
}
else if(window.location.pathname.includes("user/edit")){
    title.innerText = "Modifier un utilisiteur";
}
else if(window.location.pathname.includes("user/show")){
    title.innerText = "Presentation d'un utilisiteur";
}

// page message
if(window.location.pathname.includes("message/index")){
    title.innerText = "Liste des messages";
}
else if(window.location.pathname.includes("message/create")){
    title.innerText = "Création d'un message";
}
else if(window.location.pathname.includes("message/edit")){
    title.innerText = "Modifier un message";
}
else if(window.location.pathname.includes("message/show")){
    title.innerText = "Presentation d'un message";
}

// page match
if(window.location.pathname.includes("resultat/index")){
    title.innerText = "Liste des resultats";
}
else if(window.location.pathname.includes("resultat/create")){
    title.innerText = "Création d'un resultat";
}
else if(window.location.pathname.includes("resultat/edit")){
    title.innerText = "Modifier un resultat";
}
else if(window.location.pathname.includes("resultat/show")){
    title.innerText = "Presentation d'un resultat";
}


//{, data: form}