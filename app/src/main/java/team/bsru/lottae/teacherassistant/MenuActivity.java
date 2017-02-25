package team.bsru.lottae.teacherassistant;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MenuActivity extends AppCompatActivity {
    private Toolbar nameToolbar;
    private String jsonString;
    private ImageButton ScanButton;
    private ImageButton ListImageButton;
    private Button outButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ScanButton = (ImageButton) findViewById(R.id.imageButton);
        ListImageButton = (ImageButton) findViewById(R.id.imageButton2);
        outButton = (Button) findViewById(R.id.button3);

        nameToolbar = (Toolbar) findViewById(R.id.toolbar);

//        testTextView = (TextView) findViewById(R.id.test);
        jsonString = getIntent().getStringExtra("TaData");
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            nameToolbar.setTitle("TA "+jsonObject.getString("F_name")+ " "+
                    jsonObject.getString("L_name")+ " "+
                    jsonObject.getString("ta_sec")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ScanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,Scan_QR.class);
                intent.putExtra("data_TA", jsonString);
                startActivity(intent);


            }
        });
        outButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ListImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,List_Data_Activity.class);
                intent.putExtra("data_TA",jsonString);
                startActivity(intent);
            }
        });

//        testTextView.setText(jsonString);




    }// main method




}
