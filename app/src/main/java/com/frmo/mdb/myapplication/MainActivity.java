package com.frmo.mdb.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    HashMap<String, Pair<Double, Double>> mph = new HashMap<String, Pair<Double, Double>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mph.put("Walking", new Pair(3.1, 30.0));
        mph.put("Boosted Mini S Board", new Pair(18.0, 7.0));
        mph.put("Evolve Skateboard", new Pair(26.0, 31.0));
        mph.put("OneWheel", new Pair(19.0, 7.0));
        mph.put("MotoTec SkateBoard", new Pair(22.0, 10.0));
        mph.put("Segway Ninebot One S1", new Pair(12.5, 15.0));
        mph.put("Segway i2 SE", new Pair(12.5, 24.0));
        mph.put("Razor Scooter", new Pair(10.0, 7.0));
        mph.put("GeoBlade 500", new Pair(15.0, 8.0));
        mph.put("Hovertrax Hoverboard", new Pair(8.0, 8.0));



    }
    public void convertItems(View view) {

        EditText editText = (EditText)findViewById(R.id.editText7);
        String number = editText.getText().toString();
        if(number.matches("")) {
            TextView notify = (TextView)findViewById(R.id.textView3);
            notify.setText("Please enter a number!");
        } else {
            Double n = Double.parseDouble(number);
            TextView notify = (TextView)findViewById(R.id.textView3);
            notify.setText("");
            Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
            String selected1 = spinner3.getSelectedItem().toString();
            Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
            String selected2 = spinner4.getSelectedItem().toString();
            convertedTime((TextView)findViewById(R.id.textView5), selected1, n);
            convertedTime((TextView)findViewById(R.id.textView7), selected2, n);

        }


    }
    public void convertedTime(TextView t, String vehicle, double distance) {
        double range = mph.get(vehicle).second.doubleValue();
        double speed = mph.get(vehicle).first.doubleValue();

        if(range < distance) {
            t.setText("The max range of " + vehicle + " is only " + Double.toString(range) + " miles");
        } else {
            double time = distance / speed;
            int minutes = (int)(time * 60.0);
            t.setText("This distance will take about " + Integer.toString(minutes) + " minutes by " + vehicle);
        }
    }
}
