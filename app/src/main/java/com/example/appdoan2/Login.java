package com.example.appdoan2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.appdoan2.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    TextView textView6, textView2, textView3, textView4, textView, textView5;
    EditText email, password;
    Button btnlogin, btnregister;
    ImageView imageView1;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://apphoanchinh-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textView6 = findViewById(R.id.textView6);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView = findViewById(R.id.textView);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnlogin = findViewById(R.id.login);
        imageView1 = findViewById(R.id.imageView);
        btnregister = findViewById(R.id.register);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String emailtxt = email.getText().toString();
                final String passwordtxt = password.getText().toString();
                if (emailtxt.isEmpty() || passwordtxt.isEmpty()) {
                    Toast.makeText(Login.this, "Vui long Nhap Tai Khoan va Mat Khau", Toast.LENGTH_LONG).show();
                }
                else {
                    databaseReference.child("user").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (passwordtxt != null) {
                                if (snapshot.hasChild(emailtxt)) {
                                    final String getPassword = snapshot.child(emailtxt).child("password").getValue(String.class);
                                    if (getPassword != null && getPassword.equals(passwordtxt)) {
                                    Toast.makeText(Login.this, "Dang nhap thanh cong  ", Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(Login.this, MainActivity.class));
                                    } else {
                                        Toast.makeText(Login.this, "Mat Khau Sai", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Toast.makeText(Login.this, "Sai Tai Khoan", Toast.LENGTH_LONG).show();
                                }

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Register.class));


            }
        });
    }
}


