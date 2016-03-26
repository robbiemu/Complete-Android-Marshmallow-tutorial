# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## Radio Button and Custom Radio Button with Graphics

3 ways to handle radio button input event

1. implementing onCheckedChangeListener in Activity
2. Using a [OnCheckedChangeListener](](http://developer.android.com/reference/android/widget/RadioGroup.OnCheckedChangeListener.html) as an inner class in the (views in the) activity
3. Handling the button through the XML layout by onClick attribute

### onCheckedChangeListener in Activity

* implement the onCheckedChangeListener
    public class Method extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
* set the listener class of the view in onCreate:
    protected void onCreate(Bundle savedInstanceState) {
    ...
        rg_method = (RadioGroup) findViewById(R.id.radio_group_method_select);
        rg_method.setOnCheckedChangeListener(this);
* override the implementable method (still in the activity class):
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(group.getId() == rg_method.getId()) {
            switch (checkedId){
                case R.id.radio_button_method_one:
                        Intent intent = new Intent(this, MethodOne.class);
                        startActivity(intent);
                    break;
                case R.id.radio_button_method_two:
                        Intent intent = new Intent(this, MethodTwo.class);
                        startActivity(intent);
                    break;

                default:
                    Log.e("RadioButtonCheckedExample", "onCheckedChanged - unknown radio button used");
            }
    ...

### Using an inner class:

* implement the onCheckedChangeListener
    public class Method extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
* create the listener in the view in onCreate:
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

### Using XML:

* in each radiobutton in XML (like, under `res/layout`):
            android:onClick="onRadioButtonClicked"
* in the activity class associated with that layout:
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
    
### Adding a custom graphic:

This is just like normal for adding custom graphics to such views:

* add a button graphic to radioButton in the xml:
            android:button="@drawable/custom_button"
* import graphics to use for checked and unchecked states. in this case, I used SVGs, using import Vector Asset on the `res/drawable` folder, and named them checked.xml and unchecked.xml .. I let the import method override their size (default import)
* create a new resource file under `res/drawable` called (in this case) custom_button:
    <?xml version="1.0" encoding="utf-8"?>
    <selector xmlns:android="http://schemas.android.com/apk/res/android">
        <item android:drawable="@drawable/checked" android:state_checked="true" />
        <item android:drawable="@drawable/unchecked" android:state_checked="false" />
    </selector>