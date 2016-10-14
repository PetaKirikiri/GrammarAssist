package Repositories;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import Models.Adjective;
import Models.CoreNoun;
import Models.Determiner;

/**
 * Created by petakirikiri on 13/04/16.
 */
public class ThingDataProvider {



    public static LinkedHashMap<String, List<String>> getInfo(){

        LinkedHashMap<String, List<String>> wordlist = new LinkedHashMap<String, List<String>>();
        DeterminerRepo determinerRepo = new DeterminerRepo();
        CoreNounRepo coreNounRepo = new CoreNounRepo();
        AdjectiveRepo adjectiveRepo = new AdjectiveRepo();

        ArrayList<Determiner> determinerArrayList = new ArrayList<Determiner>();
        ArrayList<CoreNoun> coreNounArrayList = new ArrayList<CoreNoun>();
        ArrayList<Adjective> adjectiveArrayList = new ArrayList<Adjective>();


        List<String> determiners = new ArrayList<String>();
        determinerArrayList = determinerRepo.getDeterminerArrayList();
        for (int i = 0; i < determinerArrayList.size(); i++){
            determiners.add(determinerArrayList.get(i).getMao());
        }

        List<String> coreNouns = new ArrayList<String>();
        coreNounArrayList = coreNounRepo.getCoreNounArrayList();
        for (int i = 0; i < coreNounArrayList.size(); i++){
            coreNouns.add(coreNounArrayList.get(i).getMao());
        }

        List<String> adjectives = new ArrayList<String>();;
        adjectiveArrayList = adjectiveRepo.getAdjectiveArrayList();
        for (int i = 0; i < adjectiveArrayList.size(); i++){
            adjectives.add(adjectiveArrayList.get(i).getMao());
        }

        wordlist.put("Determiners", determiners);
        wordlist.put("Things", coreNouns);
        wordlist.put("Adjectives", adjectives);

        return wordlist;
    }
}
