package xyz.selfenrichment.robertotomas.texttospeechdemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextToSpeech mTTSobject;
    private int mSetLocaleResult;
    private Button bSpeak, bStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTTSobject =  new TextToSpeech( this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status){
                if ( status == TextToSpeech.SUCCESS ) {
                    // set language, such as:
                    mSetLocaleResult = mTTSobject.setLanguage(Locale.UK); // in scope of the view visible in the next step
                } else {
                    // handle error, notifying th user of a problem. Such as:
                    Toast.makeText(getApplicationContext(),
                            "TTS Feature not Supported in Your Device",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });

        bSpeak = (Button) findViewById(R.id.button_speak);
        bStop = (Button) findViewById(R.id.button_stop);

        bSpeak.setOnClickListener(this);
        bStop.setOnClickListener(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        mTTSobject.stop();
        mTTSobject.shutdown();
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.button_speak) {
            if (mSetLocaleResult == TextToSpeech.LANG_NOT_SUPPORTED
                    || mSetLocaleResult == TextToSpeech.LANG_MISSING_DATA){

                Toast.makeText(getApplicationContext(),
                        "TTS Feature not Supported in Your Device for the Locale: " + Locale.US.toString(),
                        Toast.LENGTH_SHORT).show();
            } else {
                TextView editText = (TextView) findViewById(R.id.editText);
                String text = editText.getText().toString();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ttsGreater21(text);
                } else {
                    ttsUnder20(text);
                }
            }
        } else if (v.getId() == R.id.button_stop) {
            mTTSobject.stop();
        }
    }

    @SuppressWarnings("deprecation")
    private void ttsUnder20(String text) {
        mTTSobject.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void ttsGreater21(String text) {
        mTTSobject.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    }
}
