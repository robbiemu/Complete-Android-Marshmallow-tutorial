# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## [App Bar](http://developer.android.com/training/appbar/index.html)

note: Beginning with Android 3.0 (API level 11), all activities that use the default theme have an ActionBar as an app bar. However, app bar features have gradually been added to the native ActionBar over various Android releases. As a result, the native ActionBar behaves differently depending on what version of the Android system a device may be using. By contrast, the most recent features are added to the support library's version of Toolbar, and they are available on any device that can use the support library.

For this reason, you should use the support library's Toolbar class to implement your activities' app bars. Using the support library's toolbar helps ensure that your app will have consistent behavior across the widest range of devices. For example, the Toolbar widget provides a material design experience on devices running Android 2.1 (API level 7) or later, but the native action bar doesn't support material design unless the device is running Android 5.0 (API level 21) or later.

### [Toolbar method](http://developer.android.com/training/appbar/setting-up.html)

_note: this is the version described by android developer's documentation_

#### Add a Toolbar to an Activity
These steps describe how to set up a Toolbar as your activity's app bar:

1. Add the the v7 appcompat support library to your project, as described in Support Library Setup.
2. Make sure the activity extends AppCompatActivity:
    public class MyActivity extends AppCompatActivity {
    // ...
    }
_Note: Make this change for every activity in your app that uses a Toolbar as an app bar._

3. In the app manifest, set the <application> element to use one of appcompat's NoActionBar themes. Using one of these themes prevents the app from using the native ActionBar class to provide the app bar. For example:
    <application
    android:theme="@style/Theme.AppCompat.Light.NoActionBar"
    />
4. Add a Toolbar to the activity's layout. For example, the following layout code adds a Toolbar and gives it the appearance of floating above the activity:
    <android.support.v7.widget.Toolbar
    android:id="@+id/my_toolbar"
    android:layout_width="match_parent"
    android:layout_height="?attr/actionBarSize"
    android:background="?attr/colorPrimary"
    android:elevation="4dp"
    android:theme="@style/ThemeOverlay.AppCompat.ActionBar"
    app:popupTheme="@style/ThemeOverlay.AppCompat.Light"/>
The [Material Design specification](https://www.google.com/design/spec/what-is-material/elevation-shadows.html#elevation-shadows-shadows) recommends that app bars have an elevation of 4 dp.
Position the toolbar at the top of the activity's layout, since you are using it as an app bar.

### The Complete Android Marshmallow method

#### Prerequistes
1. extend `ActionBarActivity` from `include android.support.v7.app.ActionBarActivity` as the class for your Activity.
2. the theme in the manifest `application` section must point to Theme.AppCompat.Light v2.1+ (this is usually set in the manifest to point to the styles.xml. there, the name must be the name specified in `@style/_name_` in the manifest, and the parent must be "Theme.AppCompat.Light").
3. minimum and target SDK must be 7+, and latest version.

#### Steps
1. create an XML layout for the titlebar. Use a `LinearLayout` with an assigned id. It should have horizontal orientation. Set height to something like 60dp. You can customize the look of the background image, color, etc, here.
2. add widgets at this point. You'll likely want at least a textview for the app name, with something like 30sp as the size.
3. In your activity, set the titlebar, like:

		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setCustomView(R.layout.custom_titlebar); // name of layout XML file

If you need to access the titlebar programmatically, you can use a simple id lookup (since you set an id on the layout in step one):

		LinearLayout titlebar_linearlayout = (LinearLayout) findViewById(R.id.custom_titlebar);

