package Codage;

import Formulaire.Formulaire;

public interface Encode {
    /*
        Type : Question ou Affichage
        Question : "Habitez vous en France"
        Type de réponse : Oui ou Non
        Obligatoire : Oui

     */

    String EncodeFormulaire(Formulaire formulaire);

    String EncodeReponse();


}
