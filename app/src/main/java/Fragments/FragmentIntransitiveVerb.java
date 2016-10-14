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

import Adapters.IntransitiveVerbAdapter;
import Interface.Communicator;
import Models.IVerb;
import Models.IntransitiveVerb;
import Repositories.IntransitiveVerbRepo;
import Translator.ActiveVerbalSentence;

/**
 * Created by petakirikiri on 29/04/16.
 */
public class FragmentIntransitiveVerb extends Fragment{
    Button btn_BackToMain;
    Communicator comm;

    ListView listView;

    ActiveVerbalSentence currentSentence;

    MainActivity mainActivity;

    IVerb verb;
    IntransitiveVerbRepo intransitiveVerbRepo;
    ArrayList<IntransitiveVerb> intransitiveVerbArrayList;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intransitive_verb, null, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();
        currentSentence = mainActivity.getActiveVerbalSentence();

        verb = currentSentence.getVerb();


        // Setup TextView

        TextView tv_intransitiveVerb = (TextView) view.findViewById(R.id.tv_intransitiveVerb);

        tv_intransitiveVerb.setText(verb.getMao());

        // Setup ListView
        listView = (ListView) getView().findViewById(R.id.IntransitiveVerbListView);

        intransitiveVerbRepo = new IntransitiveVerbRepo();
        intransitiveVerbArrayList = intransitiveVerbRepo.getIntransitiveVerbArrayList();
        IntransitiveVerbAdapter myAdapter= new IntransitiveVerbAdapter(getActivity(), intransitiveVerbArrayList);
        listView.setAdapter(myAdapter);


        // Setup onClickListener

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                verb = intransitiveVerbArrayList.get(position);
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
