package Models;

import java.io.Serializable;

/**
 * Created by petakirikiri on 8/04/16.
 */
public class Determiner implements Serializable {

    String eng;
    String mao;
    String type;

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

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }
}
