package sathiya.cse.ptu.br_demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendBroadcastMessage(View view) {

	Intent intent = new Intent(this, MyFirstReceiver.class);
        //Intent intent = new Intent("my.custom.action.name");

       // intent.putExtra("name", "B.Tech cse");
      //  intent.putExtra("age", 25);

        sendBroadcast(intent);

        Log.i(TAG, "Hello after broadcasting...\n Thread name : " + Thread.currentThread().getName());


    }

}