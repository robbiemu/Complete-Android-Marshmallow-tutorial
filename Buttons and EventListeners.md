# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## Android Buttons and It's Various Types of EventListeners lesson

### Event Handling.

The flow of Event handling:

1. user event: vg, the user presses an onscreen button
2. the AOS recognizes that this happens on the button, and interrogates it for the button's onClick event
3. the event happens
4. of all the eventlisteners that are out there, those that are registered to that event are called with the event parameters (click occured)
5. the eventlisteners run, processing the event.

#### Setting up an event

This can be done in 2 ways.

1. onclickListener in `Activity` or `Fragment`
2. using an "inner class" onClickListener in the `Activity` or `Fragment` 

You must also add the button to the layout, which can be done in two ways:

1. specifying it in the xml layout for the `activity` or `fragment`
2. generating it programmatically from the `activity` or `fragment`

##### specifying a button in the layout:

This would go into the layout for the `activity` or `fragment`, which is under `res/layout` and is `main.xml` by default. You can drag it in using the gui builder, or write XML like:

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/some_button_text"
        android:id="@+id/some_button"
        android:textStyle="italic"
        android:layout_centerVertical="true"
        android:layout_centerHorizontal="true" />

Specify the text in `res/values/strings.xml` or, simply use the gui builder to create the next text value for you.  Once this is built, you can hook it up to your code:

##### onClickListener in `activity` or `fragment`

Have your `activity` or `fragment` **implement** `View.OnClickListener`. Declare the button in the `activity` or `fragment`. Initialize it and call the `setOnClickListener` method in the `activity` or `fragment`'s `onCreate` method like:

    private class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private Button some_button;
        
        @Override 
        protected void onCreate(Bundle savedInstanceState) {
            some_button = (Button)findViewById(R.id.some_button);
            some_button.setOnClickListener(MainActivity.this); // this is just context() 
    /*...*/

##### onClick

Finally, your `activity` or `fragment` must implement `onClick` to handle the event. It receives a `View` parameter, which is the view object triggering the event: in this case, the button.

#### using an "inner class" onClickListener in the `Activity` or `Fragment

The second way to set up an event is to instead declare the onClick event directly in the setOnlickListener. The key feature here is that, where you call `setOnClickListener` you create and pass an `OnClickListener` object to handle the event. Because of this, your `activity` or `fragment` does not have to implement the `OnClickListener` in its declaration. It is done like this:

    private class MainActivity extends AppCompatActivity {
        private Button some_button;
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            some_button = (Button)findViewById(R.id.some_button);
            some_button.setOnClickListener(new OnClickListener() {
               @Override
               public void onClick(View v){
                   // handle the click event here. v is the button.
               } 
            });
    /*...*/

A difference with this implementation is that, with multiple buttons, the `onClick` method does not automatically trigger a shared method. 
