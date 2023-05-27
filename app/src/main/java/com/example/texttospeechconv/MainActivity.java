package com.example.texttospeechconv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,TextToSpeech.OnInitListener {
    Button btnspeak;
    EditText textspeak;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnspeak=(Button) findViewById(R.id.btnspeak);
        btnspeak.setOnClickListener(this);
        textspeak=(EditText) findViewById(R.id.edt1);
        textToSpeech=new TextToSpeech(getBaseContext(),this);
        textToSpeech.setLanguage(Locale.ENGLISH);
    }

    @Override
    public void onClick(View v){
        String text=textspeak.getText().toString();
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    public void onInit(int status){
        if(status != TextToSpeech.ERROR){
            Toast.makeText(getBaseContext(),"success",Toast.LENGTH_LONG).show();
        }
    }
}