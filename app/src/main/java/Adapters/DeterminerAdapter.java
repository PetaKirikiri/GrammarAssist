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

import Models.Determiner;
import Models.Pronoun;

/**
 * Created by petakirikiri on 28/04/16.
 */
public class DeterminerAdapter extends BaseAdapter {
    ArrayList<Determiner> determinerArrayList;
    Context context;
    LayoutInflater mInflater;

    public DeterminerAdapter(Context c, ArrayList<Determiner> determiners) {
        context = c;
        this.determinerArrayList = determiners;
        mInflater = LayoutInflater.from(this.context);

    }

    @Override
    public int getCount() {
        return determinerArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return determinerArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.row_layout_thing_determiner, null);
        }


        TextView tv_Maori = (TextView) convertView.findViewById(R.id.tv_Maori);
        TextView tv_English = (TextView) convertView.findViewById(R.id.tv_English);


        tv_Maori.setText(determinerArrayList.get(position).getMao());

        tv_English.setText(determinerArrayList.get(position).getEng());

        return convertView;
    }
}
