package xyz.selfenrichment.robertotomas.preservingstate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int score;
    private EditText et;
    private String ets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0;
        et = (EditText)findViewById(R.id.editText);
    }

    @Override
    protected void onSaveInstanceState(Bundle b) {
        super.onSaveInstanceState(b);

        ets = et.getText().toString();

        b.putString("edittext", ets);
        b.putInt("score", score);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ets = savedInstanceState.getString("edittext");
        et.setText(ets);

        score = savedInstanceState.getInt("score");
    }

    public void performAction(View v){
        switch (v.getId()) {
            case R.id.button_increment:
                score += 1;
                break;
            case R.id.button_show:
                Toast.makeText(getApplicationContext(), "score: " + score, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
