package Adapters;

/**
 * Created by petakirikiri on 25/04/16.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.petakirikiri.easymaorifragments.R;

import java.util.ArrayList;


/**
 * Created by petakirikiri on 13/04/16.
 */
public class NounSelectorAdapter extends BaseAdapter {

    ArrayList<String> nouns;
    Context context;
    LayoutInflater mInflater;

    public NounSelectorAdapter(Context c, ArrayList<String> nouns) {
        context = c;
        this.nouns = nouns;
        mInflater = LayoutInflater.from(this.context);

    }

    @Override
    public int getCount() {
        return nouns.size();
    }

    @Override
    public Object getItem(int position) {
        return nouns.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.row_layout_noun_selector, null);
        }


        TextView tv_Maori = (TextView) convertView.findViewById(R.id.tv_Maori);
        TextView tv_English = (TextView) convertView.findViewById(R.id.tv_English);


        tv_Maori.setText(nouns.get(position).toString());

        tv_English.setText(nouns.get(position).toString());

        return convertView;
    }
}