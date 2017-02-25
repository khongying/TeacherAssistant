package team.bsru.lottae.teacherassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button LoginButton;
    private EditText UserEditText;
    private EditText PassEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButton = (Button) findViewById(R.id.login);
        UserEditText = (EditText) findViewById(R.id.editText);
        PassEditText = (EditText) findViewById(R.id.editText2);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User = UserEditText.getText().toString();
                String Pass = PassEditText.getText().toString();
                if(User.equals("") || Pass.equals("")){
                    Toast.makeText(MainActivity.this,"มีช่องว่างกรุณากรอกให้ครบ",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"เข้าสู้ระบบสำเร็จ",Toast.LENGTH_LONG).show();
                }


//                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
//                startActivity(intent);
            }
        });
    }
}
