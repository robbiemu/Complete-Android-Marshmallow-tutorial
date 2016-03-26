package xyz.selfenrichment.robertotomas.radiobuttonmethods;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MethodOne extends AbstractMethod {
    private RadioGroup rg_extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String title = (String) getSupportActionBar().getTitle();
        title += " - MethodOne";
        getSupportActionBar().setTitle(title);

        rg_extra = (RadioGroup) findViewById(R.id.radio_group_extra);
        rg_extra.setOnCheckedChangeListener(this);
    }

    @Override
    int getContentView() {
        return R.layout.activity_method_one;
    }

    @Override
    void setDefaultMethod() {
        rb_default = (RadioButton) findViewById(R.id.radio_button_method_one);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (group.getId() == rg_extra.getId()) {
            switch (checkedId) {
                case R.id.radio_button_extra_option_one:
                    Toast.makeText(getApplicationContext(), "Sí en español", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radio_button_extra_option_two:
                    Toast.makeText(getApplicationContext(), "Não em português", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Log.e("MethodOne", "onCheckedChanged - unknown radio button used" +
                              getResources().getResourceEntryName(checkedId) + " (" + checkedId + ")"
                    );
            }
        } else {
            super.onCheckedChanged(group, checkedId);
        }
    }
}
