package Translator;

import Interface.Communicator;
import Models.INoun;
import Models.IVerb;
import Models.IntransitiveVerb;
import Models.Pronoun;
import Models.Tam;
import Models.Thing;
import Models.TransitiveVerb;

/**
 * Created by petakirikiri on 8/04/16.
 */
public class ActiveSentenceTranslator implements ITranslator {
    ActiveVerbalSentence activeVerbalSentence;
    String maoriSentence;
    String englishSentence;

    Tam tense;
    IVerb verb;
    INoun subject;
    INoun object;

    Communicator comm;

    String engTense, engVerb, engSubject, engObject;
    String maoDom;

    // Constructor takes in an ActiveSentence object

    public ActiveSentenceTranslator(ActiveVerbalSentence activeVerbalSentence) {
        this.activeVerbalSentence = activeVerbalSentence;
        tense = activeVerbalSentence.getTense();
        verb = activeVerbalSentence.getVerb();
        subject = activeVerbalSentence.getSubject();
        object = activeVerbalSentence.getObject();
    }

    // Get Māori Sentences

    public String getMaoriSentence(){
        if (object instanceof Pronoun) {
            if (verb instanceof IntransitiveVerb) {
                maoriSentence = (tense.getMao() + " " + verb.getMao() + " " + subject.getMao() + " ki a " + object.getMao());
            } else {
                maoriSentence = (tense.getMao() + " " + verb.getMao() + " " + subject.getMao() + " i a " + object.getMao());
            }
        }
        else if (object instanceof Thing){
            if (verb instanceof IntransitiveVerb) {
                maoriSentence = (tense.getMao() + " " + verb.getMao() + " " + subject.getMao() + " ki " + object.getMao());
            } else {
                maoriSentence = (tense.getMao() + " " + verb.getMao() + " " + subject.getMao() + " i " + object.getMao());
            }
        }
        return maoriSentence;
    }

    public String getMaoriTense(){
            return tense.getMao();
    }

    public String getMaoriVerb(){
            return verb.getMao();

    }

    public String getMaoriSubject(){
        return subject.getMao();
    }

    public String getMaoriObject(){
        String newObject;
        if (object instanceof Pronoun && object.getMao() != "ahau"){
            newObject = ("a " + object.getMao());
            return newObject;
        }
        else {
            return object.getMao();
        }
    }

    public String getMaoriDom(){
        if (verb instanceof IntransitiveVerb){
            maoDom = "ki";
        }
        else {
            maoDom = "i";
        }

        return maoDom;
    }

    // Get English Sentences

    public String getEnglishSentence(){
        engTense = tense.getMao();
        getEngSubject();
        getEnglishVerb();
        getEnglishObject();

        if (verb instanceof IntransitiveVerb){
            englishSentence = (engSubject + " " + engVerb + " to " + engObject);
        }
        else englishSentence = (engSubject + " " + engVerb + " " + engObject);

        return englishSentence;
    }

    public String getEnglishObject() {
        if (object instanceof Pronoun){
            engObject = ((Pronoun) object).getObject();
        }
        else if (object instanceof Thing){
            engObject = ((Thing) object).getEng();
        }
        return engObject;
    }

    public String getEnglishVerb() {
        if (verb instanceof IntransitiveVerb){
            getIntransitiveVerb();
        }
        else if (tense.getMao() == "I") {
            engVerb = verb.getEngI();
        }
        else if (tense.getMao() == "Kua"){
            engVerb = verb.getEngKua();
            if (subject instanceof Pronoun){
                engSubject = (((Pronoun) subject).getEng() + " " + ((Pronoun) subject).getKua());
            }
            else if (subject instanceof Thing){
                if (((Thing) subject).getDeterminer().getType() == "singular") {
                    engSubject = (((Thing) subject).getEng() + " has ");
                }
                else if (((Thing) subject).getDeterminer().getType() == "plural"){
                    engSubject = (((Thing) subject).getEng() + " have " );
                }
            }
        }
        else if (tense.getMao() == "Kei te"){
            engVerb = verb.getEngKeite();
            if (subject instanceof Pronoun){
                engSubject = (((Pronoun) subject).getEng() + " " + ((Pronoun) subject).getAux());
            }
            else if (subject instanceof Thing){
                if (((Thing) subject).getDeterminer().getType() == "singular") {
                    engSubject = (((Thing) subject).getEng() + " is ");
                }
                else if (((Thing) subject).getDeterminer().getType() == "plural"){
                    engSubject = (((Thing) subject).getEng() + " are " );
                }
            }
        }
        else if (tense.getMao() == "E ana"){
            engVerb = verb.getEngEana();
            if (subject instanceof Pronoun){
                engSubject = (((Pronoun) subject).getEng() + " " + ((Pronoun) subject).getAux());
            }
            if (subject instanceof Pronoun){
                engSubject = (((Pronoun) subject).getEng() + " " + ((Pronoun) subject).getAux());
            }
            else if (subject instanceof Thing){
                if (((Thing) subject).getDeterminer().getType() == "singular") {
                    engSubject = (((Thing) subject).getEng() + " is ");
                }
                else if (((Thing) subject).getDeterminer().getType() == "plural"){
                    engSubject = (((Thing) subject).getEng() + " are " );
                }
            }
        }
        else if (tense.getMao() == "Ka"){
            engVerb = verb.getEngKa();
        }
        else if (tense.getMao() == "Me"){
            engVerb = verb.getEngMe();
        }
        return engVerb;


    }

