# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## Explicit Intents: Its all Three methods in detail

In a project's `AndroidManifest.xml` file we have to specify each activity like:

    <activity android:name="com.cannanical.name.ActivityName"
            android:label="@string/app_name"><!-- main activity -->
        <intent-filter>
            <action ..android:name="andoird.intent.action.MAIN" />
            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
    </activity>
    
If we specify a new page to work from, it will be it's own Activity, and require its own section in the manifest:

    <activity android:name="com.cannanical.name.ActivityName"
            android:label="@string/app_name">
        <intent-filter>
            <action android:name="com.cannanlical.name.SubActivity" />
            <category android:name="android.intent.category.DEFAULT" />
        </intent-filter>
    </activity>
    
Each application who's intent category is a `_LAUNCHER_` will be it's own icon in the app drawer, and will open the app to that activity.

#### first explicit intent pattern

An explicit intent call is specified programatically: `Intent i = new Intent(fromActivityName.this /* context */, toActivityName.class); startActivity(i);` When an activity is always called from an intent like this, you only need to specify the activity element itself, noneof the child elements, in the manifest. 

#### second

The explicit intent call can skip the context: `Intent i = new Intent("toActivityName"); startActivity(i);` In this case, the `intent-filter` of the entry in the manifest must be filled in.

#### third

The final way is:

    Intent i = new Intent();
    i.setClassName("packageName", "packageName.toActivityName");
    startActivity(i);

`packageName` is the package name of the application. This is an explicit call which can be used from another application with a different package space. 

