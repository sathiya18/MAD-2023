package sathiya.cse.ptu.csebdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    TextView textview4;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText)findViewById(R.id.editText1);
        button = (Button)findViewById(R.id.button);
        textview4=(TextView) findViewById(R.id.textView4);
    }

    public void convertToDollars(View view) {
        String str = editText1.getText().toString();
       // String str = "123";
        Double n= Double.parseDouble(str);
        double ans= n / 83.25;
        textview4.setText(Double.toString(ans));
    }
}