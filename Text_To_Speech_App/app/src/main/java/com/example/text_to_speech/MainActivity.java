package com.example.text_to_speech;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {
    private TextToSpeech tts;
    private Button buttonSpeak;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts = new TextToSpeech(this, this);
        buttonSpeak = (Button) findViewById(R.id.button1);
        editText = (EditText) findViewById(R.id.editText1);

        buttonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                speakOut();
            }

        });
    }
    @Override
    public void onDestroy()
    {
// Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    private void speakOut() {
        String text = editText.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
    @Override
    public void onInit(int i) {

    }
}