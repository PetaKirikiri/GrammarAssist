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

/**
 * Created by petakirikiri on 29/04/16.
 */
public class VerbSelectorAdapter extends BaseAdapter {

    ArrayList<String> verbs;
    Context context;
    LayoutInflater mInflater;

    public VerbSelectorAdapter(Context c, ArrayList<String> verbs) {
        context = c;
        this.verbs = verbs;
        mInflater = LayoutInflater.from(this.context);

    }

    @Override
    public int getCount() {
        return verbs.size();
    }

    @Override
    public Object getItem(int position) {
        return verbs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.row_layout_verb_selector, null);
        }


        TextView tv_Maori = (TextView) convertView.findViewById(R.id.tv_Maori);
        TextView tv_English = (TextView) convertView.findViewById(R.id.tv_English);


        tv_Maori.setText(verbs.get(position).toString());

        tv_English.setText(verbs.get(position).toString());

        return convertView;
    }
}
