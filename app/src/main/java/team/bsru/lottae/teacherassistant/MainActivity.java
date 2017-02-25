package team.bsru.lottae.teacherassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private Button LoginButton;
    private EditText UserEditText;
    private EditText PassEditText;
    private String JsonString;
    private Boolean status;
    private String message;


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
                    Toast.makeText(MainActivity.this,"กรุณากรองให้ครบ",Toast.LENGTH_SHORT).show();

                }else {
                    try {
                        Get_Data_Form get_data_form = new Get_Data_Form(MainActivity.this);
                        MyConstant myConstant = new MyConstant();
                        get_data_form.execute(myConstant.getServiceLoginTA()+
                                "username="  +User+ "&"+
                                "passwd=" + Pass
                        );
                        JsonString = get_data_form.get().toString();

                        JSONObject jsonObject = new JSONObject(JsonString);
                        String dataTA = jsonObject.getString("data");
                        status = jsonObject.getBoolean("status");
                        message = jsonObject.getString("massage");

                        if (status == true){
                            Toast.makeText(MainActivity.this,message.toString(),Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                            intent.putExtra("TaData",dataTA);
                            startActivity(intent);

                        }else {
                            Toast.makeText(MainActivity.this,message.toString(),Toast.LENGTH_SHORT).show();
                        }


                    }catch (Exception e){

                    }
                }


            }
        });
    }
}
