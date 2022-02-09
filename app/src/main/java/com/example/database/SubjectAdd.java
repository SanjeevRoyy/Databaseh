package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.database.modelclass.ModelSubject;
import com.example.database.utilities.DBHandler;

import java.sql.SQLOutput;

public class SubjectAdd extends AppCompatActivity {
    private TextView tvsubjectname,tvpassmarks,tvfullmarks;
    private String name,passmarks,fullmarks;
    private Button btnsave,btncancel;
    private DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_add);

        tvsubjectname = findViewById(R.id.subid);
        tvpassmarks = findViewById(R.id.passmarksid);
        tvfullmarks = findViewById(R.id.fullmarksid);
        btnsave = findViewById(R.id.buttonsave);
        btncancel = findViewById(R.id.buttoncancel);
        dbHandler = new DBHandler(getApplicationContext());


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateinputs();
                Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();
            }
        });




    }

    private void validateinputs() {
        System.out.println("validatin input");
        name = tvsubjectname.getText().toString().toLowerCase().trim();
        passmarks = tvpassmarks.getText().toString();
        fullmarks = tvfullmarks.getText().toString();


       if(name.equals("")){
            tvsubjectname.setError("Name Conflict");
        }
        else{

            return;
        }
    }
    private void saveindatabase(String name, String passmarks, String fullmarks){

        System.out.println("creating model");

        ModelSubject modelsubject = new ModelSubject(-1,name,passmarks,fullmarks);
        dbHandler.addsubject(modelsubject);

    }

}