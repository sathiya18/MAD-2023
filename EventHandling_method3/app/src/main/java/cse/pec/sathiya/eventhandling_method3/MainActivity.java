package cse.pec.sathiya.eventhandling_method3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
/**
 * Method 3 : Using onClick Attribute from XML layout to Trigger an Event.
 * */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
    }

    // Called when Button 1 is Clicked
    public void changeToGreen(View view) {
        relativeLayout.setBackgroundColor(Color.GREEN);
    }

    // Called when Button 2 is Clicked
    public void changeToBlue(View view) {
        relativeLayout.setBackgroundColor(Color.BLUE);
    }
}
