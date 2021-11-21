

document.getElementById("SignupForm").addEventListener("submit", function(e) {

    var user = document.getElementById("user");
    var email = document.getElementById("email");
    var nom = document.getElementById("nom");
    var prenom = document.getElementById("prenom");
    var datenaissance = document.getElementById("datenaissance");
    var mdp = document.getElementById("mdp");
    var mdpc = document.getElementById("mdpc");
    datenaissancel = datenaissance.value.getFullYear();

    if(mdp.value != mdpc.value){
        erreur="Veuillez entrer deux mots de passe identiques"
        m=mdp.value
        l=mdpc.value
    }
    if(!mdpc.value){
        erreur="Veuillez confirmer votre mot de passe"
    }
    if(!mdp.value){
        erreur="Veuillez entrer votre mot de passe"
    }
    if(!datenaissance.value){
        erreur = "Veuillez entrer votre date de naissance";
    }
    if(!prenom.value){
        erreur = "Veuillez entrer votre prénom";
    }
    if(!nom.value){
        erreur = "Veuillez entrer votre nom";
    }
    if(!email.value){
        erreur = "Veuillez entrer votre adresse email";
    }
    if(!user.value){
        erreur = "Veuillez entrer votre user";
    }
    if(datenaissancel < 2021)
    if(erreur){
        e.preventDefault();
        document.getElementById("erreur").innerHTML=erreur ;
        erreur=null;

    }else{
            alert('Successful Registration ! ');
    }

})

document.getElementById("loginForm").addEventListener("submit", function (f){
    var login = document.getElementById("login");
    var mdp = document.getElementById("password");



})