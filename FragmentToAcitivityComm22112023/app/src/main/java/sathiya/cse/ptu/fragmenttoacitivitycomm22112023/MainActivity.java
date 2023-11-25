package sathiya.cse.ptu.fragmenttoacitivitycomm22112023;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private FragmentManager manager;
    private TextView txvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvResult = (TextView) findViewById(R.id.txvResult);

        manager = getFragmentManager();
        addFragmentA();
    }

    public void addFragmentA() {

        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentA, fragmentA, "fragA");
        transaction.commit();
    }

    @Override // Called from FragmentA
    public void addTwoNumbers(int num1, int num2) {

        int result = num1 + num2;
        txvResult.setText("Result : " + result);
    }
}

