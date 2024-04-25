package com.example.appdoan2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView txt_sl1,txt_sl2,txt_sl3,txt_ct1,txt_ct2,txt_ct3,txt_tt1,txt_tt2,txt_tt3;
    ImageView imageView2,imageView3,imageView4;
    DatabaseReference database=FirebaseDatabase.getInstance().getReferenceFromUrl("https://apphoanchinh-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_sl1=findViewById(R.id.txt_sl1);
        txt_sl2=findViewById(R.id.txt_sl2);
        txt_sl3=findViewById(R.id.txt_sl3);
        txt_ct1=findViewById(R.id.txt_ct1);
        txt_ct2=findViewById(R.id.txt_ct2);
        txt_ct3=findViewById(R.id.txt_ct3);
        txt_tt1=findViewById(R.id.txt_tt1);
        txt_tt2=findViewById(R.id.txt_tt2);
        txt_tt3=findViewById(R.id.txt_tt3);
        final DatabaseReference soluong1 =database.child("SOLUONG_1");
        final DatabaseReference chotrong1=database.child("CHOTRONG_1");
        final DatabaseReference tinhtrang1=database.child("TINHTRANG_1");
        final DatabaseReference soluong2 =database.child("SOLUONG_2");
        final DatabaseReference chotrong2=database.child("CHOTRONG_2");
        final DatabaseReference tinhtrang2=database.child("TINHTRANG_2");
        final DatabaseReference soluong3 =database.child("SOLUONG_3");
        final DatabaseReference chotrong3=database.child("CHOTRONG_3");
        final DatabaseReference tinhtrang3=database.child("TINHTRANG_3");
        soluong1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Lấy giá trị từ Firebase
                Float floatValue = snapshot.getValue(Float.class);

                if (floatValue != null) {
                    // Chuyển đổi giá trị float thành kiểu int
                    int intValue = floatValue.intValue();

                    // Hiển thị giá trị trong TextView
                    txt_sl1.setText(String.valueOf(intValue));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Xử lý khi có lỗi xảy ra
            }
        });
        chotrong1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Float floatValue = snapshot.getValue(Float.class);

                if (floatValue != null) {
                    // Chuyển đổi giá trị float thành kiểu int
                    int intValue = floatValue.intValue();

                    // Hiển thị giá trị trong TextView
                    txt_ct1.setText(String.valueOf(intValue));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        soluong2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Lấy giá trị từ Firebase
                Float floatValue = snapshot.getValue(Float.class);

                if (floatValue != null) {
                    // Chuyển đổi giá trị float thành kiểu int
                    int intValue = floatValue.intValue();

                    // Hiển thị giá trị trong TextView
                    txt_sl2.setText(String.valueOf(intValue));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Xử lý khi có lỗi xảy ra
            }
        });

        chotrong2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Lấy giá trị từ Firebase
                Float floatValue = snapshot.getValue(Float.class);

                if (floatValue != null) {
                    // Chuyển đổi giá trị float thành kiểu int
                    int intValue = floatValue.intValue();

                    // Hiển thị giá trị trong TextView
                    txt_ct2.setText(String.valueOf(intValue));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Xử lý khi có lỗi xảy ra
            }
        });


        soluong3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Lấy giá trị từ Firebase
                Float floatValue = snapshot.getValue(Float.class);

                if (floatValue != null) {
                    // Chuyển đổi giá trị float thành kiểu int
                    int intValue = floatValue.intValue();

                    // Hiển thị giá trị trong TextView
                    txt_sl3.setText(String.valueOf(intValue));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Xử lý khi có lỗi xảy ra
            }
        });

        chotrong3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Lấy giá trị từ Firebase
                Float floatValue = snapshot.getValue(Float.class);

                if (floatValue != null) {
                    // Chuyển đổi giá trị float thành kiểu int
                    int intValue = floatValue.intValue();

                    // Hiển thị giá trị trong TextView
                    txt_ct3.setText(String.valueOf(intValue));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Xử lý khi có lỗi xảy ra
            }
        });

        tinhtrang1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Long value = snapshot.getValue(Long.class);

                if (value != null) {
                    if (imageView2 != null && txt_tt1 != null) {
                        if (value == 1) {
                            imageView2.setImageResource(R.drawable.cam1);
                            txt_tt1.setText("DAY");
                        } else if (value == 0) {
                            imageView2.setImageResource(R.drawable.baixe);
                            txt_tt1.setText("TRONG");
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle errors if needed
            }
        });

        tinhtrang2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Long value = snapshot.getValue(Long.class);

                if (value != null) {
                    if (imageView3 != null && txt_tt2 != null) {
                        if (value == 1) {
                            imageView3.setImageResource(R.drawable.cam1);
                            txt_tt2.setText("DAY");
                        } else if (value == 0) {
                            imageView3.setImageResource(R.drawable.baixe);
                            txt_tt2.setText("TRONG");
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle errors if needed
            }
        });

        tinhtrang3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Long value = snapshot.getValue(Long.class);

                if (value != null) {
                    if (imageView2 != null && txt_tt3 != null) {
                        if (value == 1) {
                            imageView4.setImageResource(R.drawable.cam1);
                            txt_tt3.setText("DAY");
                        } else if (value == 0) {
                            imageView4.setImageResource(R.drawable.baixe);
                            txt_tt3.setText("TRONG");
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle errors if needed
            }
        });

    }
}