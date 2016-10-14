package Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.petakirikiri.easymaorifragments.MainActivity;
import com.example.petakirikiri.easymaorifragments.R;

import java.util.ArrayList;

import Models.Adjective;
import Models.Tam;
import Models.Thing;
import Translator.ActiveSentenceTranslator;
import Translator.ActiveVerbalSentence;

/**
 * Created by petakirikiri on 29/04/16.
 */
public class TamAdapter extends BaseAdapter {
    ArrayList<Tam> tamArrayList;
    Context context;
    LayoutInflater mInflater;

    ActiveVerbalSentence currentSentence;
    ActiveSentenceTranslator translator;

    public TamAdapter(Context c, ArrayList<Tam> tamArrayList, ActiveVerbalSentence currentSentence) {
        context = c;
        this.tamArrayList= tamArrayList;
        mInflater = LayoutInflater.from(this.context);
        this.currentSentence = currentSentence;
        translator = new ActiveSentenceTranslator(this.currentSentence);

    }

    @Override
    public int getCount() {
        return tamArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return tamArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.row_layout_tam, null);
        }




        TextView tv_Maori = (TextView) convertView.findViewById(R.id.tv_Maori);
        TextView tv_English = (TextView) convertView.findViewById(R.id.tv_English);
        TextView tv_translation = (TextView) convertView.findViewById(R.id.tv_translation);


        tv_Maori.setText(tamArrayList.get(position).getMao());
        tv_English.setText(tamArrayList.get(position).getEng());
        tv_translation.setText(translator.getEngSubject() + " " + translator.getEnglishVerb());


        return convertView;
    }
}
