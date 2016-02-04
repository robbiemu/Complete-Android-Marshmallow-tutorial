# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## Logcat lesson

### The basic concept behind logCat

Logcat is a method of collecting system debug output. It is available from the emulator. You can specify a custom error tag (tpyically named after your application), and priority:

* verbose - `Log.v(String tag, String msg);`
* debug - `Log.d(String tag, String msg);`
* information - `Log.i(String tag, String msg);`
* warning - `Log.w(String tag, String msg);`
* error - `Log.e(String tag, String msg);`
* asserts - are also loggable

A message is logged from a `try/catch` or `throw`, with a command, which is above.

### Using LogCat in Android Studio

In the current android studio you should use the Android Device Monitor (according to Udacity's class).

1. Set up an emulator.
2. Run the Android Device Monitor
3. Run the emulator.
4. add a log call in your `onCreate` in the `mainActivity` (or whereever you would like):
`Log.v(getString(R.string.app_name), "This is a log message")`
5. Save all, Sync, and run in the emulator.
6. specify the package_name in the bottom search critera section in the ADM log. You should see the message.

You must pass a string to the the Log methods, as it will not try to convert it to string for you.