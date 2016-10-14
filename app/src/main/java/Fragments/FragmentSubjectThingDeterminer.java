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

import Adapters.DeterminerAdapter;
import Interface.Communicator;
import Models.Determiner;
import Models.Thing;
import Repositories.DeterminerRepo;
import Translator.ActiveVerbalSentence;

/**
 * Created by petakirikiri on 28/04/16.
 */
public class FragmentSubjectThingDeterminer extends Fragment{

    Button btn_BackToMain;
    Communicator comm;

    ListView listView;

    ActiveVerbalSentence currentSentence;

    MainActivity mainActivity;

    Thing subjectThing;
    DeterminerRepo determinerRepo;
    ArrayList<Determiner> determinerArrayList;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subject_thing_determiner, null, false);

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
        listView = (ListView) getView().findViewById(R.id.SubjectThingDeterminerListView);

        determinerRepo = new DeterminerRepo();
        determinerArrayList = determinerRepo.getDeterminerArrayList();
        DeterminerAdapter determinerAdapter = new DeterminerAdapter(getActivity(), determinerArrayList);
        listView.setAdapter(determinerAdapter);


        // Setup onClickListener

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Determiner determiner= determinerArrayList.get(position);
                subjectThing.setDeterminer(determiner);
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
