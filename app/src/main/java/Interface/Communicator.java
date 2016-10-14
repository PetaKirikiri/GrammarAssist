package Interface;

import Models.Determiner;
import Models.IVerb;
import Models.Pronoun;
import Models.Tam;
import Models.Thing;
import Models.TransitiveVerb;
import Translator.ActiveVerbalSentence;

/**
 * Created by petakirikiri on 28/04/16.
 */
public interface Communicator {
    void setFragmentSubjectSelector();

    void setFragmentSubjectPronoun();

    void setMainFragment();

    void setFragmentSubjectThingSelector();

    void setFragmentSubjectDeterminer();


    void returnSentence(ActiveVerbalSentence currentSentence);

    void setSubjectThingComponent(Thing subjectThing);

    void setFragmentSubjectThingCoreNoun();

    void setSubjectThing(Thing subjectThing);

    void setFragmentSubjectThingAdjective();

    void setFragmentTense();

    void setTense(Tam tam);

    void setFragmentVerb();

    void setFragmentTransitiveVerb();

    void setFragmentIntransitiveVerb();

    void setVerb(IVerb verb);

    void setFragmentObjectSelector();

    void setFragmentObjectPronoun();

    void setFragmentObjectThingSelector();

    void setObjectThing(Thing objectThing);

    void setFragmentObjectDeterminer();

    void setFragmentObjectThingCoreNoun();

    void setFragmentObjectThingAdjective();
}

