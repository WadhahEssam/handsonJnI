package com.example.handsonjni;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.handsonjni.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityMainBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(NativeCode.stringFromJNI());


        System.out.println(NativeCode.add(2.0, 3.0));
    }
}

class NativeCode {
    static {
        System.loadLibrary("handsonjni");
    }

    public static native String stringFromJNI();
    public static native double add(double a, double b);

    public static void printSomething(String something) {
        System.out.println(something);
    }
}

