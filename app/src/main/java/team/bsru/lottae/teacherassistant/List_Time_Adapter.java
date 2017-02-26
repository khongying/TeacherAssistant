package team.bsru.lottae.teacherassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Lottae on 26/2/2560.
 */

public class List_Time_Adapter extends BaseAdapter{

    private Context context;
    private String[] time,id;
    private TextView countTextView,dateTextView;

    public List_Time_Adapter(Context context, String[] time, String[] id) {
        this.context = context;
        this.time = time;
        this.id = id;
    }

    @Override
    public int getCount() {
        return time.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_item_list,parent,false);
        dateTextView = (TextView) view.findViewById(R.id.date);
        countTextView = (TextView) view.findViewById(R.id.count);
        dateTextView.setText(time[position]);
        countTextView.setText("ครั้งที่ "+(position+1));


        return view;
    }
}
