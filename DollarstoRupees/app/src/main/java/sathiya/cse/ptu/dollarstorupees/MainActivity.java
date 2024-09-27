package sathiya.cse.ptu.dollarstorupees;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Conversion rate (You can update it dynamically if needed)
    private static final double CONVERSION_RATE = 83.0; // Example rate: 1 USD = 83 INR

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI elements
        EditText dollarInput = findViewById(R.id.dollarInput);
        Button convertButton = findViewById(R.id.convertButton);
        TextView resultTextView = findViewById(R.id.resultTextView);

        // Set up click listener for the conversion button
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the value entered by the user
                String dollarAmount = dollarInput.getText().toString();

                // Convert to INR if the input is not empty
                if (!TextUtils.isEmpty(dollarAmount)) {
                    double dollarValue = Double.parseDouble(dollarAmount);
                    double rupeeValue = dollarValue * CONVERSION_RATE;

                    // Display the result
                    resultTextView.setText(String.format("₹%.2f", rupeeValue));
                } else {
                    // Handle empty input case
                    resultTextView.setText("Please enter a valid amount");
                }
            }
        });
    }
}
