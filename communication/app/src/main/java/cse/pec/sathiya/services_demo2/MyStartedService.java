package cse.pec.sathiya.services_demo2;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
//import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MyStartedService extends Service {

    private static final String TAG = MyStartedService.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate, Thread name " + Thread.currentThread().getName());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


     /*//demo1
        Log.i(TAG, "onStartCommand, Thread name " + Thread.currentThread().getName());
        return super.onStartCommand(intent,flags,startId); //demo1*/

        // Perform Tasks [ Short Duration Task: Don't block the UI ]
       /* //demo 2
        int sleepTime = intent.getIntExtra("sleepTime", 1);
        try {
            Thread.sleep(sleepTime * 10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return START_STICKY; //demo2*/


        //demo 3
        int sleepTime = intent.getIntExtra("sleepTime", 1);

        new MyAsyncTask().execute(sleepTime);

        return START_STICKY; //demo 3


    }


    // @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.i(TAG, "onBind, Thread name " + Thread.currentThread().getName());
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy, Thread name " + Thread.currentThread().getName());
    }

    class MyAsyncTask extends AsyncTask<Integer, String, String> {

        private final String TAG = MyAsyncTask.class.getSimpleName();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.i(TAG, "onPreExecute, Thread name " + Thread.currentThread().getName());
        }

        @Override // Perform our Long Running Task
        protected String doInBackground(Integer... params) {
            Log.i(TAG, "doInBackground, Thread name " + Thread.currentThread().getName());

            int sleepTime = params[0];

            int ctr = 1;

            // Dummy Long Operation
            while(ctr <= sleepTime) {
                publishProgress("Counter is now " + ctr);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ctr++;
            }

            return "Counter Stopped at " + ctr + " seconds";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            Toast.makeText(MyStartedService.this, values[0], Toast.LENGTH_SHORT).show();
            Log.i(TAG, "Counter Value " + values[0]+ " onProgressUpdate, Thread name " + Thread.currentThread().getName());
        }

        @Override
        protected void onPostExecute(String str) {
            super.onPostExecute(str);

            stopSelf(); // Destroy the Service from within the Service class itself
            Log.i(TAG, "onPostExecute, Thread name " + Thread.currentThread().getName());

            Intent intent = new Intent("action.service.to.activity");
            intent.putExtra("startServiceResult", str);
            sendBroadcast(intent);
        }
    }
}

