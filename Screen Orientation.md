# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## Screen orientation and its attached lifecycle

You can rotate the emulater with **Ctrl**+**F11**.

When changing orientation, the layout is redrawn, unless `android:screenOrientation` is set in the `activity` in the manifest file.

You can recieve a call when the screen is rotated by declaring the `onConfigurationChanged()` method for the `activity`.

1. set `android:configChanges="orientation|screenSize|keyboardHidden"` attribute under the `activity` in the manifest.
2. `@Override` the `onConfigurationChanged` method in the `activity` java class.

Other [configChanges](http://developer.android.com/guide/topics/manifest/activity-element.html#config) can be appended with the "pipe" delimiter like "orientation|screenSize|keyboardHidden". Only "orientation" is necessary for android API version 12 and below, but above v.12 you must decalare `android:configChanges="orientation|screenSize"`. Additionally, if the keyboard is visible during a screen rotation the keyboardHidden tag may also be necessary (so using all 3 is a good practice).

## Screen orientation - Preserving the variables and widgets values

Whenever you rotate the device the screen redraws the screen, calling again the `onCreate` method after going through `onPause`..`onDestroy`. In order to save your instance data, there is the `onSaveInstanceState()` method. When the system needs to restore the app, in addition to calling `onCreate` the `onRestoreInstanceState()` is also called to restore the data.  Note that you do not have to specify `android:configChanges` in the manifest to do this.

_**Note**: In order for the Android system to restore the state of the views in your activity, each view must have a unique ID, supplied by the `android:id` attribute._

### see also

* [Recreating an Activity](http://developer.android.com/training/basics/activity-lifecycle/recreating.html)