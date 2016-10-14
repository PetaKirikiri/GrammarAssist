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
import android.widget.Toast;

import com.example.petakirikiri.easymaorifragments.MainActivity;
import com.example.petakirikiri.easymaorifragments.R;

import java.util.ArrayList;

import Adapters.NounSelectorAdapter;
import Interface.Communicator;
import Models.INoun;
import Translator.ActiveVerbalSentence;

/**
 * Created by petakirikiri on 1/05/16.
 */
public class FragmentObjectSelector extends Fragment {
    Button btn_BackToMain;
    ListView listView;

    Communicator comm;

    MainActivity mainActivity;
    ActiveVerbalSentence currentSentence;

    TextView tv_objectLabel;

    INoun currentObject;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_object_selector, null, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setup TextView

        mainActivity = (MainActivity) getActivity();
        currentSentence = mainActivity.getActiveVerbalSentence();

        tv_objectLabel = (TextView) view.findViewById(R.id.tv_object);

        currentObject = currentSentence.getObject();

        tv_objectLabel.setText(currentObject.getMao());


        // Setup ListView

        listView = (ListView) getView().findViewById(R.id.ObjectSelectionlistView);

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
                    comm.setFragmentObjectPronoun();
                }
                else if (selected == "Object"){
                   comm.setFragmentObjectThingSelector();
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
