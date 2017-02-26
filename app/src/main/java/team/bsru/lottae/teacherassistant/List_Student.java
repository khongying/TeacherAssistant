package team.bsru.lottae.teacherassistant;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class List_Student extends AppCompatActivity {
    private String id_date;
    private String secString;
    private String jsonreturnSever;
    private Boolean status;
    private String jsonArrayString, jsonArray;
    private ListView studentListView;
    private Toolbar backToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__student);
        backToolbar = (Toolbar) findViewById(R.id.toolbar4);

        backToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        id_date = getIntent().getStringExtra("id_date");
        secString = getIntent().getStringExtra("sec_student");
        MyConstant myConstant = new MyConstant();
        Get_Data_Form get_data_form = new Get_Data_Form(List_Student.this);
        try {
            get_data_form.execute(myConstant.getServiceGetStuByDate() +
                    "id_date=" + id_date + "&" +
                    "sec=" + secString);
            jsonreturnSever = get_data_form.get().toString();

            JSONObject jsonObject = new JSONObject(jsonreturnSever);
            status = jsonObject.getBoolean("status");
            jsonArrayString = jsonObject.getString("data");
            if (status == true) {
                studentListView = (ListView) findViewById(R.id.list_stu);
                JSONArray jsonArray = new JSONArray(jsonArrayString);
                final String[] num_student = new String[jsonArray.length()];
                final String[] code_student = new String[jsonArray.length()];
                final String[] name_student = new String[jsonArray.length()];
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                    num_student[i] = jsonObject2.getString("number_student");
                    code_student[i] = jsonObject2.getString("student_code");
                    name_student[i] = jsonObject2.getString("student_name");
                    //Toast.makeText(List_Data_Activity.this,date_list[i],Toast.LENGTH_SHORT).show();
                }
                List_Student_Adapter list_student_adapter = new List_Student_Adapter(List_Student.this, num_student
                        , code_student, name_student);
                studentListView.setAdapter(list_student_adapter);



                //Toast.makeText(List_Student.this,status.toString(),Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(List_Student.this, status.toString(), Toast.LENGTH_SHORT).show();
            }
//

        } catch (Exception e) {

        }
        Toast.makeText(List_Student.this, id_date + " <===> " + secString, Toast.LENGTH_SHORT).show();
    }
}
