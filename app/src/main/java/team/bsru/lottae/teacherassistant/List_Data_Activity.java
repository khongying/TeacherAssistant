package team.bsru.lottae.teacherassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class List_Data_Activity extends AppCompatActivity {

    private String sec;
    private String dateListJsonString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__data_);
        try {
            MyConstant myConstant = new MyConstant();
            JSONObject jsonObject = new JSONObject(getIntent().getStringExtra("data_TA"));
            sec = jsonObject.getString("ta_sec");
            Get_Data_Form get_data_form = new Get_Data_Form(List_Data_Activity.this);
            get_data_form.execute(myConstant.getServiceGetDateList()+"sec="+sec);
            try {
                dateListJsonString = get_data_form.get();
                Toast.makeText(List_Data_Activity.this,dateListJsonString,Toast.LENGTH_SHORT).show();
            } catch (Exception e) {

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
