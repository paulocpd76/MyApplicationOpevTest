package com.example.pperez003.myapplicationopevtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.util.Log;
import org.opencv.android.OpenCVLoader;
public class MainActivity extends AppCompatActivity {
    private  static final String TAG ="mytag";
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    static {
       if (!OpenCVLoader.initDebug()){Log.d(TAG,"open cv not loaded");}
       else {Log.d(TAG,"open loaded succesfully");}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
