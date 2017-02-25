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
    private ImageButton QRButton;
    private static final String STRING = "com.google.zxing.client.android.SCAN";
    private String[] modeStrings = new String[]{"QR_CODE_MODE", "BAR_CODE_MODE"};
    private int[] modeInts = new int[]{0,1};
    private String result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        QRButton = (ImageButton) findViewById(R.id.imageButton);

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

        QRButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               myScan(modeStrings[0],modeInts[0]);

            }
        });

//        testTextView.setText(jsonString);




    }// main method

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            String[] strings = new String[]{"QR code = ", "BAR code = "};
            result = data.getStringExtra("SCAN_RESULT");
           Toast.makeText(MenuActivity.this,result,Toast.LENGTH_SHORT).show();

        }   // if


    }

    private void myScan(String modeString, int modeInt) {

        try {

            Intent intent = new Intent(STRING);
            intent.putExtra("SCAN_MODE", modeString);
            startActivityForResult(intent, modeInt);


        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Please Install Barcode Scanner",
                    Toast.LENGTH_SHORT).show();
        }

    }   // myScan
}
