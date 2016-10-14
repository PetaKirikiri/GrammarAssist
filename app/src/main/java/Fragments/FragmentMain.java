package Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.petakirikiri.easymaorifragments.MainActivity;
import com.example.petakirikiri.easymaorifragments.R;

import Interface.Communicator;
import Models.Pronoun;
import Translator.ActiveSentenceTranslator;
import Translator.ActiveVerbalSentence;

/**
 * Created by petakirikiri on 27/04/16.
 */
public class FragmentMain extends Fragment {

    Button btn_tense, btn_verb, btn_subject, btn_object;

    TextView tv_maoriTense, tv_maoriVerb, tv_maoriSubject, tv_maoriDom, tv_maoriObject;
    TextView tv_englishVerb, tv_englishSubject, tv_englishObject;
    TextView tv_dom;

    ActiveSentenceTranslator translator;

    Communicator comm;
    ActiveVerbalSentence currentSentence;
    MainActivity mainActivity;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mainActivity = (MainActivity) getActivity();
        currentSentence = mainActivity.getActiveVerbalSentence();
        translator = new ActiveSentenceTranslator(currentSentence);


        return inflater.inflate(R.layout.fragment_main, null, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setup Buttons

        btn_tense = (Button)view.findViewById(R.id.btn_tense);
        btn_verb = (Button) view.findViewById(R.id.btn_verb);
        btn_subject = (Button) view.findViewById(R.id.btn_subject);
        btn_object = (Button) view.findViewById(R.id.btn_object);

        // Setup Māori TextViews

        tv_maoriTense = (TextView) view.findViewById(R.id.tv_maoriTense);
        tv_maoriVerb = (TextView) view.findViewById(R.id.tv_maoriVerb);
        tv_maoriSubject = (TextView) view.findViewById(R.id.tv_maoriSubject);
        tv_maoriDom = (TextView) view.findViewById(R.id.tv_maoriDom);
        tv_maoriObject = (TextView) view.findViewById((R.id.tv_maoriObject));

        tv_dom = (TextView) view.findViewById(R.id.tv_dom);
        tv_dom.setText(translator.getMaoriDom());

        // Setup English TextViews

        tv_englishSubject = (TextView) view.findViewById(R.id.tv_englishSubject);
        tv_englishVerb = (TextView) view.findViewById(R.id.tv_englishVerb);
        tv_englishObject = (TextView) view.findViewById(R.id.tv_englishObject);

        tv_englishSubject.setText(translator.getEngSubject() + " ");
        tv_englishVerb.setText(translator.getEnglishVerb() + " ");
        tv_englishObject.setText(translator.getEnglishObject());

        tv_maoriTense.setText(translator.getMaoriTense() + " ");
        tv_maoriVerb.setText(translator.getMaoriVerb() + " ");
        tv_maoriDom.setText(translator.getMaoriDom() + " ");
        tv_maoriSubject.setText(translator.getMaoriSubject() + " ");
        tv_maoriObject.setText(translator.getMaoriObject() + " ");

        btn_tense.setText(translator.getMaoriTense());
        btn_verb.setText(translator.getMaoriVerb());
        btn_subject.setText(translator.getMaoriSubject());
        btn_object.setText(translator.getMaoriObject());

        btn_tense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comm.setFragmentTense();
            }
        });

        btn_verb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comm.setFragmentVerb();
            }
        });
        btn_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comm.setFragmentSubjectSelector();
            }
        });

        btn_object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comm.setFragmentObjectSelector();
            }
        });
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (Communicator) getActivity();
    }


}