    public String getEngSubject() {
        if (tense.getMao() == "Kei te"){
            if (subject instanceof Pronoun){
                engSubject = (((Pronoun) subject).getEng() + " " + ((Pronoun) subject).getAux());
            }
            else if (subject instanceof Thing){
                if (((Thing) subject).getDeterminer().getType() == "Singular"){
                    engSubject = ((Thing) subject).getEng() + " is";
                }
                else {
                    engSubject = ((Thing) subject).getEng() + " are";
                }

            }
            String cap = engSubject.substring(0, 1).toUpperCase() + engSubject.substring(1);
            return cap;
        }
        else if (tense.getMao() == "Kua"){
            if (subject instanceof Pronoun){
                engSubject = (((Pronoun) subject).getEng() + " " + ((Pronoun) subject).getKua());
            }
            else if (subject instanceof Thing){
                if (((Thing) subject).getDeterminer().getType() == "Singular"){
                    engSubject = ((Thing) subject).getEng() + " has";
                }
                else {
                    engSubject = ((Thing) subject).getEng() + " have";
                }

            }
            String cap = engSubject.substring(0, 1).toUpperCase() + engSubject.substring(1);
            return cap;
        }
        else {
            if (subject instanceof Pronoun) {
                engSubject = ((Pronoun) subject).getEng();
            } else if (subject instanceof Thing) {
                engSubject = ((Thing) subject).getEng();
            }
            String cap = engSubject.substring(0, 1).toUpperCase() + engSubject.substring(1);
            return cap;
        }
    }


    public String getIntransitiveVerb() {
        if (tense.getMao() == "I") {
            engVerb = verb.getEngI() + " to";
        }
        else if (tense.getMao() == "Kua"){
            engVerb = verb.getEngKua() + " to";
            if (subject instanceof Pronoun){
                engSubject = (((Pronoun) subject).getEng() + " " + ((Pronoun) subject).getKua());
            }
            else if (subject instanceof Thing){
                if (((Thing) subject).getDeterminer().getType() == "singular") {
                    engSubject = (((Thing) subject).getEng() + " has ");
                }
                else if (((Thing) subject).getDeterminer().getType() == "plural"){
                    engSubject = (((Thing) subject).getEng() + " have " );
                }
            }
        }
        else if (tense.getMao() == "Kei te"){
            engVerb = verb.getEngKeite() + " to";
            if (subject instanceof Pronoun){
                engSubject = (((Pronoun) subject).getEng() + " " + ((Pronoun) subject).getAux());
            }
            else if (subject instanceof Thing){
                if (((Thing) subject).getDeterminer().getType() == "singular") {
                    engSubject = (((Thing) subject).getEng() + " is ");
                }
                else if (((Thing) subject).getDeterminer().getType() == "plural"){
                    engSubject = (((Thing) subject).getEng() + " are " );
                }
            }
        }
        else if (tense.getMao() == "E ana"){
            engVerb = verb.getEngEana() + " to";
            if (subject instanceof Pronoun){
                engSubject = (((Pronoun) subject).getEng() + " " + ((Pronoun) subject).getAux());
            }
            if (subject instanceof Pronoun){
                engSubject = (((Pronoun) subject).getEng() + " " + ((Pronoun) subject).getAux());
            }
            else if (subject instanceof Thing){
                if (((Thing) subject).getDeterminer().getType() == "singular") {
                    engSubject = (((Thing) subject).getEng() + " is ");
                }
                else if (((Thing) subject).getDeterminer().getType() == "plural"){
                    engSubject = (((Thing) subject).getEng() + " are " );
                }
            }
        }
        else if (tense.getMao() == "Ka"){
            engVerb = verb.getEngKa() + " to";
        }
        else if (tense.getMao() == "Me"){
            engVerb = verb.getEngMe() + " to";
        }
        return engVerb;
    }
}
