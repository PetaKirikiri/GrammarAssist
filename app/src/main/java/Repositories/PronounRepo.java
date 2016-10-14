package Repositories;

import java.util.ArrayList;

import Models.Pronoun;

/**
 * Created by petakirikiri on 8/04/16.
 */
public class PronounRepo {
    ArrayList<Pronoun> pronounArrayList = new ArrayList<Pronoun>();
    ArrayList<String> engArrayList = new ArrayList<String>();
    ArrayList<String> maoArrayList = new ArrayList<String>();

    public ArrayList<String> getEngArrayList(){
        if (pronounArrayList == null || pronounArrayList.size() == 0){
            pronounArrayList = getPronounArrayList();
        }
        for (int i = 0; i < pronounArrayList.size(); i++) {
            engArrayList.add(pronounArrayList.get(i).getEng().toString());
        }
        return maoArrayList;
    }

    public ArrayList<String> getMaoArrayList(){
        if (pronounArrayList == null || pronounArrayList.size() == 0){
            pronounArrayList = getPronounArrayList();
        }
        for (int i = 0; i < pronounArrayList.size(); i++) {
            maoArrayList.add(pronounArrayList.get(i).getMao().toString());
        }
        return maoArrayList;
    }

    public ArrayList<Pronoun> getPronounArrayList() {
        Pronoun ahau = new Pronoun();
        ahau.setEng("I");
        ahau.setMao("ahau");
        ahau.setAux("am");
        ahau.setKua("have");
        ahau.setObject("me");
        pronounArrayList.add(ahau);

        Pronoun koe = new Pronoun();
        koe.setEng("You");
        koe.setMao("koe");
        koe.setAux("are");
        koe.setKua("have");
        koe.setObject("you");
        pronounArrayList.add(koe);

        Pronoun ia = new Pronoun();
        ia.setEng("He / She");
        ia.setMao("ia");
        ia.setAux("is");
        ia.setKua("has");
        ia.setObject("him / her");
        pronounArrayList.add(ia);

        Pronoun tāua = new Pronoun();
        tāua.setEng("We (me and you)");
        tāua.setMao("tāua");
        tāua.setAux("are");
        tāua.setKua("have");
        tāua.setObject("us (me and you");
        pronounArrayList.add(tāua);

        Pronoun māua = new Pronoun();
        māua.setEng("We (not you)");
        māua.setMao("māua");
        māua.setAux("are");
        māua.setKua("have");
        māua.setObject("us ( me and him/her)");
        pronounArrayList.add(māua);

        Pronoun kōrua = new Pronoun();
        kōrua.setEng("You two");
        kōrua.setMao("kōrua");
        kōrua.setAux("are");
        kōrua.setKua("have");
        kōrua.setObject("you two");
        pronounArrayList.add(kōrua);

        Pronoun rāua = new Pronoun();
        rāua.setEng("They");
        rāua.setMao("rāua");
        rāua.setAux("are");
        rāua.setKua("have");
        rāua.setObject("them");
        pronounArrayList.add(rāua);

        Pronoun tātou = new Pronoun();
        tātou.setEng("We (3+)");
        tātou.setMao("tātou");
        tātou.setAux("are");
        tātou.setKua("have");
        tātou.setObject("us all");
        pronounArrayList.add(tātou);

        Pronoun mātou = new Pronoun();
        mātou.setEng("We (3+ not you)");
        mātou.setMao("mātou");
        mātou.setAux("are");
        mātou.setKua("have");
        mātou.setObject("us");
        pronounArrayList.add(mātou);

        Pronoun kōutou = new Pronoun();
        kōutou.setEng("You (3+)");
        kōutou.setMao("kōutou");
        kōutou.setAux("are");
        kōutou.setKua("have");
        kōutou.setObject("you all");
        pronounArrayList.add(kōutou);

        Pronoun rātou = new Pronoun();
        rātou.setEng("They (3+)");
        rātou.setMao("rātou");
        rātou.setAux("are");
        rātou.setKua("have");
        rātou.setObject("them");
        pronounArrayList.add(rātou);

        return pronounArrayList;
    }
}
