package xyz.selfenrichment.robertotomas.radiobuttonmethods;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by RobertoTomás on 0025, 25, 3, 2016.
 */
public class MethodTwo extends AbstractMethod {
    private RadioGroup rg_extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String title = (String) getSupportActionBar().getTitle();
        title += " - MethodTwo";
        getSupportActionBar().setTitle(title);  // provide compatibility to all the versions

        rg_extra = (RadioGroup) findViewById(R.id.radio_group_extra);
        rg_extra.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_button_extra_option_one:
                        Toast.makeText(getApplicationContext(), "Sim em português", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_button_extra_option_two:
                        Toast.makeText(getApplicationContext(), "No en castellano", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Log.e("MethodOne", "onCheckedChanged - unknown radio button used" +
                                        getResources().getResourceEntryName(checkedId) + " (" + checkedId + ")"
                        );
                }
            }
        });
    }
    @Override
    int getContentView() {
        return R.layout.activity_method_two;
    }

    @Override
    void setDefaultMethod() {
        rb_default = (RadioButton) findViewById(R.id.radio_button_method_two);
    }

}
