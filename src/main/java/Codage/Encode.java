package Codage;

import Formulaire.Formulaire;
import Formulaire.Page;

public interface Encode {
     /*
        Passage de Formulaire à RawData
        Passage de Reponse à Raw data
     */

    String encode(Page page);

}
