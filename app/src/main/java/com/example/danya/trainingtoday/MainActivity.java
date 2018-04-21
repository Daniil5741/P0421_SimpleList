package com.example.danya.trainingtoday;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String[] name = {"Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь"};
    String[] position = {"Программер", "Бухгалтер", "Программер",
            "Программер", "Бухгалтер", "Директор", "Программер", "Охранник"};
    int salary[] = {13000, 10000, 13000, 13000, 10000, 15000, 13000, 8000};
    Intent intent;
    int[] colors = new int[2];
    Button btn_Save, btn_Clear;
    String exercise = "0";
    String approaches = null;
    LayoutInflater ltInflater;
   static LinearLayout linLayout;
    int version = 999;
    ListView lvMain;
    int a;
  static   ArrayList<String> arr;
    final String LOG_TAG = "myLogs";
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colors[0] = Color.parseColor("#559966CC");
        colors[1] = Color.parseColor("#55336699");
        arr=new ArrayList<>();

        linLayout = (LinearLayout) findViewById(R.id.linLayout);


        Button btn1 = new Button(this);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        btn1.setText("Add");
        btn1.setLayoutParams(layoutParams);
        //  btn1.setGravity(Gravity.RIGHT);
        linLayout.addView(btn1);
        btn1.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_Clear = (Button) findViewById(R.id.btnClear);
        intent = getIntent();
        exercise = intent.getStringExtra("exercise");
        approaches = intent.getStringExtra("approaches");
        Log.d(LOG_TAG, "exercise= " + exercise + " approaches= " + approaches);

        if (exercise != null && approaches != null) {
           AddListView();
            exercise = "0";
            approaches = null;
        } else {

        }


    }

    @Override
    protected void onStop() {
        super.onStop();

//        version=Integer.parseInt(intent.getStringExtra("version"));

    }

    public void AddListView() {


        ListView listView =new ListView(this);
        //  linLayout.addView(listView);
        int approach = Integer.parseInt(approaches);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        for (i = 0; i < approach; i++) {
            arr.add(Integer.toString(i)) ;
        }
        Log.d(LOG_TAG,"Размер массива  "+arr.size());




        // Создаем адаптер,используя массив из файла ресурсов
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, arr);
        //  ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, arr.length, android.R.layout.simple_list_item_multiple_choice);
        listView.setAdapter(adapter);
        linLayout.addView(listView);




   /*//     ltInflater = getLayoutInflater();
        int approach = Integer.parseInt(approaches);
    *//*    for (int i = 0; i < approach; i++) {
            Log.d("myLogs", "i = " + i);
            View item = ltInflater.inflate(R.layout.item, linLayout, false);
            TextView tvName = (TextView) item.findViewById(R.id.tvName);
            tvName.setText(exercise);
            //   TextView tvPosition = (TextView) item.findViewById(R.id.tvPosition);
            //     tvPosition.setText("Должность: " + position[i]);
            //   TextView tvSalary = (TextView) item.findViewById(R.id.tvSalary);
            // tvSalary.setText("Оклад: " + String.valueOf(salary[i]));
            item.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
            item.setBackgroundColor(colors[i % 2]);
            linLayout.addView(item);
        }*//*
        // Устанавливаем режим выбора пунктов списка
        lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
       if(arr.size()==0){
           for (i = 0; i < approach; i++) {
               arr.add(Integer.toString(i)) ;
           }
           Log.d(LOG_TAG,"Размер массива первый раз "+arr.size());
       }else{
           for (i = arr.size()-1; i < (arr.size()+approach); i++) {
               arr.add(Integer.toString(i)) ;
           }
           Log.d(LOG_TAG,"Размер массива последующие разы "+arr.size());
       }


        // Создаем адаптер,используя массив из файла ресурсов
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, arr);
        //  ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, arr.length, android.R.layout.simple_list_item_multiple_choice);
        lvMain.setAdapter(adapter);*/
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Main_Add.class);
        startActivity(intent);


    }
}
