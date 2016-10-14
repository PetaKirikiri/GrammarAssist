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
import Interface.Communicator;
import Models.Adjective;
import Models.Thing;
import Repositories.AdjectiveRepo;
import Translator.ActiveVerbalSentence;

/**
 * Created by petakirikiri on 11/05/16.
 */
public class FragmentObjectThingAdjective extends Fragment {
    Button btn_BackToMain;
    Communicator comm;

    ListView listView;

    ActiveVerbalSentence currentSentence;

    MainActivity mainActivity;

    Thing objectThing;
    AdjectiveRepo adjectiveRepo;
    ArrayList<Adjective> adjectiveArrayList;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_object_thing_adjective, null, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();
        currentSentence = mainActivity.getActiveVerbalSentence();

        objectThing = (Thing) currentSentence.getObject();


        // Setup TextView

        TextView tv_objectThing = (TextView) view.findViewById(R.id.tv_objectThing);

        tv_objectThing.setText(objectThing.getMao());

        // Setup ListView
        listView = (ListView) getView().findViewById(R.id.ObjectThingAdjectiveListView);

        adjectiveRepo= new AdjectiveRepo();
        adjectiveArrayList = adjectiveRepo.getAdjectiveArrayList();
        AdjectiveAdapter adjectiveAdapter = new AdjectiveAdapter(getActivity(), adjectiveArrayList);
        listView.setAdapter(adjectiveAdapter);


        // Setup onClickListener

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Adjective adjective = adjectiveArrayList.get(position);
                objectThing.setAdjective(adjective);
                comm.setObjectThing(objectThing);
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
