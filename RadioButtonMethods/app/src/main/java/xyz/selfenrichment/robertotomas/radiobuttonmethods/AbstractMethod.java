package xyz.selfenrichment.robertotomas.radiobuttonmethods;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by RobertoTomás on 0025, 25, 3, 2016.
 */
public abstract class AbstractMethod extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup rg_method;
    RadioButton rb_default;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentView());

        setDefaultMethod();
        rb_default.setChecked(true);

        rg_method = (RadioGroup) findViewById(R.id.radio_group_method_select);
        rg_method.setOnCheckedChangeListener(this);
    }

    /**
     * getContentView return layout, eg R.layout.foo
     */
    abstract int getContentView();

    /**
     * set_default_method should set rb_default appropriately for the activity.
     */
    abstract void setDefaultMethod();

    /**
     * This should be overridden in implementation if there is more than one radio, calling super on failure to match custom events.
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(group.getId() == rg_method.getId()) {
            switch (checkedId){
                case R.id.radio_button_method_one:
                    if(rb_default.getId() != R.id.radio_button_method_one){
                        Intent intent = new Intent(this, MethodOne.class);
                        startActivity(intent);
                    }
                    break;
                case R.id.radio_button_method_two:
                    if(rb_default.getId() != R.id.radio_button_method_two){
                        Intent intent = new Intent(this, MethodTwo.class);
                        startActivity(intent);
                    }
                    break;
                case R.id.radio_button_method_three:
                    if(rb_default.getId() != R.id.radio_button_method_three){
                        Intent intent = new Intent(this, MethodThree.class);
                        startActivity(intent);
                    }
                    break;
                default:
                    Log.e("AbstractMethod", "onCheckedChanged - unknown radio button used");
            }
        } else {
            Log.e("AbstractMethod",
                    "onCheckedChanged - unknown radio group used: " +
                            getResources().getResourceEntryName(group.getId()) + " (" + group.getId() + ")" +
                    " instead of: " +
                            getResources().getResourceEntryName(rg_method.getId()) + " (" + rg_method.getId() + ")"
            );
        }
    }

}
