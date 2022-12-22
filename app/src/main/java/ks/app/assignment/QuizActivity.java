package ks.app.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class QuizActivity extends AppCompatActivity {

    int currentQue = 1;
    int currentAns = 2;
    RadioButton rB1, rB2, rB3, rB4;
    ImageView imageView;
    TextView question;
    ProgressBar pb1, pb2, pb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        rB1 = findViewById(R.id.rB_1);
        rB2 = findViewById(R.id.rB_2);
        rB3 = findViewById(R.id.rB_3);
        rB4 = findViewById(R.id.rB_4);
        imageView = findViewById(R.id.iV_image);
        question = findViewById(R.id.tV_question);
        pb1 = findViewById(R.id.pB);
        pb2 = findViewById(R.id.pB2);
        pb3 = findViewById(R.id.pB3);
        findViewById(R.id.btn_next).setOnClickListener(v->{

           if(currentQue == 1) {
               if(rB2.isChecked()) {
                   Toast.makeText(this, "Correct Answer ! :)", Toast.LENGTH_SHORT).show();

               } else {
                   Toast.makeText(this, "Oops! Incorrect Answer", Toast.LENGTH_SHORT).show();
                   pb1.setProgressTintList(ColorStateList.valueOf(Color.RED));
               }
               pb1.setProgress(1);
               setQueOpt(2, "Question: Who was able to pick up Thor’s hammer in Endgame?","Captain America" ,"Thor" ,"Wanda", "Iron Man", 1);
           } else if(currentQue == 2) {
               if(rB1.isChecked()) {
                   Toast.makeText(this, "Correct Answer ! :)", Toast.LENGTH_SHORT).show();
               } else {
                   Toast.makeText(this, "Oops! Incorrect Answer", Toast.LENGTH_SHORT).show();
                   pb2.setProgressTintList(ColorStateList.valueOf(Color.RED));
               }
               pb2.setProgress(1);
               setQueOpt(3, "Question: Black Panther is set in which fictional country?","India" ,"USA" ,"Wakanda", "China", 3);
           } else if(currentQue == 3) {
               if(rB3.isChecked()) {
                   Toast.makeText(this, "Correct Answer ! :)", Toast.LENGTH_SHORT).show();
               } else {
                   Toast.makeText(this, "Oops! Incorrect Answer", Toast.LENGTH_SHORT).show();
                   pb3.setProgressTintList(ColorStateList.valueOf(Color.RED));
               }
               pb3.setProgress(1);
               new AlertDialog.Builder(QuizActivity.this)
                       .setTitle("Quiz is over")
                       .setMessage("Do you want to restart or exit ?")

                       // Specifying a listener allows you to take an action before dismissing the dialog.
                       // The dialog is automatically dismissed when a dialog button is clicked.
                       .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int which) {
                               finish();
                               System.exit(0);
                           }
                       })
                       .setCancelable(false)
                       // A null listener allows the button to dismiss the dialog and take no further action.
                       .setNegativeButton("Restart", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               startActivity(new Intent(QuizActivity.this, MainActivity.class));
                               finish();
                           }
                       })
                       .setIcon(android.R.drawable.ic_dialog_alert)
                       .show();
           } else {

           }

            rB4.setChecked(false);
            rB3.setChecked(false);
            rB2.setChecked(false);
            rB1.setChecked(false);
        });

    }

    private void setQueOpt(int qNo, String ques, String o1, String o2, String o3, String o4,  int ansNo) {
        question.setText(ques);
        rB1.setText(o1);
        rB2.setText(o2);
        rB3.setText(o3);
        rB4.setText(o4);
        currentQue = qNo;
        currentAns = ansNo;
        if(qNo == 2) {
            imageView.setImageResource(R.drawable.thorhammer);
        } else if(qNo == 3){
            imageView.setImageResource(R.drawable.wakanda);
        } else {

        }
    }
}