package Models;

import java.io.Serializable;

/**
 * Created by petakirikiri on 8/04/16.
 */
public class Thing implements INoun, Serializable {
    Determiner determiner;
    CoreNoun coreNoun;
    Adjective adjective;
    String maori, english;
    public Thing(Determiner determiner, CoreNoun coreNoun, Adjective adjective) {
        this.determiner = determiner;
        this.coreNoun = coreNoun;
        this.adjective = adjective;
    }


    public Determiner getDeterminer() {
        return determiner;
    }

    public void setDeterminer(Determiner determiner) {

        this.determiner = determiner;
    }

    public CoreNoun getCoreNoun() {
        return coreNoun;
    }

    public void setCoreNoun(CoreNoun coreNoun) {
        this.coreNoun = coreNoun;
    }

    public Adjective getAdjective() {
        return adjective;
    }

    public void setAdjective(Adjective adjective) {
        this.adjective = adjective;
    }


    @Override
    public String getMao() {
        maori = (determiner.getMao() + " " + coreNoun.getMao() + " " + adjective.getMao());
        return maori;
    }

    public String getEng(){
        if (determiner.getType() == "singular"){
            english = (determiner.getEng() + " " + adjective.getEng() + " " + coreNoun.getEng());
        }
        else if (determiner.getType() == "plural"){
            english = (determiner.getEng() + " " + adjective.getEng() + " " + coreNoun.getEngPlural());
        }

        return english;
    }

}
