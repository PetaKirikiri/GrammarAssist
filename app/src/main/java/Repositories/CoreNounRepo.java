package Repositories;

import java.util.ArrayList;

import Models.CoreNoun;

/**
 * Created by petakirikiri on 8/04/16.
 */
public class CoreNounRepo {
    ArrayList<CoreNoun> coreNounArrayList = new ArrayList<>();
    ArrayList<String> coreNounMaoriArrayList = new ArrayList<String>();
    ArrayList<String> coreNounEnglishArrayList = new ArrayList<String>();

    public ArrayList<String> getEngArrayList(){
        if (coreNounArrayList == null || coreNounArrayList.size() == 0){
            coreNounArrayList = getCoreNounArrayList();
        }
        for (int i = 0; i < coreNounArrayList.size(); i++) {
            coreNounEnglishArrayList.add(coreNounArrayList.get(i).getEng().toString());
        }
        return coreNounEnglishArrayList;
    }
    public ArrayList<String> getMaoThing(){
        if (coreNounArrayList== null || coreNounArrayList.size() == 0){
            coreNounArrayList = getCoreNounArrayList();
        }
        for (int i = 0; i < coreNounArrayList.size(); i++) {
            coreNounMaoriArrayList.add(coreNounArrayList.get(i).getMao());
        }
        return coreNounMaoriArrayList;
    }

    public ArrayList<CoreNoun> getCoreNounArrayList() {

        CoreNoun tāne = new CoreNoun();
        tāne.setEng("man");
        tāne.setEngPlural("men");
        tāne.setMao("tāne");
        coreNounArrayList.add(tāne);

        CoreNoun toa = new CoreNoun();
        toa.setEng("shop");
        toa.setEngPlural("shops");
        toa.setMao("toa");
        coreNounArrayList.add(toa);


        CoreNoun kura = new CoreNoun();
        kura.setEng("school");
        kura.setEngPlural("schools");
        kura.setMao("kura");
        coreNounArrayList.add(kura);


        CoreNoun kūmara = new CoreNoun();
        kūmara.setEng("sweet potato");
        kūmara.setEngPlural("sweet potatoes");
        kūmara.setMao("kūmara");
        coreNounArrayList.add(kūmara);

        CoreNoun wharenui = new CoreNoun();
        wharenui.setEng("meeting house");
        wharenui.setEngPlural("meeting houses");
        wharenui.setMao("wharenui");
        coreNounArrayList.add(wharenui);

        return coreNounArrayList;
    }
}
