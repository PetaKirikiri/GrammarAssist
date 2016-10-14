package Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.petakirikiri.easymaorifragments.MainActivity;
import com.example.petakirikiri.easymaorifragments.R;

import java.util.ArrayList;

import Adapters.NounSelectorAdapter;
import Interface.Communicator;
import Models.INoun;
import Models.Pronoun;
import Models.Thing;
import Repositories.DefaultThingRepo;
import Translator.ActiveVerbalSentence;

/**
 * Created by petakirikiri on 28/04/16.
 */
public class FragmentSubjectThingSelector extends Fragment {
    Button btn_BackToMain;
    ListView listView;

    Communicator comm;

    ActiveVerbalSentence oldSentence, newSentence;

    Thing subjectThing;

    MainActivity mainActivity;

    TextView tv_subjectThing;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subject_thing_selector, null, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv_subjectThing = (TextView) view.findViewById(R.id.tv_subjectThing);
        // Get oldSentence

        mainActivity = (MainActivity) getActivity();
        oldSentence = mainActivity.getActiveVerbalSentence();
        INoun tempNoun = oldSentence.getSubject();

        if (tempNoun instanceof Pronoun){
            DefaultThingRepo defaultThingRepo = new DefaultThingRepo();
            subjectThing = defaultThingRepo.getThing();
            tv_subjectThing.setText(subjectThing.getMao());
        }
        else {
            subjectThing = (Thing) oldSentence.getSubject();
            tv_subjectThing.setText(oldSentence.getSubject().getMao());
        }

        // Update TextView



        newSentence = oldSentence;



        // Setup ListView

        listView = (ListView) getView().findViewById(R.id.SubjectSelectionlistView);

        ArrayList<String> nouns = new ArrayList<String>();
        nouns.add(0, "Determiner");
        nouns.add(1, "Core Noun");
        nouns.add(2, "Adjective");
        NounSelectorAdapter myAdapter = new NounSelectorAdapter(getActivity(), nouns);
        listView.setAdapter(myAdapter);

        // Setup Button

        btn_BackToMain = (Button) getView().findViewById(R.id.tv_backToMain);

        btn_BackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comm.setMainFragment();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) parent.getItemAtPosition(position);
                if (selected == "Determiner"){
                    comm.setSubjectThing(subjectThing);
                    comm.setFragmentSubjectDeterminer();
                }
                else if (selected == "Core Noun"){
                    comm.setSubjectThing(subjectThing);
                    comm.setFragmentSubjectThingCoreNoun();
                }
                else if (selected == "Adjective"){
                    comm.setSubjectThing(subjectThing);
                    comm.setFragmentSubjectThingAdjective();
                }
            }
        });

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (Communicator) getActivity();
    }
}
