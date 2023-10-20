package com.example.test;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextText;
    private TextView textView,textView2,textView3,textView4,textView5;
    private RadioButton radioButton,radioButton2,radioButton3;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextText = findViewById(R.id.editTextText);
        textView = findViewById(R.id.textView);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        button = findViewById(R.id.button);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);

        button.setOnClickListener(view -> {

            if (editTextText.length() < 1 ){
                textView.setText("請輸入玩家姓名");
            }else{
                textView2.setText(String.format("名字\n%S",editTextText.getText().toString()));

                if(radioButton.isChecked()){
                    textView4.setText("我方出拳  \n剪刀");
                } else if (radioButton2.isChecked()) {
                    textView4.setText("我方出拳  \n石頭");
                } else if (radioButton3.isChecked()) {
                    textView4.setText("我方出拳  \n布");
                }


                int computer_random = (int) (Math.random() * 3);


                if (computer_random == 0) {
                    textView5.setText("電腦出拳\n剪刀");
                } else if (computer_random == 1) {
                    textView5.setText("電腦出拳\n石頭");
                }else if (computer_random == 2) {
                    textView5.setText("電腦出拳\n布");
                }


                if ((radioButton.isChecked() && computer_random == 2) ||
                        (radioButton2.isChecked() && computer_random == 0) ||
                        (radioButton3.isChecked() && computer_random == 1)){
                    textView3.setText("勝利者  \n" + editTextText.getText().toString());
                    textView.setText("恭喜您獲勝了");
                } else if ((radioButton.isChecked() && computer_random == 1) ||
                        (radioButton2.isChecked() && computer_random == 2) ||
                        (radioButton3.isChecked() && computer_random == 0)) {
                    textView3.setText("勝利者  \n電腦" );
                    textView.setText("可惜輸了");
                }else{
                    textView3.setText("勝利者  \n沒有" );
                    textView.setText("平手");
                }

            }
        });




    }
}