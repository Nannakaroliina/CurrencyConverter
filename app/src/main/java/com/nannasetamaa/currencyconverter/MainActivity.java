package com.nannasetamaa.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Conversion from Euro
    private static final double dollarUS_EU = 1.1123;
    private static final double yen_EU = 120.63;
    private static final double pound_EU = 0.8641;
    private static final double rouble_EU = 71.0887;
    private static final double yuanRenminbi_EU = 7.8684;
    private static final double wonSK_EU = 1303.45;

    // Conversion from Dollar
    private static final double euro_USD = 0.8981;
    private static final double yen_USD = 108.6197;
    private static final double pound_USD = 0.774128;
    private static final double rouble_USD = 63.9333;
    private static final double yuanRenminbi_USD = 7.0678;
    private static final double wonSK_USD = 1170.8048;

    // Conversion from Yen
    private static final double euro_JPY = 0.0083;
    private static final double dollar_JPY = 0.0092;
    private static final double pound_JPY = 0.0071;
    private static final double rouble_JPY = 0.5886;
    private static final double yuanRenminbi_JPY = 0.0651;
    private static final double wonSK_JPY = 10.7799;

    // Conversion from Pound
    private static final double euro_GBP = 1.1599;
    private static final double dollar_GBP = 1.2916;
    private static final double yen_GBP = 140.2845;
    private static final double rouble_GBP = 82.5666;
    private static final double yuanRenminbi_GPB = 9.1280;
    private static final double wonSK_GBP = 1512.9476;

    // Conversion from Rouble
    private static final double euro_RUB = 0.0140;
    private static final double dollar_RUB = 0.0156;
    private static final double yen_RUB = 1.6989;
    private static final double pound_RUB = 0.0121;
    private static final double yuanRenminbi_RUB = 0.1106;
    private static final double wonSK_RUB = 18.3291;

    // Conversion from Yuan Renminbi
    private static final double euro_CNY = 0.1270;
    private static final double dollar_CNY = 0.1415;
    private static final double yen_CNY = 15.3658;
    private static final double pound_CNY = 0.1095;
    private static final double rouble_CNY = 9.0441;
    private static final double wonSK_CNY = 165.7535;

    // Conversion from won
    private static final double euro_KRW = 0.000767;
    private static final double dollar_KRW = 0.000854;
    private static final double yen_KRW = 0.092701;
    private static final double pound_KRW = 0.000661;
    private static final double rouble_KRW = 0.054561;
    private static final double yuanRenminbi_KRW = 0.006032;

    private static final DecimalFormat df2 = new DecimalFormat("#.##");
    private String base_currency;
    private String target_currency;
    private double endpoint_currency;
    private double conversionResult;
    private Spinner convertFrom, convertTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsToSpinner();
        itemSelectedToSpinner();

    }

    private void addItemsToSpinner() {

        convertFrom = findViewById(R.id.spinner);
        convertTo = findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currencies, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        convertFrom.setAdapter(adapter);
        convertTo.setAdapter(adapter);

    }

    private void itemSelectedToSpinner() {

        convertFrom = findViewById(R.id.spinner);
        convertTo = findViewById(R.id.spinner2);

        convertFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                base_currency = convertFrom.getItemAtPosition(position).toString();
                Log.i("Base", base_currency);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        convertTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                target_currency = convertTo.getItemAtPosition(position).toString();
                Log.i("Target", target_currency);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    private double convertCurrency(double amount) {

        switch (base_currency) {
            case "EUR":
                switch (target_currency) {
                    case "USD":
                        endpoint_currency = amount * dollarUS_EU;
                        break;
                    case "JPY":
                        endpoint_currency = amount * yen_EU;
                        break;
                    case "GBP":
                        endpoint_currency = amount * pound_EU;
                        break;
                    case "CNY":
                        endpoint_currency = amount * yuanRenminbi_EU;
                        break;
                    case "RUB":
                        endpoint_currency = amount * rouble_EU;
                        break;
                    case "KRW":
                        endpoint_currency = amount * wonSK_EU;
                        break;
                    default:
                        endpoint_currency = amount;
                        break;
                }
                break;
            case "USD":
                switch (target_currency) {
                    case "EUR":
                        endpoint_currency = amount * euro_USD;
                        break;
                    case "JPY":
                        endpoint_currency = amount * yen_USD;
                        break;
                    case "GBP":
                        endpoint_currency = amount * pound_USD;
                        break;
                    case "CNY":
                        endpoint_currency = amount * yuanRenminbi_USD;
                        break;
                    case "RUB":
                        endpoint_currency = amount * rouble_USD;
                        break;
                    case "KRW":
                        endpoint_currency = amount * wonSK_USD;
                        break;
                    default:
                        endpoint_currency = amount;
                        break;
                }
                break;
            case "JPY":
                switch (target_currency) {
                    case "USD":
                        endpoint_currency = amount * dollar_JPY;
                        break;
                    case "EUR":
                        endpoint_currency = amount * euro_JPY;
                        break;
                    case "GBP":
                        endpoint_currency = amount * pound_JPY;
                        break;
                    case "CNY":
                        endpoint_currency = amount * yuanRenminbi_JPY;
                        break;
                    case "RUB":
                        endpoint_currency = amount * rouble_JPY;
                        break;
                    case "KRW":
                        endpoint_currency = amount * wonSK_JPY;
                        break;
                    default:
                        endpoint_currency = amount;
                        break;
                }
                break;
            case "GBP":
                switch (target_currency) {
                    case "USD":
                        endpoint_currency = amount * dollar_GBP;
                        break;
                    case "JPY":
                        endpoint_currency = amount * yen_GBP;
                        break;
                    case "EUR":
                        endpoint_currency = amount * euro_GBP;
                        break;
                    case "CNY":
                        endpoint_currency = amount * yuanRenminbi_GPB;
                        break;
                    case "RUB":
                        endpoint_currency = amount * rouble_GBP;
                        break;
                    case "KRW":
                        endpoint_currency = amount * wonSK_GBP;
                        break;
                    default:
                        endpoint_currency = amount;
                        break;
                }
                break;
            case "CNY":
                switch (target_currency) {
                    case "USD":
                        endpoint_currency = amount * dollar_CNY;
                        break;
                    case "JPY":
                        endpoint_currency = amount * yen_CNY;
                        break;
                    case "GBP":
                        endpoint_currency = amount * pound_CNY;
                        break;
                    case "EUR":
                        endpoint_currency = amount * euro_CNY;
                        break;
                    case "RUB":
                        endpoint_currency = amount * rouble_CNY;
                        break;
                    case "KRW":
                        endpoint_currency = amount * wonSK_CNY;
                        break;
                    default:
                        endpoint_currency = amount;
                        break;
                }
                break;
            case "RUB":
                switch (target_currency) {
                    case "USD":
                        endpoint_currency = amount * dollar_RUB;
                        break;
                    case "JPY":
                        endpoint_currency = amount * yen_RUB;
                        break;
                    case "GBP":
                        endpoint_currency = amount * pound_RUB;
                        break;
                    case "CNY":
                        endpoint_currency = amount * yuanRenminbi_RUB;
                        break;
                    case "EUR":
                        endpoint_currency = amount * euro_RUB;
                        break;
                    case "KRW":
                        endpoint_currency = amount * wonSK_RUB;
                        break;
                    default:
                        endpoint_currency = amount;
                        break;
                }
                break;
            case "KRW":
                switch (target_currency) {
                    case "USD":
                        endpoint_currency = amount * dollar_KRW;
                        break;
                    case "JPY":
                        endpoint_currency = amount * yen_KRW;
                        break;
                    case "GBP":
                        endpoint_currency = amount * pound_KRW;
                        break;
                    case "CNY":
                        endpoint_currency = amount * yuanRenminbi_KRW;
                        break;
                    case "RUB":
                        endpoint_currency = amount * rouble_KRW;
                        break;
                    case "EUR":
                        endpoint_currency = amount * euro_KRW;
                        break;
                    default:
                        endpoint_currency = amount;
                        break;
                }
                break;
        }

        return endpoint_currency;
    }

    public void convertOnClick(View view) {

        EditText amountView = findViewById(R.id.amountField);
        TextView conversion = findViewById(R.id.conversionText);

        double amount = Double.parseDouble(amountView.getText().toString());
        String output = df2.format(convertCurrency(amount));
        Log.i("Result", String.valueOf(conversionResult));

        Toast.makeText(this, "Converted successfully!", Toast.LENGTH_LONG).show();

        conversion.setVisibility(View.VISIBLE);

        conversion.setText(getResources().getString(R.string.converted, output));
    }
}
