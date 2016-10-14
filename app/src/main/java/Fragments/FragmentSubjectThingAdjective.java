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

import Adapters.AdjectiveAdapter;
import Adapters.CoreNounAdapter;
import Interface.Communicator;
import Models.Adjective;
import Models.CoreNoun;
import Models.Thing;
import Repositories.AdjectiveRepo;
import Translator.ActiveVerbalSentence;

/**
 * Created by petakirikiri on 29/04/16.
 */
public class FragmentSubjectThingAdjective extends Fragment {
    Button btn_BackToMain;
    Communicator comm;

    ListView listView;

    ActiveVerbalSentence currentSentence;

    MainActivity mainActivity;

    Thing subjectThing;
    AdjectiveRepo adjectiveRepo;
    ArrayList<Adjective> adjectiveArrayList;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subject_thing_adjective, null, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();
        currentSentence = mainActivity.getActiveVerbalSentence();

        subjectThing = (Thing) currentSentence.getSubject();


        // Setup TextView

        TextView tv_subjectThing = (TextView) view.findViewById(R.id.tv_subjectThing);

        tv_subjectThing.setText(subjectThing.getMao());

        // Setup ListView
        listView = (ListView) getView().findViewById(R.id.SubjectThingAdjectiveListView);

        adjectiveRepo= new AdjectiveRepo();
        adjectiveArrayList = adjectiveRepo.getAdjectiveArrayList();
        AdjectiveAdapter adjectiveAdapter = new AdjectiveAdapter(getActivity(), adjectiveArrayList);
        listView.setAdapter(adjectiveAdapter);


        // Setup onClickListener

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Adjective adjective = adjectiveArrayList.get(position);
                subjectThing.setAdjective(adjective);
                comm.setSubjectThingComponent(subjectThing);
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
