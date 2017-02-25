package team.bsru.lottae.teacherassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Scan_QR extends AppCompatActivity {
    private Toolbar BackToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan__qr);

        BackToolbar = (Toolbar) findViewById(R.id.toolbar2);

        BackToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Scan_QR.this,"Back",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
