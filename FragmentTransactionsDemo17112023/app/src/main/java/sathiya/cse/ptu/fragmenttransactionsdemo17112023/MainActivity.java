package sathiya.cse.ptu.fragmenttransactionsdemo17112023;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
    }

    public void addFragmentA(View view) {

        FragmentA fragmentA = new FragmentA();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentA, "fragA");
        transaction.commit();
    }

    public void removeFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragmentA != null) {
            transaction.remove(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void addFragmentB(View view) {

        FragmentB fragmentB = new FragmentB();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentB, "fragB");
        transaction.commit();
    }

    public void removeFragmentB(View view) {

        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragmentB != null) {
            transaction.remove(fragmentB);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment B not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void replaceByFragmentA(View view) {

        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentA, "fragA");
        transaction.commit();
    }

    public void replaceByFragmentB(View view) {

        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentB, "fragB");
        transaction.commit();
    }

    public void attachFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragmentA != null) {
            transaction.attach(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void detachFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragmentA != null) {
            transaction.detach(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void showFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragmentA != null) {
            transaction.show(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void hideFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragmentA != null) {
            transaction.hide(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }
}
