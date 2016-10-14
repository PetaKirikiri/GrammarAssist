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

import Adapters.TransitiveVerbAdapter;
import Interface.Communicator;
import Models.IVerb;
import Models.TransitiveVerb;
import Repositories.TransitiveVerbRepo;
import Translator.ActiveVerbalSentence;

/**
 * Created by petakirikiri on 29/04/16.
 */
public class FragmentTransitiveVerb extends Fragment{
    Button btn_BackToMain;
    Communicator comm;

    ListView listView;

    ActiveVerbalSentence currentSentence;

    MainActivity mainActivity;

    IVerb verb;
    TransitiveVerbRepo transitiveVerbRepo;
    ArrayList<TransitiveVerb> transitiveVerbArrayList;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transitive_verb, null, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();
        currentSentence = mainActivity.getActiveVerbalSentence();

        verb = currentSentence.getVerb();


        // Setup TextView

        TextView tv_transitiveVerb = (TextView) view.findViewById(R.id.tv_transitiveVerb);

        tv_transitiveVerb.setText(verb.getMao());

        // Setup ListView
        listView = (ListView) getView().findViewById(R.id.TransitiveVerbListView);

        transitiveVerbRepo = new TransitiveVerbRepo();
        transitiveVerbArrayList = transitiveVerbRepo.getTransitiveVerbArrayList();
        TransitiveVerbAdapter myAdapter= new TransitiveVerbAdapter(getActivity(), transitiveVerbArrayList);
        listView.setAdapter(myAdapter);


        // Setup onClickListener

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                verb = transitiveVerbArrayList.get(position);
                comm.setVerb(verb);
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
