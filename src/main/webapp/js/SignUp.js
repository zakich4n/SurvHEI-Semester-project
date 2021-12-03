

document.getElementById("SignupForm").addEventListener("submit", function(e) {

    var user = document.getElementById("user");
    var email = document.getElementById("email");
    var nom = document.getElementById("nom");
    var prenom = document.getElementById("prenom");
    var datenaissance = document.getElementById("datenaissance");
    var mdp = document.getElementById("mdp");
    var mdpc = document.getElementById("mdpc");

    var erreur=null;

    if(mdp.value != mdpc.value){
        erreur="Veuillez entrer deux mots de passe identiques";
    }
    if(!mdpc.value){
        erreur="Veuillez confirmer votre mot de passe";
    }
    if(!mdp.value){
        erreur="Veuillez entrer votre mot de passe";
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


    if(erreur != null){
        e.preventDefault();
        document.getElementById("erreur").innerHTML=erreur ;
        return false;
    }else{
        alert('Successful Registration !');
        return true;
    }
})


let UniqueUser = function () {

    document.getElementById("UniqueUser").hidden = false;

}


