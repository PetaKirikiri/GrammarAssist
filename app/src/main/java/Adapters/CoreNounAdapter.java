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

import Models.CoreNoun;
import Models.Determiner;

/**
 * Created by petakirikiri on 29/04/16.
 */
public class CoreNounAdapter extends BaseAdapter{
    ArrayList<CoreNoun> coreNounArrayList;
    Context context;
    LayoutInflater mInflater;

    public CoreNounAdapter(Context c, ArrayList<CoreNoun> coreNounArrayList) {
        context = c;
        this.coreNounArrayList = coreNounArrayList;
        mInflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return coreNounArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return coreNounArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.row_layout_thing_corenoun, null);
        }
        TextView tv_Maori = (TextView) convertView.findViewById(R.id.tv_Maori);
        TextView tv_English = (TextView) convertView.findViewById(R.id.tv_English);

        tv_Maori.setText(coreNounArrayList.get(position).getMao());

        tv_English.setText(coreNounArrayList.get(position).getEng());

        return convertView;
    }
}
