# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## Checkbox and Custom CheckBox with Graphics

### 3 ways to handle cehckbox input event

#### implementing onCheckedChangeListener in Activity

1. initialize `CheckBox`-es
2. implement the `CompoundButton.OnCheckedChangeListener` listener / override method
3. for each Checkbox in `onCreate`, `setonCheckedChangeListener(this)`
4. in `onCheckedChanged` detect which button with `getId` etc, and _do work_

#### Using a OnCheckedChangeListeneras an inner class in the (views in the) activity

1. initialize `CheckBox`-es
2. implement the listener as an inner class in each button

#### Handling the button through the XML layout by onClick attribute

1. add `android:onClick="_SomeListenerMethod_"` to the checkboxes
2. add the method as a pbulci method in the activity/fragment 

### Custom checkboxes 
Using Images, Graphics and Selectors to customize CheckBox

There are two ways to illustrate.

#### Adding `android:background`

1. import drawables for checked and unchecked states
2. create a drawable resource xml with lines for each state:

    <!-- these next two MUST be in separate items! -->
    <item android:drawable="@drawable/checked" android:state_checked="true" />
    <item android:drawable="@drawable/checked" android:state_pressed="true" />
    <item android:drawable="@drawable/unchecked" />

3. remove the text label! use a separate textview for that if you need to (in a vertical linearlayout)
4. use `android:background="_mydrawableresourse_"`

#### Using RGB valued Shapes instead of Images

1. create 3 drawable resources, the checkbox resource and one for checked and unchecked states.
2. in the checked and unchecked states, use a `<shape>` tag in place of a `<selector>` tag, for example:

    <?xml version="1.0" encoding="utf-8"?>
    <shape xmlns:android="http://schemas.android.com/apk/res/android"
        android:shape="rectangle" >

        <solid android:color="#FFFFFF" />
        <stroke android:width="4dp"
            android:color="#c0c0c0" />
        <size android:width="20dp" android:height="20dp" />
    </shape>
Set the `solid` color to different colors for on and off states.
3. in the drawable resource, make it as before, pointing to the two files you've made.
4. remove the text label! use a separate textview for that if you need to (in a vertical linearlayout)
5. use `android:background="_mydrawableresourse_"`
