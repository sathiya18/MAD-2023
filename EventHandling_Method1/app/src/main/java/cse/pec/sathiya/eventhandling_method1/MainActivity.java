package cse.pec.sathiya.eventhandling_method1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
/**
        * Method 1 : Event Handling in Activity. - implement onClickListener interface in Activity
        * */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//onClickListener is the listener interface implemented by mainActivity.java (contains onClick method)
    private static final String TAG = MainActivity.class.getSimpleName();
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        assert button1 != null;
        assert button2 != null;

        //Register (object) button to onClickListener
       button1.setOnClickListener(MainActivity.this);
       button2.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button1:
                Log.i(TAG, "Color changed to GREEN");
                relativeLayout.setBackgroundColor(Color.GREEN);
                break;

            case R.id.button2:
                Log.i(TAG, "Color changed to BLUE");
                relativeLayout.setBackgroundColor(Color.BLUE);
                break;
        }
    }
}