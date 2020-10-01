package com.example.hw01;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText enterBillValue;
    TextView tipValue, totalValue;
    RadioGroup tipPercentage;
    SeekBar seekbar;
    TextView cusTipPercentage;
    Button exit;
    protected Double TipCalculator(Double TotalValue, Double Tip){
        return TotalValue*Tip/100;
    }

    protected double TotalCalculator(Double BillValue, Double TipValue){
        return BillValue + TipValue;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterBillValue = findViewById(R.id.edittext1);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        tipValue = findViewById(R.id.edittext2);
        totalValue = findViewById(R.id.edittext3);
        tipPercentage = (RadioGroup) findViewById(R.id.radioGroup);
        cusTipPercentage = (TextView) findViewById(R.id.textView6);
        exit = (Button)findViewById(R.id.button);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cusTipPercentage.setText(String.valueOf(progress));
                try{
                    Double customtip  = Double.valueOf(seekbar.getProgress());
                    Log.d("CustomTip", customtip+"");
                    Double bill_Value = Double.parseDouble(enterBillValue.getText().toString());
                    Double tip_Value = TipCalculator(bill_Value,customtip);
                    Double total_Value = TotalCalculator(bill_Value,tip_Value);
                    tipValue.setText(tip_Value+"");
                    totalValue.setText(total_Value+"");
                }catch(Exception e){
                    tipValue.setText("");
                    totalValue.setText("");
                    Toast.makeText(getApplicationContext(),"Enter Input",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        enterBillValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    Double bill_value = Double.parseDouble(enterBillValue.getText().toString());
                    if(tipPercentage.getCheckedRadioButtonId() == R.id.radioButton){
                        Double TipValue = TipCalculator(bill_value,10.0);
                        Double TotalValue = TotalCalculator(TipValue,bill_value);
                        tipValue.setText(TipValue+"");
                        totalValue.setText(TotalValue+"");
                    }else if(tipPercentage.getCheckedRadioButtonId() == R.id.radioButton2){
                        Double TipValue = TipCalculator(bill_value,15.0);
                        Double TotalValue = TotalCalculator(TipValue,bill_value);
                        tipValue.setText(TipValue+"");
                        totalValue.setText(TotalValue+"");
                    }else if(tipPercentage.getCheckedRadioButtonId() == R.id.radioButton3){
                        Double TipValue = TipCalculator(bill_value,18.0);
                        Double TotalValue = TotalCalculator(TipValue,bill_value);
                        tipValue.setText(TipValue+"");
                        totalValue.setText(TotalValue+"");
                    }else{
                        Double TipValue = TipCalculator(bill_value,(Double.valueOf(seekbar.getProgress())));
                        Double TotalValue = TotalCalculator(TipValue,bill_value);
                        tipValue.setText(TipValue+"");
                        totalValue.setText(TotalValue+"");
                    }
                }catch(Exception e){
                    tipValue.setText("");
                    totalValue.setText("");
                    Toast.makeText(getApplicationContext(),"Please Enter Input",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        tipPercentage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                try{
                    switch (checkedId){
                        case R.id.radioButton:{
                            double bill_value = Double.parseDouble(enterBillValue.getText().toString());
                            Double TipValue = TipCalculator(bill_value,10.0);
                            Double TotalValue = TotalCalculator(TipValue,bill_value);
                            tipValue.setText(TipValue+"");
                            totalValue.setText(TotalValue+"");
                            break;
                        }
                        case R.id.radioButton2:{
                            double bill_value = Double.parseDouble(enterBillValue.getText().toString());
                            Double TipValue = TipCalculator(bill_value,15.0);
                            Double TotalValue = TotalCalculator(TipValue,bill_value);
                            tipValue.setText(TipValue+"");
                            totalValue.setText(TotalValue+"");
                            break;
                        }

                        case R.id.radioButton3:{
                            double bill_value = Double.parseDouble(enterBillValue.getText().toString());
                            Double TipValue = TipCalculator(bill_value,18.0);
                            Double TotalValue = TotalCalculator(TipValue,bill_value);
                            tipValue.setText(TipValue+"");
                            totalValue.setText(TotalValue+"");
                            break;
                        }
                        case R.id.radioButton4:{
                            double bill_amount = Double.parseDouble(enterBillValue.getText().toString());
                            double tip = bill_amount*(Double.valueOf(seekbar.getProgress()));
                            double total = tip+bill_amount;
                            tipValue.setText(tip + "");
                            totalValue.setText(total +"");
                            break;
                        }
                    }
                }catch(Exception e){
                    tipValue.setText("");
                    totalValue.setText("");
                    Toast.makeText(getApplicationContext(),"Check Input",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}