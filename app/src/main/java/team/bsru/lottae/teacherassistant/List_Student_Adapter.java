package team.bsru.lottae.teacherassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Lottae on 26/2/2560.
 */

public class List_Student_Adapter extends BaseAdapter {
    private String[] num_student,code_student,name_student;
    private Context context;
    private TextView conuntTextView,num_studentTextView,code_studentTextView,name_studentTextView;

    public List_Student_Adapter(Context context, String[] num_student, String[] code_student, String[] name_student) {
        this.context = context;
        this.num_student = num_student;
        this.code_student = code_student;
        this.name_student = name_student;
    }

    @Override
    public int getCount() {
        return name_student.length;
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
        View view = layoutInflater.inflate(R.layout.activity_list__data__student, parent, false);
        num_studentTextView = (TextView) view.findViewById(R.id.num);
        code_studentTextView = (TextView) view.findViewById(R.id.code);
        name_studentTextView = (TextView) view.findViewById(R.id.name);

        num_studentTextView.setText(num_student[position]);
        code_studentTextView.setText(code_student[position]);
        name_studentTextView.setText(name_student[position]);

        return view;
    }
}
