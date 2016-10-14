package Repositories;

import java.util.ArrayList;

import Models.Adjective;
import Models.CoreNoun;
import Models.Determiner;
import Models.Thing;

/**
 * Created by petakirikiri on 28/04/16.
 */
public class DefaultThingRepo {

    DeterminerRepo determinerRepo = new DeterminerRepo();
    ArrayList<Determiner> determinerArrayList = determinerRepo.getDeterminerArrayList();
    Determiner determiner = determinerArrayList.get(0);

    CoreNounRepo coreNounRepo = new CoreNounRepo();
    ArrayList<CoreNoun> coreNounArrayList = coreNounRepo.getCoreNounArrayList();
    CoreNoun coreNoun = coreNounArrayList.get(0);

    AdjectiveRepo adjectiveRepo = new AdjectiveRepo();
    ArrayList<Adjective> adjectiveArrayList = adjectiveRepo.getAdjectiveArrayList();
    Adjective adjective = adjectiveArrayList.get(0);

    Thing thing = new Thing(determiner, coreNoun, adjective);

    public Thing getThing(){
        return thing;
    }
}
