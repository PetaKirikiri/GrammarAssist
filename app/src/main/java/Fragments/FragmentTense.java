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

import Adapters.TamAdapter;
import Interface.Communicator;
import Models.Tam;
import Models.TamAdapterElement;
import Repositories.TamRepo;
import Translator.ActiveVerbalSentence;

/**
 * Created by petakirikiri on 29/04/16.
 */
public class FragmentTense extends Fragment {
    Button btn_BackToMain;
    ListView listView;

    Communicator comm;

    ActiveVerbalSentence oldSentence, newSentence;

    Tam tense;

    ArrayList<Tam> tamArrayList;

    MainActivity mainActivity;

    TextView tv_tense;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tense, null, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv_tense = (TextView) view.findViewById(R.id.tv_tense);
        // Get oldSentence

        mainActivity = (MainActivity) getActivity();
        oldSentence = mainActivity.getActiveVerbalSentence();
        tense = oldSentence.getTense();


        // Update TextView

        tv_tense.setText(tense.getEng());

        newSentence = oldSentence;


        // Setup ListView

        listView = (ListView) getView().findViewById(R.id.TenseListView);

        // Setup ArrayList<TenseElement>


        TamRepo tamRepo = new TamRepo();
        tamArrayList = tamRepo.getTamArrayList();
        TamAdapter tamAdapter = new TamAdapter(getActivity(), tamArrayList, newSentence);
        listView.setAdapter(tamAdapter);

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
                tense = tamArrayList.get(position);
                comm.setTense(tense);
            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (Communicator) getActivity();
    }
}