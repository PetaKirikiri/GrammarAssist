package Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.petakirikiri.easymaorifragments.R;

import java.util.ArrayList;

import Adapters.NounSelectorAdapter;
import Interface.Communicator;

/**
 * Created by petakirikiri on 27/04/16.
 */
public class FragmentSubjectSelector extends Fragment {
    Button btn_BackToMain;
    ListView listView;

    Communicator comm;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subject_thing_selector, null, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // Setup ListView

        listView = (ListView) getView().findViewById(R.id.SubjectSelectionlistView);

        ArrayList<String> nouns = new ArrayList<String>();
        nouns.add(0, "Pronoun");
        nouns.add(1, "Object");
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
                if (selected == "Pronoun"){
                    comm.setFragmentSubjectPronoun();
                }
                else if (selected == "Object"){
                    comm.setFragmentSubjectThingSelector();
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
