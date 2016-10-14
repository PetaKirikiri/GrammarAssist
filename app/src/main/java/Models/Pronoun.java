package Models;

import java.io.Serializable;

/**
 * Created by petakirikiri on 8/04/16.
 */
public class Pronoun implements INoun, Serializable {

    String eng;
    String mao;
    String aux;
    String kua;
    String object;

    // Getters, setter

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

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

    public String getAux() {
        return aux;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }

    public String getKua() {
        return kua;
    }

    public void setKua(String kua) {
        this.kua = kua;
    }
}
