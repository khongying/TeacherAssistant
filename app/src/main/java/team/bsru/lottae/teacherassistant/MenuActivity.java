package team.bsru.lottae.teacherassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    private TextView testTextView;
    private String jsonString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        testTextView = (TextView) findViewById(R.id.test);
        jsonString = getIntent().getStringExtra("TaData");
        testTextView.setText(jsonString);




    }
}
