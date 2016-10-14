package Repositories;

import java.util.ArrayList;

import Models.Determiner;

/**
 * Created by petakirikiri on 8/04/16.
 */
public class DeterminerRepo {
    ArrayList<Determiner> determinerArrayList = new ArrayList<Determiner>();
    ArrayList<String> englishDeterminerArrayList = new ArrayList<String>();
    ArrayList<String> maoriDeterminerArrayList = new ArrayList<String>();

    public ArrayList<String> getEngArrayList(){
        if (determinerArrayList == null || determinerArrayList.size() == 0){
            determinerArrayList = getDeterminerArrayList();
        }
        for (int i = 0; i < determinerArrayList.size(); i++) {
            englishDeterminerArrayList.add(determinerArrayList.get(i).getEng().toString());
        }
        return englishDeterminerArrayList;
    }

    public ArrayList<String> getMaoArrayList(){
        if (determinerArrayList == null || determinerArrayList.size() == 0){
            determinerArrayList = getDeterminerArrayList();
        }
        for (int i = 0; i < determinerArrayList.size(); i++) {
            maoriDeterminerArrayList.add(determinerArrayList.get(i).getMao().toString());
        }
        return maoriDeterminerArrayList;
    }

    public ArrayList<Determiner> getDeterminerArrayList(){
        Determiner te = new Determiner();
        te.setEng("the");
        te.setMao("te");
        te.setType("singular");
        determinerArrayList.add(te);

        Determiner ngā = new Determiner();
        ngā.setEng("the");
        ngā.setMao("ngā");
        ngā.setType("plural");
        determinerArrayList.add(ngā);

        Determiner tētahi = new Determiner();
        tētahi.setEng("a");
        tētahi.setMao("tētahi");
        tētahi.setType("singular");
        determinerArrayList.add(tētahi);

        Determiner ētahi = new Determiner();
        ētahi.setEng("some");
        ētahi.setMao("ētahi");
        ētahi.setType("plural");
        determinerArrayList.add(ētahi);

        Determiner tēnei = new Determiner();
        tēnei.setEng("this");
        tēnei.setMao("tēnei");
        tēnei.setType("singular");
        determinerArrayList.add(tēnei);

        Determiner ēnei = new Determiner();
        ēnei.setEng("these");
        ēnei.setMao("ēnei");
        ēnei.setType("plural");
        determinerArrayList.add(ēnei);

        Determiner tērā = new Determiner();
        tērā.setEng("that");
        tērā.setMao("tērā");
        tērā.setType("singular");
        determinerArrayList.add(tērā);

        Determiner ērā = new Determiner();
        ērā.setEng("those");
        ērā.setMao("ērā");
        ērā.setType("plural");
        determinerArrayList.add(ērā);

        return determinerArrayList;
    }
}
