package Formulaire;

import Codage.Encode;

public class  Compile implements Encode {
    static final String SEPARATOR="#";
    static final String TERMINAL="|";


    @Override
    public String encode(Page page) {
        String data = "";

        data=data
                .concat(page.getObligatoire()).concat(SEPARATOR)
                .concat(page.getGenre()).concat(SEPARATOR)
                .concat(page.getNumero()).concat(SEPARATOR)
                .concat(page.getType()).concat(SEPARATOR)
                .concat(page.getQuestion()).concat(SEPARATOR)
                .concat(page.getChoices()).concat(SEPARATOR)
                .concat(TERMINAL);

        return data;
    }
}
