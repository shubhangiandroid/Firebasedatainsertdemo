package com.example.firebasedatainsertdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText edittextname,edittextaddress,edittextage,edittextphoneno;
    Button btnsave;
    DatabaseReference reff;

    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittextname=(EditText)findViewById(R.id.edittextname);
        edittextaddress=(EditText)findViewById(R.id.edittextaddress);
        edittextage=(EditText)findViewById(R.id.edittextage);
        edittextphoneno=(EditText)findViewById(R.id.edittextphoneno);
        btnsave=(Button)findViewById(R.id.btnsave);
        member=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int age= Integer.parseInt(edittextage.getText().toString().trim());
                Long ph=Long.parseLong(edittextphoneno.getText().toString().trim());

                member.setName(edittextname.getText().toString().trim());
                member.setAddress(edittextaddress.getText().toString().trim());
                member.setAge(age);
                member.setPh(ph);
                reff.child("member").setValue(member);
                Toast.makeText(MainActivity.this,"data inserted successfully",Toast.LENGTH_LONG).show();
            }
        });



    }
}
