package Repositories;

import java.util.ArrayList;

import Models.Adjective;
import Models.CoreNoun;
import Models.Determiner;
import Models.INoun;
import Models.IVerb;
import Models.IntransitiveVerb;
import Models.Pronoun;
import Models.Tam;
import Models.Thing;
import Models.TransitiveVerb;
import Translator.ActiveSentenceTranslator;
import Translator.ActiveVerbalSentence;

/**
 * Created by petakirikiri on 28/04/16.
 */
public class DefaultVerbalSentenceRepo {

    TamRepo tamRepo = new TamRepo();
    ArrayList<Tam> tamArrayList = tamRepo.getTamArrayList();
    Tam tense = tamArrayList.get(0);

    IntransitiveVerbRepo intransitiveVerbRepo = new IntransitiveVerbRepo();
    ArrayList<IntransitiveVerb> intransitiveVerbArrayList = intransitiveVerbRepo.getIntransitiveVerbArrayList();
    IVerb verb = intransitiveVerbArrayList.get(0);

    PronounRepo pronounRepo = new PronounRepo();
    ArrayList<Pronoun> pronounArrayList = pronounRepo.getPronounArrayList();
    INoun subject = pronounArrayList.get(0);

    DeterminerRepo determinerRepo = new DeterminerRepo();
    ArrayList<Determiner> determinerArrayList = determinerRepo.getDeterminerArrayList();
    Determiner determiner = determinerArrayList.get(0);

    CoreNounRepo coreNounRepo = new CoreNounRepo();
    ArrayList<CoreNoun> coreNounArrayList = coreNounRepo.getCoreNounArrayList();
    CoreNoun coreNoun = coreNounArrayList.get(0);

    AdjectiveRepo adjectiveRepo = new AdjectiveRepo();
    ArrayList<Adjective> adjectiveArrayList = adjectiveRepo.getAdjectiveArrayList();
    Adjective adjective = adjectiveArrayList.get(0);

    Thing objectThing = new Thing(determiner, coreNoun, adjective);

    ActiveVerbalSentence activeVerbalSentence = new ActiveVerbalSentence(tense, verb, subject, objectThing);

    public ActiveVerbalSentence getActiveVerbalSentence(){
        return activeVerbalSentence;
    }



}
