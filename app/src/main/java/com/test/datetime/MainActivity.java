package com.test.datetime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView dateDefault = (TextView)findViewById(R.id.dateDefault);
        TextView timeDefault = (TextView)findViewById(R.id.timeDefault);

        DatePicker dp = (DatePicker)this.findViewById(R.id.datePicker);
        // Месяц начиная с нуля. Для отображения добавляем 1.
        dateDefault.setText("Дата по умолчанию " + dp.getDayOfMonth() + "/" +
                (dp.getMonth() + 1) + "/" + dp.getYear());

        dp.init(2020, 02, 01, null);
        TimePicker tp = (TimePicker)this.findViewById(R.id.timePicker);
        java.util.Formatter timeF = new java.util.Formatter();
        timeF.format("Время по умолчанию %d:%02d", tp.getCurrentHour(),
                tp.getCurrentMinute());
        timeDefault.setText(timeF.toString());
        tp.setIs24HourView(true);
        tp.setCurrentHour(new Integer(10));
        tp.setCurrentMinute(new Integer(10));
    }
}
/*
Используя метод dp.init(2020, 02, 01, null);
устанавливаем дату по умолчанию - 1 марта, так как отсчет месяцев идет с нуля. А перед отображением времени, прибегаем к форматированию.
* */