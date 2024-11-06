package com.example.buttonclickapp;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private TextView textView;
    private static final String TAG = "MainActivity";
    private static final String TEXT_CONTENTS = "TextContents";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "OnCreate: in");

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userInput = (EditText) findViewById(R.id.editTextText);
        userInput.setText("");
        Button button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("");
        textView.setMovementMethod(new ScrollingMovementMethod());
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = userInput.getText().toString();
                result = result + "\n";
                textView.append(result);
                userInput.setText("");
            }
        };
        if(button != null) {
            button.setOnClickListener(ourOnClickListener);
        }
        Log.d(TAG, "OnCreate: in");

    }

    @Override
    protected void onStart() {
        Log.d(TAG, "OnStart: in");
        super.onStart();
        Log.d(TAG, "OnStart: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "OnResume: in");
        super.onResume();
        Log.d(TAG, "OnResume: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "OnPause: in");
        super.onPause();
        Log.d(TAG, "OnPause: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "OnStop: in");
        super.onStop();
        Log.d(TAG, "OnStop: out");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "OnDestroy: in");
        super.onDestroy();
        Log.d(TAG, "OnDestroy: out");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");
        outState.putString(TEXT_CONTENTS, textView.getText().toString());
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS));
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: out");
    }
}