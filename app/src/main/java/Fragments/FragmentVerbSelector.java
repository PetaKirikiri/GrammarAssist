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

import Adapters.VerbSelectorAdapter;
import Interface.Communicator;
import Models.IVerb;
import Translator.ActiveVerbalSentence;

/**
 * Created by petakirikiri on 29/04/16.
 */
public class FragmentVerbSelector extends Fragment {

    Button btn_BackToMain;
    ListView listView;

    Communicator comm;

    ActiveVerbalSentence oldSentence, newSentence;

    IVerb verb;

    MainActivity mainActivity;

    TextView tv_verb;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_verb_selector, null, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // Get oldSentence

        mainActivity = (MainActivity) getActivity();
        oldSentence = mainActivity.getActiveVerbalSentence();
        verb = oldSentence.getVerb();


        // Update TextView

        tv_verb = (TextView) view.findViewById(R.id.tv_verb);
        tv_verb.setText(verb.getMao());

        newSentence = oldSentence;



        // Setup ListView

        listView = (ListView) getView().findViewById(R.id.VerbSelectionlistView);

        ArrayList<String> verbs = new ArrayList<String>();
        verbs.add(0, "Transitive Verb");
        verbs.add(1, "Intransitive Verb");
        VerbSelectorAdapter myAdapter = new VerbSelectorAdapter(getActivity(), verbs);
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
                if (selected == "Transitive Verb"){
                    comm.setFragmentTransitiveVerb();
                }
                else if (selected == "Intransitive Verb"){
                    comm.setFragmentIntransitiveVerb();
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
