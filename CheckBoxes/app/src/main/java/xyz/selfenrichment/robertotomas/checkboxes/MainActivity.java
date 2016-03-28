package xyz.selfenrichment.robertotomas.checkboxes;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    CheckBox cb1m1, cb2m1,
             cb1m2, cb2m2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1m1 = (CheckBox) findViewById(R.id.checkBox1_method1);
        cb2m1 = (CheckBox) findViewById(R.id.checkBox2_method1);

        cb1m1.setOnCheckedChangeListener(this);
        cb2m1.setOnCheckedChangeListener(this);

        cb1m2 = (CheckBox) findViewById(R.id.checkBox1_method2);
        cb2m2 = (CheckBox) findViewById(R.id.checkBox2_method2);

        cb1m2.setOnCheckedChangeListener(new Method2Listener(this));
        cb2m2.setOnCheckedChangeListener(new Method2Listener(this));
    }

    public void Method3Listener(View v) {
        switch (v.getId()) {
            case R.id.checkBox1_method3:
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(this, "People used to think milk was good for you.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Good for you!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkBox2_method3:
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(this, "Water is good, but it only keeps you hydrated.", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Log.w("MainActivity", "unknown checkbox checked.");
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.checkBox1_method1:
                if (isChecked) {
                    Toast.makeText(this, "You want pizza!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkBox2_method1:
                if (isChecked) {
                    Toast.makeText(this, "You want hamburger?!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "That's better.", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Log.w("MainActivity", "unknown checkbox checked.");
                break;
        }
    }

    public class Method2Listener implements CompoundButton.OnCheckedChangeListener {
        private Context pContext;

        Method2Listener(Context context) {
            pContext = context;
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {
                Toast.makeText(pContext, "Either way, good choice.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
