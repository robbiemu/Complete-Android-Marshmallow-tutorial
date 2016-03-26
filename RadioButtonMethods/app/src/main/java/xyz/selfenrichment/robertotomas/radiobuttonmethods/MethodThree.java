package xyz.selfenrichment.robertotomas.radiobuttonmethods;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by RobertoTomás on 0025, 25, 3, 2016.
 */
public class MethodThree extends AbstractMethod {
    private RadioGroup rg_extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String title = (String) getSupportActionBar().getTitle();
        title += " - MethodThree";
        getSupportActionBar().setTitle(title);  // provide compatibility to all the versions
    }
    @Override
    int getContentView() {
        return R.layout.activity_method_three;
    }

    @Override
    void setDefaultMethod() {
        rb_default = (RadioButton) findViewById(R.id.radio_button_method_three);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radio_button_extra_option_one:
                Toast.makeText(getApplicationContext(), "Si é italiano", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_button_extra_option_two:
                Toast.makeText(getApplicationContext(), "E non é castellano", Toast.LENGTH_SHORT).show();
                break;
            default:
                Log.e("MethodOne", "onCheckedChanged - unknown radio button used" +
                                getResources().getResourceEntryName(view.getId()) + " (" + view.getId() + ")"
                );
        }
    }
}