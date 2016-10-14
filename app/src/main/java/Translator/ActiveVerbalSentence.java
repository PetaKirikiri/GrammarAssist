package Translator;

import Models.INoun;
import Models.IVerb;
import Models.Tam;

/**
 * Created by petakirikiri on 8/04/16.
 */
public class ActiveVerbalSentence {
    Tam tense;
    IVerb verb;
    INoun subject;
    INoun object;

    public ActiveVerbalSentence(Tam tense, IVerb verb, INoun subject, INoun object) {
        this.tense = tense;
        this.verb = verb;
        this.subject = subject;
        this.object = object;
    }


    public Tam getTense() {
        return tense;
    }

    public void setTense(Tam tense) {
        this.tense = tense;
    }

    public IVerb getVerb() {
        return verb;
    }

    public void setVerb(IVerb verb) {
        this.verb = verb;
    }

    public INoun getSubject() {
        return subject;
    }

    public void setSubject(INoun subject) {
        this.subject = subject;
    }

    public INoun getObject() {
        return object;
    }

    public void setObject(INoun object) {
        this.object = object;
    }




}
