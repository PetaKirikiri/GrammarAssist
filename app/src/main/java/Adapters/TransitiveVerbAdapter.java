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

import Models.IVerb;
import Models.Tam;
import Models.TransitiveVerb;

/**
 * Created by petakirikiri on 29/04/16.
 */
public class TransitiveVerbAdapter extends BaseAdapter{
    ArrayList<TransitiveVerb> transitiveVerbArrayList;
    Context context;
    LayoutInflater mInflater;

    public TransitiveVerbAdapter(Context c, ArrayList<TransitiveVerb> transitiveVerbArrayList) {
        context = c;
        this.transitiveVerbArrayList = transitiveVerbArrayList;
        mInflater = LayoutInflater.from(this.context);

    }

    @Override
    public int getCount() {
        return transitiveVerbArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return transitiveVerbArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.row_layout_transitive_verb, null);
        }


        TextView tv_Maori = (TextView) convertView.findViewById(R.id.tv_Maori);
        TextView tv_English = (TextView) convertView.findViewById(R.id.tv_English);


        tv_Maori.setText(transitiveVerbArrayList.get(position).getMao());

        tv_English.setText(transitiveVerbArrayList.get(position).getEngKeite());

        return convertView;
    }
}
