package com.capriquota.entech.limit;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.capriquota.entech.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LimitActivity extends AppCompatActivity {
    EditText start_date, end_date; int a;
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limit);

        start_date = findViewById(R.id.start_date);
        end_date = findViewById(R.id.end_date);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        start_date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                a = 1;
                new DatePickerDialog(LimitActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        end_date.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               a = 0;
               new DatePickerDialog(LimitActivity.this, date, myCalendar
                       .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                       myCalendar.get(Calendar.DAY_OF_MONTH)).show();
           }
        });
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        if(a == 1) {
            start_date.setText(sdf.format(myCalendar.getTime()));
        }else if ( a == 0){
            end_date.setText(sdf.format(myCalendar.getTime()));
        }

    }
}
