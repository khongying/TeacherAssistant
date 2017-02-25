package team.bsru.lottae.teacherassistant;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by Lottae on 25/2/2560.
 */

public class Get_Data_Form extends AsyncTask<String, Void, String>{

    private Context context;

    public Get_Data_Form(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        try{
            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[0]).build();
            Response response = okHttpClient.newCall(request).execute();
            String resJson = response.body().string();
            Log.d("Okhttp", "res try ==>" + resJson);
            return resJson;

        }catch (Exception e){
            Log.d("Okhttp", "res try ==>" + e.toString());
            return null;
        }



    }
}
