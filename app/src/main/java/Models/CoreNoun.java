package Models;

import java.io.Serializable;

/**
 * Created by petakirikiri on 8/04/16.
 */
public class CoreNoun implements Serializable {

    String eng;
    String mao;
    String engPlural;

    // Setter, getter


    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getMao() {
        return mao;
    }

    public void setMao(String mao) {
        this.mao = mao;
    }

    public String getEngPlural() {
        return engPlural;
    }

    public void setEngPlural(String engPlural) {
        this.engPlural = engPlural;
    }
}
