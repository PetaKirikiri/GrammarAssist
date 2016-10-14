package Repositories;

import java.util.ArrayList;

import Models.Adjective;

/**
 * Created by petakirikiri on 8/04/16.
 */
public class AdjectiveRepo {
    ArrayList<Adjective> adjectiveArrayList = new ArrayList<Adjective>();
    ArrayList<String> englishAdjectiveArrayList = new ArrayList<String>();
    ArrayList<String> maoriAdjectiveArrayList = new ArrayList<String>();


    public ArrayList<String> getEngArrayList(){
        if (adjectiveArrayList == null || adjectiveArrayList.size() == 0){
            adjectiveArrayList = getAdjectiveArrayList();
        }
        for (int i = 0; i < adjectiveArrayList.size(); i++) {
            englishAdjectiveArrayList.add(adjectiveArrayList.get(i).getEng().toString());
        }
        return englishAdjectiveArrayList;
    }

    public ArrayList<String> getMaoArrayList(){
        if (adjectiveArrayList == null || adjectiveArrayList.size() == 0){
            adjectiveArrayList = getAdjectiveArrayList();
        }
        for (int i = 0; i < adjectiveArrayList.size(); i++) {
            maoriAdjectiveArrayList.add(adjectiveArrayList.get(i).getMao().toString());
        }
        return maoriAdjectiveArrayList;
    }

    public ArrayList<Adjective> getAdjectiveArrayList(){
        Adjective nui = new Adjective();
        nui.setEng("big");
        nui.setMao("nui");
        adjectiveArrayList.add(nui);

        Adjective iti = new Adjective();
        iti.setEng("little");
        iti.setMao("iti");
        adjectiveArrayList.add(iti);

        Adjective teitei = new Adjective();
        teitei.setEng("tall");
        teitei.setMao("teitei");
        adjectiveArrayList.add(teitei);

        Adjective poto = new Adjective();
        poto.setEng("short");
        poto.setMao("poto");
        adjectiveArrayList.add(poto);

        Adjective harikoa = new Adjective();
        harikoa.setEng("happy");
        harikoa.setMao("harikoa");
        adjectiveArrayList.add(harikoa);






        return adjectiveArrayList;
    }
}
