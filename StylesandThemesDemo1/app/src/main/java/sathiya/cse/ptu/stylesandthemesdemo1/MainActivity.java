package sathiya.cse.ptu.stylesandthemesdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);

     //  setContentView(R.layout.activity_button);
    TextView txvGradient = (TextView) findViewById(R.id.txvGradient);
      LinearGradient linearGradient = new LinearGradient(0, 0, txvGradient.getTextSize(), 0,Color.GREEN, Color.RED, Shader.TileMode.MIRROR);

    txvGradient.getPaint().setShader(linearGradient);
    }
}