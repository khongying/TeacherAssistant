package team.bsru.lottae.teacherassistant;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class Scan_QR extends AppCompatActivity {
    private Toolbar BackToolbar;
    private static final String STRING = "com.google.zxing.client.android.SCAN";
    private String[] modeStrings = new String[]{"QR_CODE_MODE", "BAR_CODE_MODE"};
    private int[] modeInts = new int[]{0,1};
    private ImageButton barImageButton;
    private String result;
    private String returnServer;
    private String json_data_ta;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan__qr);
        json_data_ta = getIntent().getStringExtra("data_TA").toString();

        BackToolbar = (Toolbar) findViewById(R.id.toolbar2);
        barImageButton = (ImageButton) findViewById(R.id.imageButton7);

        BackToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Scan_QR.this,"Back",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        barImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myScan(modeStrings[1], modeInts[1]);
            }
        }); // scan barcode


    } //main method

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            String[] strings = new String[]{"QR code = ", "BAR code = "};
            result = data.getStringExtra("SCAN_RESULT");

            try {
                MyConstant myConstant = new MyConstant();
                JSONObject jsonObject = new JSONObject(json_data_ta);
                String sec = jsonObject.getString("ta_sec");
                Get_Data_Form get_data_form = new Get_Data_Form(Scan_QR.this);
                get_data_form.execute(myConstant.getServiceCheckQRandBar() +
                        "code=" + result+"&"+
                        "sec="+sec
                );
                returnServer = get_data_form.get().toString();
                JSONObject jsonObject1 = new JSONObject(returnServer);
                String msg = jsonObject1.getString("message");

                Toast.makeText(Scan_QR.this, msg,Toast.LENGTH_SHORT).show();
            } catch (Exception e) {

            }




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

}// class
