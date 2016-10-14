package com.example.petakirikiri.easymaorifragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import Fragments.FragmentIntransitiveVerb;
import Fragments.FragmentMain;
import Fragments.FragmentObjectThingAdjective;
import Fragments.FragmentObjectThingCoreNoun;
import Fragments.FragmentObjectThingDeterminer;
import Fragments.FragmentObjectPronoun;
import Fragments.FragmentObjectSelector;
import Fragments.FragmentObjectThingSelector;
import Fragments.FragmentSubjectThingAdjective;
import Fragments.FragmentSubjectThingCoreNoun;
import Fragments.FragmentSubjectThingDeterminer;
import Fragments.FragmentSubjectThingSelector;
import Fragments.FragmentSubjectPronoun;
import Fragments.FragmentSubjectSelector;
import Fragments.FragmentTense;
import Fragments.FragmentTransitiveVerb;
import Fragments.FragmentVerbSelector;
import Interface.Communicator;
import Models.IVerb;
import Models.Tam;
import Models.Thing;
import Repositories.DefaultVerbalSentenceRepo;
import Translator.ActiveVerbalSentence;

public class MainActivity extends AppCompatActivity implements Communicator{

    ActiveVerbalSentence activeVerbalSentence;
    Thing tempThing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up welcome sentence structure

        DefaultVerbalSentenceRepo defaultRepo = new DefaultVerbalSentenceRepo();
        activeVerbalSentence = defaultRepo.getActiveVerbalSentence();

        // Connect Activity to XML file

        setContentView(R.layout.activity_main);

        // Set SubjectThingFramgnet into place

        setMainFragment();
    }

    @Override
    public void setMainFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentMain f1 = new FragmentMain();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();
    }
    @Override
    public void setFragmentSubjectSelector() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentSubjectSelector f1 = new FragmentSubjectSelector();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();
    }

    @Override
    public void setFragmentSubjectPronoun() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentSubjectPronoun f1 = new FragmentSubjectPronoun();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();
    }
    @Override
    public void setFragmentSubjectThingSelector() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentSubjectThingSelector f1 = new FragmentSubjectThingSelector();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();

    }

    @Override
    public void setFragmentSubjectDeterminer() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentSubjectThingDeterminer f1 = new FragmentSubjectThingDeterminer();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();
    }

    @Override
    public void setFragmentSubjectThingCoreNoun() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentSubjectThingCoreNoun f1 = new FragmentSubjectThingCoreNoun();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();
    }

    @Override
    public void setSubjectThing(Thing subjectThing) {
        activeVerbalSentence.setSubject(subjectThing);
    }

    @Override
    public void setFragmentSubjectThingAdjective() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentSubjectThingAdjective f1 = new FragmentSubjectThingAdjective();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();
    }

    @Override
    public void setFragmentTense() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentTense f1 = new FragmentTense();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();
    }

    @Override
    public void setTense(Tam tam) {
        activeVerbalSentence.setTense(tam);
        setMainFragment();
    }

    @Override
    public void setFragmentVerb() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentVerbSelector f1 = new FragmentVerbSelector();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();
    }

    @Override
    public void setFragmentTransitiveVerb() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentTransitiveVerb f1 = new FragmentTransitiveVerb();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();
    }

    @Override
    public void setFragmentIntransitiveVerb() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentIntransitiveVerb f1 = new FragmentIntransitiveVerb();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();
    }

    @Override
    public void setVerb(IVerb verb) {
        activeVerbalSentence.setVerb(verb);
        setMainFragment();
    }

    @Override
    public void setFragmentObjectSelector() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentObjectSelector f1 = new FragmentObjectSelector();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();
    }

    @Override
    public void setFragmentObjectPronoun() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentObjectPronoun f1 = new FragmentObjectPronoun();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();
    }

    @Override
    public void setFragmentObjectThingSelector() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentObjectThingSelector f1 = new FragmentObjectThingSelector();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();

    }

    @Override
    public void setObjectThing(Thing objectThing) {
        activeVerbalSentence.setObject(objectThing);
        setFragmentObjectThingSelector();
    }

    @Override
    public void setFragmentObjectDeterminer() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentObjectThingDeterminer f1 = new FragmentObjectThingDeterminer();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();
    }

    @Override
    public void setFragmentObjectThingCoreNoun() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentObjectThingCoreNoun f1 = new FragmentObjectThingCoreNoun();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();

    }

    @Override
    public void setFragmentObjectThingAdjective() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentObjectThingAdjective f1 = new FragmentObjectThingAdjective();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();

    }


    @Override
    public void returnSentence(ActiveVerbalSentence currentSentence) {
        activeVerbalSentence = currentSentence;
        setMainFragment();
    }

    @Override
    public void setSubjectThingComponent(Thing subjectThing) {
        activeVerbalSentence.setSubject(subjectThing);
        setFragmentSubjectThingSelector();
    }




    public ActiveVerbalSentence getActiveVerbalSentence(){
        return activeVerbalSentence;
    }
}
