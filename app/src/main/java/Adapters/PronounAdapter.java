package Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.petakirikiri.easymaorifragments.R;

import java.util.ArrayList;

import Models.Pronoun;

/**
 * Created by petakirikiri on 28/04/16.
 */
public class PronounAdapter extends BaseAdapter {
    ArrayList<Pronoun> pronouns;
    Context context;
    LayoutInflater mInflater;

    public PronounAdapter(Context c, ArrayList<Pronoun> pronouns) {
        context = c;
        this.pronouns = pronouns;
        mInflater = LayoutInflater.from(this.context);

    }

    @Override
    public int getCount() {
        return pronouns.size();
    }

    @Override
    public Object getItem(int position) {
        return pronouns.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.row_layout_pronoun, null);
        }


        TextView tv_Maori = (TextView) convertView.findViewById(R.id.tv_Maori);
        TextView tv_English = (TextView) convertView.findViewById(R.id.tv_English);


        tv_Maori.setText(pronouns.get(position).getMao());

        tv_English.setText(pronouns.get(position).getEng());

        return convertView;
    }
}
