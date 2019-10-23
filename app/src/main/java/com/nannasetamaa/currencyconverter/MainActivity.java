package com.nannasetamaa.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final double dollar = 1.11225;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public void convertOnClick(View view) {

        EditText amountView = findViewById(R.id.amountField);
        TextView conversion = findViewById(R.id.conversionText);

        double euro = Double.parseDouble(amountView.getText().toString());
        double conversionAmout = euro * dollar;
        String output = String.valueOf(conversionAmout);

        Toast.makeText(this, "Conversion done!", Toast.LENGTH_LONG).show();

        conversion.setVisibility(View.VISIBLE);

        conversion.setText(getResources().getString(R.string.converted,  output));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
