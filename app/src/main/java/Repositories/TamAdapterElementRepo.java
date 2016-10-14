package Repositories;

import java.util.ArrayList;

import Models.Tam;
import Translator.ActiveSentenceTranslator;
import Translator.ActiveVerbalSentence;

/**
 * Created by petakirikiri on 11/05/16.
 */
public class TamAdapterElementRepo {
    TamRepo tamRepo = new TamRepo();


    ActiveVerbalSentence activeVerbalSentence;
    ActiveSentenceTranslator translator;

    ArrayList<Tam> tamArrayList;


}
