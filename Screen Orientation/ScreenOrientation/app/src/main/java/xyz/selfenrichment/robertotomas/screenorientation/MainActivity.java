package xyz.selfenrichment.robertotomas.screenorientation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration current_conf) {
        super.onConfigurationChanged(current_conf);

        switch (current_conf.orientation) {
            case Configuration.ORIENTATION_PORTRAIT:
                Toast.makeText(getApplicationContext(), "Portrait mode", Toast.LENGTH_LONG).show();
                break;
            case Configuration.ORIENTATION_LANDSCAPE:
                Toast.makeText(getApplicationContext(), "Landscape mode", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
