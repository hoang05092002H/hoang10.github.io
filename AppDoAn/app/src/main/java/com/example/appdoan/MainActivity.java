package com.example.appdoan;

import static java.lang.Math.round;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    TextView txt_sl1,txt_sl2,txt_sl3,txt_ct1,txt_ct2,txt_ct3,txt_tt1,txt_tt2,txt_tt3;
    ImageView imageView2,imageView3,imageView4;
    Integer giaTriTruocDo1 = 0;
    Integer giaTriTruocDo2 = 0;
    Integer giaTriTruocDo3 = 0;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
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
        final DatabaseReference soluong1 =database.getReference("SOLUONG_1");
        final DatabaseReference chotrong1=database.getReference("CHOTRONG_1");
        //final DatabaseReference tinhtrang1=database.getReference("TINHTRANG_1");
        final DatabaseReference soluong2 =database.getReference("SOLUONG_2");
        final DatabaseReference chotrong2=database.getReference("CHOTRONG_2");
        //final DatabaseReference tinhtrang2=database.getReference("TINHTRANG_2");
        final DatabaseReference soluong3 =database.getReference("SOLUONG_3");
        final DatabaseReference chotrong3=database.getReference("CHOTRONG_3");
        //final DatabaseReference tinhtrang3=database.getReference("TINHTRANG_3");

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
                    if (intValue > giaTriTruocDo1){
                        txt_tt1.setText(" VÀO");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                txt_tt1.setText("");
                            }
                        }, 2000); // 2000 milliseconds = 2 seconds
                    } else if (intValue< giaTriTruocDo1)
                    {
                        txt_tt1.setText("RA");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                txt_tt1.setText("");
                            }
                        }, 2000); // 2000 milliseconds = 2 seconds
                    }
                    else if (intValue == 10){

                        txt_tt1.setText("FULL");
                    }
                    giaTriTruocDo1 = intValue;
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
                    // Lấy giá trị từ Firebase
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
                    // Xử lý khi có lỗi xảy ra
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
                        if (intValue> giaTriTruocDo2){
                            txt_tt2.setText(" VÀO");
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    txt_tt2.setText("");
                                }
                            }, 2000); // 2000 milliseconds = 2 seconds
                        } else if (intValue<giaTriTruocDo2)
                        {
                            txt_tt2.setText("RA");
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    txt_tt2.setText("");
                                }
                            }, 2000); // 2000 milliseconds = 2 seconds
                        }
                        else if (intValue == 10){

                            txt_tt2.setText("FULL");
                        }
                        giaTriTruocDo2 = intValue;
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
                    if (intValue> giaTriTruocDo3){
                        txt_tt3.setText(" VÀO");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                txt_tt3.setText("");
                            }
                        }, 2000); // 2000 milliseconds = 2 seconds
                    } else if (intValue<giaTriTruocDo3)
                    {
                        txt_tt3.setText("RA");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                txt_tt3.setText("");
                            }
                        }, 2000); // 2000 milliseconds = 2 seconds
                    }
                    else if (intValue == 10){

                        txt_tt3.setText("FULL");
                    }
                    giaTriTruocDo3 = intValue;
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
    }
}