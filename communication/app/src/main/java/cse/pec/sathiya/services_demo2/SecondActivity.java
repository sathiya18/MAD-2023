package cse.pec.sathiya.services_demo2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    boolean isBound = false;
    private MyBoundService myBoundService;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {

            MyBoundService.MyLocalBinder myLocalBinder = (MyBoundService.MyLocalBinder) iBinder;
            myBoundService = myLocalBinder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = new Intent(this, MyBoundService.class);
        bindService(intent, mConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (isBound) {
            unbindService(mConnection);
            isBound = false;
        }
    }

    public void onClickEvent(View view) {

        EditText etNumOne = (EditText) findViewById(R.id.etNumOne);
        EditText etNumTwo = (EditText) findViewById(R.id.etNumTwo);
        TextView txvResult = (TextView) findViewById(R.id.txvResult);

        int numOne = Integer.valueOf(etNumOne.getText().toString());
        int numTwo = Integer.valueOf(etNumTwo.getText().toString());

        String resultStr = "";

        if (isBound) {

            switch (view.getId()) {

                case R.id.btnAdd:
                    resultStr = String.valueOf(myBoundService.add(numOne, numTwo));
                    break;

                case R.id.btnSub:
                    resultStr = String.valueOf(myBoundService.subtract(numOne, numTwo));
                    break;

                case R.id.btnMul:
                    resultStr = String.valueOf(myBoundService.multiply(numOne, numTwo));
                    break;

                case R.id.btnDiv:
                    resultStr = String.valueOf(myBoundService.divide(numOne, numTwo));
                    break;
            }

            txvResult.setText(resultStr);
        }
    }
}

