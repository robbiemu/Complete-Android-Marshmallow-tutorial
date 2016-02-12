# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## Toast and its Alignment

Topics of note in the android documentation:

* [Toasts guide](http://developer.android.com/guide/topics/ui/notifiers/toasts.html)
* [When to Confirm or Acknowledge User Actions](http://developer.android.com/design/patterns/confirming-acknowledging.html)
* [Toast widget](http://developer.android.com/reference/android/widget/Toast.html)

A **Toast** is a "popup" that can be interactive, and has an expiration timing. Toasts are useful for confirming or acknowledging user actions, and also as a quick and temporary way to debug (in place of the log).

### [Toasts](http://developer.android.com/guide/topics/ui/notifiers/toasts.html)

#### Creating a toast message

To create a toast use the syntax `Toast toast = Toast.makeText( _CONTEXT_, _INSTANCE_OF_TYPE_, _DURATION_ );`

* Context can come from `_ActivityName_.this`.
* The _INSTANCE_OF_TYPE_ can be either text or an `R.string.FOONAME`

Finally, to actually show the toast, you must call `toast.show();` on the toast object created.

_my question: How can you overlay a black background behind the toast to make it look more modal?_

#### Positioning the toast message

To position a toast, you can use `toast.setGravity( _GRAVITY_, REL_X, REL_Y )`.

This must be done before `show`ing the toast.

Various (mostly relative) positioning constants are defined for you in the [Gravity](http://developer.android.com/reference/android/view/Gravity.html) class. Some common ones are:

* `Gravity.TOP`
* `Gravity.CENTER`
* `Gravity.BOTTOM`
* `Gravity.NO_GRAVITY` — equivalent to not making a call to `setGravity` at all.
 
The `REL_X` and `REL_Y` integers can be position an negative, and shift the positioning of the toast relative to the `GRAVITY` keyword set.

### Custom toasts in Android

You can display a full layout with toasts.

First, create the layout:

    <!-- make note of the id of the toplevel item in the layout -->
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/toast_layout_root"
        android:background="@android:color/darker_gray"
        android:orientation="vertical"
        android:layout_width="match_parent" android:layout_height="match_parent"><!-- specify your own background color -->

    <!-- TODO: Put toast content in here -->
    </LinearLayout>

And add a call to show the toast to your activity:

    private View toast_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    ...
        LayoutInflater inflater = getLayoutInflater();
        toast_view = inflater.inflate(R.layout.toast_custom_toast, (ViewGroup)findViewById(R.id.toast_layout_root));
    }

    public void showToast(View v) {
        Toast t = new Toast(CustomToastActivity.this);
        // set it up
        t.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        t.setDuration(Toast.LENGTH_LONG);
        t.setView(toast_view);

        t.show();
    }

