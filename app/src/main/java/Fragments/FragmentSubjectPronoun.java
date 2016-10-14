package Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.petakirikiri.easymaorifragments.MainActivity;
import com.example.petakirikiri.easymaorifragments.R;

import java.util.ArrayList;

import Adapters.NounSelectorAdapter;
import Adapters.PronounAdapter;
import Interface.Communicator;
import Models.Pronoun;
import Repositories.PronounRepo;
import Translator.ActiveVerbalSentence;

/**
 * Created by petakirikiri on 28/04/16.
 */
public class FragmentSubjectPronoun extends Fragment {

    ListView listView;
    Button btn_BackToMain;
    Communicator comm;

    ArrayList<Pronoun> pronounArrayList;
    PronounRepo pronounRepo;

    PronounAdapter pronounAdapter;

    MainActivity mainActivity;
    ActiveVerbalSentence currentSentence;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subject_pronoun, null, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();
        currentSentence = mainActivity.getActiveVerbalSentence();

        // Setup ListView

        listView = (ListView) getView().findViewById(R.id.SubjectPronounSelectionlistView);

        pronounRepo = new PronounRepo();
        pronounArrayList = pronounRepo.getPronounArrayList();
        pronounAdapter = new PronounAdapter(getActivity(), pronounArrayList);
        listView.setAdapter(pronounAdapter);


        // Setup onClickListener

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pronoun pronoun = pronounArrayList.get(position);
                currentSentence.setSubject(pronoun);
                comm.returnSentence(currentSentence);

            }
        });

        // Setup Button

        btn_BackToMain = (Button) getView().findViewById(R.id.tv_backToMain);

        btn_BackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comm.setMainFragment();
            }
        });

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (Communicator) getActivity();
    }
}
