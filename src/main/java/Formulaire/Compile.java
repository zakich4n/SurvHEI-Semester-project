package Formulaire;

import Codage.Decode;
import Codage.Encode;

import java.util.ArrayList;

public class  Compile implements Encode, Decode {
    static final String SEPARATOR="#";
    static final String TERMINAL="|";


    @Override
    public String encode(Formulaire form) {


        String data = "";
        /*encodage de chaque page
        data=data
                .concat(page.getObligatoire()).concat(SEPARATOR)
                .concat(page.getGenre()).concat(SEPARATOR)
                .concat(page.getNumero()).concat(SEPARATOR)
                .concat(page.getType()).concat(SEPARATOR)
                .concat(page.getQuestion()).concat(SEPARATOR)
                .concat(page.getChoices()).concat(SEPARATOR)
                .concat(TERMINAL);
        */
        return data;
    }

    @Override // "Obligatoire[0]#Type[1]#Numero[2]#Genre[3]#Question[4]#Choix[5]#|"
    public Formulaire decode(String rawData) {
        String[] page = rawData.split(TERMINAL); //on departage le raw data avec le separateur terminal pour divise en page
        ArrayList<Page> Form=new ArrayList<Page>();
        for (int i=0; i<page.length-1; i++) { //la derniere case du tableau est l'indice d'anonymat en boolean donc on ne le prend pas
            String[] Question = page[i].split(SEPARATOR);
            switch (Question[3]){
                case "YesOrNo":
                    YesOrNO yn=new YesOrNO(Integer.parseInt(Question[2]),Question[4],Boolean.parseBoolean(Question[0]));
                    Form.add(yn);
                    break;
                case "MultipleChoice":
                    MultipleChoice multi=new MultipleChoice(Integer.parseInt(Question[2]),Question[4],Boolean.parseBoolean(Question[0]));
                    String[] Choix=Question[5].split(",");
                    for (int y=0; y< Choix.length;y++) {
                        multi.addChoice(Choix[y]);
                    }
                    Form.add(multi);
                    break;
            } //on cree la page correspondante si c'est une YesOrNo, MultiChoice etc
        }
        Formulaire result=new Formulaire(Boolean.parseBoolean(page[page.length-1]),Form);
        return result;
    }
}
