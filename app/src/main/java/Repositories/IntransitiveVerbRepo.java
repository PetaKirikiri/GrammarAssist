package Repositories;

import java.util.ArrayList;

import Models.IntransitiveVerb;

/**
 * Created by petakirikiri on 8/04/16.
 */
public class IntransitiveVerbRepo {
    ArrayList<IntransitiveVerb> intransitiveVerbArrayList = new ArrayList<IntransitiveVerb>();
    ArrayList<String> engArrayList = new ArrayList<String>();
    ArrayList<String> maoArrayList = new ArrayList<String>();
    ArrayList<String> maoTransitiveVerbArrayList = new ArrayList<String>();
    ArrayList<String> maoIntransitiveVerbArrayList = new ArrayList<String>();

    public ArrayList<String> getEngArrayList(String tense) {
        if (intransitiveVerbArrayList == null || intransitiveVerbArrayList.size() == 0){
            intransitiveVerbArrayList = getIntransitiveVerbArrayList();
        }
        for (int i = 0; i < intransitiveVerbArrayList.size(); i++) {
            if (tense == "I") {
                engArrayList.add(intransitiveVerbArrayList.get(i).getEngI().toString());
            }
            if (tense == "Kua") {
                engArrayList.add(intransitiveVerbArrayList.get(i).getEngKua().toString());
            }
            if (tense == "Kei te") {
                engArrayList.add(intransitiveVerbArrayList.get(i).getEngKeite().toString());
            }
            if (tense == "E ana") {
                engArrayList.add(intransitiveVerbArrayList.get(i).getEngEana().toString());
            }
            if (tense == "Ka") {
                engArrayList.add(intransitiveVerbArrayList.get(i).getEngKa().toString());
            }
            if (tense == "Me") {
                engArrayList.add(intransitiveVerbArrayList.get(i).getEngMe().toString());
            }
            if (tense == "i") {
                engArrayList.add(intransitiveVerbArrayList.get(i).getEngNegPast().toString());
            }
            if (tense == "i te") {
                engArrayList.add(intransitiveVerbArrayList.get(i).getEngNegPresent().toString());
            }
            if (tense == "e") {
                engArrayList.add(intransitiveVerbArrayList.get(i).getEngNegFuture().toString());
            }

        }
        return engArrayList;
    }

    public ArrayList<String> getMaoArrayList(){
        if (intransitiveVerbArrayList == null || intransitiveVerbArrayList.size() == 0){
            intransitiveVerbArrayList = getIntransitiveVerbArrayList();
        }
        for (int i = 0; i < intransitiveVerbArrayList.size(); i++) {
            maoArrayList.add(intransitiveVerbArrayList.get(i).getMao().toString());
        }
        return maoArrayList;
    }

    public ArrayList<String> getMaoIntransitiveVerbArrayList(){
        if (intransitiveVerbArrayList == null || intransitiveVerbArrayList.size() == 0){
            intransitiveVerbArrayList = getIntransitiveVerbArrayList();
        }
        for (int i = 0; i < intransitiveVerbArrayList.size(); i++) {
            if (intransitiveVerbArrayList.get(i).getType().toString() == "Transitive"){
                maoTransitiveVerbArrayList.add(intransitiveVerbArrayList.get(i).getMao().toString());
            }
        }
        return maoTransitiveVerbArrayList;
    }

    public ArrayList<String> getMaoIntransitiveArrayList(){
        if (intransitiveVerbArrayList == null || intransitiveVerbArrayList.size() == 0){
            intransitiveVerbArrayList = getIntransitiveVerbArrayList();
        }
        for (int i = 0; i < intransitiveVerbArrayList.size(); i++) {
            if (intransitiveVerbArrayList.get(i).getType().toString() == "Intransitive"){
                maoIntransitiveVerbArrayList.add(intransitiveVerbArrayList.get(i).getMao().toString());
            }
        }
        return maoIntransitiveVerbArrayList;
    }
    public ArrayList<IntransitiveVerb> getIntransitiveVerbArrayList(){

        IntransitiveVerb haere = new IntransitiveVerb();
        haere.setMao("haere");
        haere.setEngI("walked");
        haere.setEngKua("walked");
        haere.setEngKeite("walking");
        haere.setEngEana("walking");
        haere.setEngKa("will walk");
        haere.setEngMe("should walk");
        intransitiveVerbArrayList.add(haere);

        IntransitiveVerb oma = new IntransitiveVerb();
        oma.setMao("oma");
        oma.setEngI("ran");
        oma.setEngKua("run");
        oma.setEngKeite("running");
        oma.setEngEana("running");
        oma.setEngKa("will run");
        oma.setEngMe("should run");
        intransitiveVerbArrayList.add(oma);

        IntransitiveVerb hikoi = new IntransitiveVerb();
        hikoi.setMao("hikoi");
        hikoi.setEngI("walked");
        hikoi.setEngKua("walked");
        hikoi.setEngKeite("walking");
        hikoi.setEngEana("walking");
        hikoi.setEngKa("will walk");
        hikoi.setEngMe("should walk");
        intransitiveVerbArrayList.add(hikoi);

        return intransitiveVerbArrayList;
    }
}
