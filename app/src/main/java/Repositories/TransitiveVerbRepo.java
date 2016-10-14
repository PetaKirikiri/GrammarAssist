package Repositories;

import java.util.ArrayList;

import Models.TransitiveVerb;

/**
 * Created by petakirikiri on 8/04/16.
 */
public class TransitiveVerbRepo {
    ArrayList<TransitiveVerb> transitiveVerbArrayList = new ArrayList<TransitiveVerb>();
    ArrayList<String> engArrayList = new ArrayList<String>();
    ArrayList<String> maoArrayList = new ArrayList<String>();
    ArrayList<String> maoTransitiveVerbArrayList = new ArrayList<String>();
    ArrayList<String> maoIntransitiveVerbArrayList = new ArrayList<String>();

    public ArrayList<String> getEngArrayList(String tense) {
        if (transitiveVerbArrayList == null || transitiveVerbArrayList.size() == 0){
            transitiveVerbArrayList = getTransitiveVerbArrayList();
        }
        for (int i = 0; i < transitiveVerbArrayList.size(); i++) {
            if (tense == "I") {
                engArrayList.add(transitiveVerbArrayList.get(i).getEngI().toString());
            }
            if (tense == "Kua") {
                engArrayList.add(transitiveVerbArrayList.get(i).getEngKua().toString());
            }
            if (tense == "Kei te") {
                engArrayList.add(transitiveVerbArrayList.get(i).getEngKeite().toString());
            }
            if (tense == "E ana") {
                engArrayList.add(transitiveVerbArrayList.get(i).getEngEana().toString());
            }
            if (tense == "Ka") {
                engArrayList.add(transitiveVerbArrayList.get(i).getEngKa().toString());
            }
            if (tense == "Me") {
                engArrayList.add(transitiveVerbArrayList.get(i).getEngMe().toString());
            }
            if (tense == "i") {
                engArrayList.add(transitiveVerbArrayList.get(i).getEngNegPast().toString());
            }
            if (tense == "i te") {
                engArrayList.add(transitiveVerbArrayList.get(i).getEngNegPresent().toString());
            }
            if (tense == "e") {
                engArrayList.add(transitiveVerbArrayList.get(i).getEngNegFuture().toString());
            }

        }
        return engArrayList;
    }

    public ArrayList<String> getMaoArrayList(){
        if (transitiveVerbArrayList == null || transitiveVerbArrayList.size() == 0){
            transitiveVerbArrayList = getTransitiveVerbArrayList();
        }
        for (int i = 0; i < transitiveVerbArrayList.size(); i++) {
            maoArrayList.add(transitiveVerbArrayList.get(i).getMao().toString());
        }
        return maoArrayList;
    }

    public ArrayList<String> getMaoTransitiveVerbArrayList(){
        if (transitiveVerbArrayList == null || transitiveVerbArrayList.size() == 0){
            transitiveVerbArrayList = getTransitiveVerbArrayList();
        }
        for (int i = 0; i < transitiveVerbArrayList.size(); i++) {
            if (transitiveVerbArrayList.get(i).getType().toString() == "Transitive"){
                maoTransitiveVerbArrayList.add(transitiveVerbArrayList.get(i).getMao().toString());
            }
        }
        return maoTransitiveVerbArrayList;
    }

    public ArrayList<String> getMaoIntransitiveArrayList(){
        if (transitiveVerbArrayList == null || transitiveVerbArrayList.size() == 0){
            transitiveVerbArrayList = getTransitiveVerbArrayList();
        }
        for (int i = 0; i < transitiveVerbArrayList.size(); i++) {
            if (transitiveVerbArrayList.get(i).getType().toString() == "Intransitive"){
                maoIntransitiveVerbArrayList.add(transitiveVerbArrayList.get(i).getMao().toString());
            }
        }
        return maoIntransitiveVerbArrayList;
    }
    public ArrayList<TransitiveVerb> getTransitiveVerbArrayList(){

        TransitiveVerb kai = new TransitiveVerb();
        kai.setMao("kai");
        kai.setEngI("ate");
        kai.setEngKua("eaten");
        kai.setEngKeite("eating");
        kai.setEngEana("eating");
        kai.setEngKa("will eat");
        kai.setEngMe("should eat");
        transitiveVerbArrayList.add(kai);

        TransitiveVerb piki = new TransitiveVerb();
        piki.setMao("piki");
        piki.setEngI("climbed");
        piki.setEngKua("climbed");
        piki.setEngKeite("climbing");
        piki.setEngEana("climbing");
        piki.setEngKa("will climb");
        piki.setEngMe("should climb");
        transitiveVerbArrayList.add(piki);

        TransitiveVerb whakatika = new TransitiveVerb();
        whakatika.setMao("whakatika");
        whakatika.setEngI("fixed");
        whakatika.setEngKua("fixed");
        whakatika.setEngKeite("fixing");
        whakatika.setEngEana("fixing");
        whakatika.setEngKa("will fix");
        whakatika.setEngMe("should fix");
        transitiveVerbArrayList.add(whakatika);


        return transitiveVerbArrayList;
    }

}
