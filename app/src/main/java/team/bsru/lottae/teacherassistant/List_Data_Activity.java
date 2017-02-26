package team.bsru.lottae.teacherassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class List_Data_Activity extends AppCompatActivity {

    private String sec;
    private String dateListJsonString;
    private Boolean status;
    private String array_data,message;
    private String array_dataString;
    private ListView listView;
    private Toolbar backToolbar;
    private ListView showListView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__data_);
        listView = (ListView) findViewById(R.id.list_date);
        backToolbar = (Toolbar) findViewById(R.id.toolbar3);
        showListView = (ListView) findViewById(R.id.list_date);

        backToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        try {
            MyConstant myConstant = new MyConstant();
            JSONObject jsonObject = new JSONObject(getIntent().getStringExtra("data_TA"));
            sec = jsonObject.getString("ta_sec");
            Get_Data_Form get_data_form = new Get_Data_Form(List_Data_Activity.this);
            get_data_form.execute(myConstant.getServiceGetDateList()+"sec="+sec);
            try {
                dateListJsonString = get_data_form.get();
                JSONObject jsonObject1 = new JSONObject(dateListJsonString);
                status = jsonObject1.getBoolean("status");
                message = jsonObject1.getString("message");
                array_dataString = jsonObject1.getString("data");
                if (status==true){

                    JSONArray jsonArray = new JSONArray(array_dataString);
                    final String[] date_list = new String[jsonArray.length()];
                    final String[] date_list_id = new String[jsonArray.length()];
                    for (int i =0;i<jsonArray.length();i++){
                        JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                        date_list[i] = jsonObject2.getString("date");
                        date_list_id[i] =jsonObject2.getString("id");
                        //Toast.makeText(List_Data_Activity.this,date_list[i],Toast.LENGTH_SHORT).show();
                    }
                    List_Time_Adapter list_time_adapter = new List_Time_Adapter(List_Data_Activity.this, date_list,date_list_id);
                    listView.setAdapter(list_time_adapter);
                    showListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(List_Data_Activity.this, List_Student.class);
                            intent.putExtra("id_date",date_list_id[position]);
                            intent.putExtra("sec_student", sec);
                            startActivity(intent);
                        }
                    });

                    //Toast.makeText(List_Data_Activity.this,status.toString(),Toast.LENGTH_SHORT).show();


                }else {

                    //Toast.makeText(List_Data_Activity.this,message.toString(),Toast.LENGTH_SHORT).show();

                }

            } catch (Exception e) {

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
