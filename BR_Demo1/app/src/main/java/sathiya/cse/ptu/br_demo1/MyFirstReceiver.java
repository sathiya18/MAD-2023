package sathiya.cse.ptu.br_demo1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyFirstReceiver extends BroadcastReceiver {

    private static final String TAG = MyFirstReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {

      //  String name = intent.getStringExtra("name");
     //   int age = intent.getIntExtra("age", 0);
      //  Log.i(TAG, name + ", " + age);

        Log.i(TAG, "Hello from 1st Receiver\n Thread name : " + Thread.currentThread().getName());
        Toast.makeText(context, "Hello from 1st Receiver", Toast.LENGTH_LONG).show();
    }
}

