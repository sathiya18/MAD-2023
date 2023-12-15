package cse.pec.sathiya.services_demo2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView txvIntentServiceResult, txvStartedServiceResult;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvIntentServiceResult = (TextView) findViewById(R.id.txvIntentServiceResult);
        txvStartedServiceResult = (TextView) findViewById(R.id.txvStartedServiceResult);
    }
    public void moveToSecondActivity(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void startStartedService(View view) {

        Intent intent = new Intent(MainActivity.this, MyStartedService.class);
        intent.putExtra("sleepTime", 10);
        startService(intent);
    }

    public void stopStartedService(View view) {

        Intent intent = new Intent(MainActivity.this, MyStartedService.class);
        stopService(intent);
    }

    public void startIntentService(View view) {
        ResultReceiver myResultReceiver = new MyResultReceiver(null);
        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra("sleepTime", 10);
        intent.putExtra("receiver", myResultReceiver);
        startService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.service.to.activity");
        registerReceiver(myStartedServiceReceiver, intentFilter);
    }

    // To receive the data back from MyStartedService.java using BroadcastReceiver
    private BroadcastReceiver myStartedServiceReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String result = intent.getStringExtra("startServiceResult");
            txvStartedServiceResult.setText(result);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(myStartedServiceReceiver);
    }
    // To receive the data back from MyIntentService.java using ResultReceiver
    private class MyResultReceiver extends ResultReceiver {

        public MyResultReceiver(Handler handler) {
            super(handler);
        }
        @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        super.onReceiveResult(resultCode, resultData);
            Log.i("MyResultreceiver", Thread.currentThread().getName());

            if (resultCode == 18 && resultData != null) {

                final String result = resultData.getString("resultIntentService");

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("MyHandler", Thread.currentThread().getName());
                        txvIntentServiceResult.setText(result);
                    }
                });
            }
        }

    }
}
