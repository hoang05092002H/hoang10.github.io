package com.example.appdoan2;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://apphoanchinh-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText fullname=findViewById(R.id.hovaten);
        final EditText email=findViewById(R.id.taikhoan);
        final EditText password=findViewById(R.id.Matkhau);
        final EditText conPass=findViewById(R.id.Matkhaucon);
        final Button btnRegister=findViewById(R.id.button);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String fullnametxt = fullname.getText().toString();
                final String emailTxt = email.getText().toString();
                final String passwordTxt = password.getText().toString();
                final String conPasstxt = conPass.getText().toString();
                if (fullnametxt.isEmpty() || emailTxt.isEmpty() || passwordTxt.isEmpty() || conPasstxt.isEmpty()) {
                    Toast.makeText(Register.this, "Vui long Dien Du Thong Tin", Toast.LENGTH_LONG).show();
                }
                else if (!passwordTxt.equals(conPasstxt)){
                    Toast.makeText(Register.this,"Khong trung khop",Toast.LENGTH_LONG).show();
                }
                else
                {
                    databaseReference.child("user").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(emailTxt)){
                                Toast.makeText(Register.this,"San sang dang ki",Toast.LENGTH_LONG).show();

                            }
                            else
                            {
                                databaseReference.child("user").child(emailTxt).child("fullnametxt").setValue(fullnametxt);
                                databaseReference.child("user").child(emailTxt).child("Password").setValue(passwordTxt);
                                Toast.makeText(Register.this, "Dang ki thanh cong ",Toast.LENGTH_LONG).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

            }
}