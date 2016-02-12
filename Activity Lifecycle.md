# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## [Activity LifeCycle](http://developer.android.com/reference/android/app/Activity.html) - in context of two [Activities](http://developer.android.com/guide/components/activities.html)

Topics of note in the android documentation:

* [Process Lifecycle](http://developer.android.com/reference/android/app/Activity.html#ProcessLifecycle)
* [Activity Lifecycle](http://developer.android.com/reference/android/app/Activity.html#ActivityLifecycle)
* [Activities guide](http://developer.android.com/guide/components/activities.html)

![](http://developer.android.com/images/activity_lifecycle.png)

### The Acitivty Lifecycle

An activity has methods that are always executed at various states of the application:

* onCreate - called from the launch of the application. initialize your variables and widgets
* onStart - called as soon as oncreate completes
* onResume - called immediately from onstart, and at any point when the application because interactive
* onPause - called when switching acitivties through intents, etc (as soon as oncreate is triggered elsewhere)
* onStop - called from a subactivity when onResume kicks off in the main activity, and called when triggering "back" from an activity
* onDestroy - called after onStrop, when an activity should no longer be visible.
* onRestart - called when switching back to an already launched acitivty that has not been closed. It passes subsequently will call onStart, not onCreate.

#### my question: is there any sort of `onFirstCreate`?

answer: The `onCreate` method also provides you with a Bundle (it accepts the parameter) containing the activity's previously frozen state, if there was one. In addition, the method onSaveInstanceState(Bundle) is called before placing the activity in such a background state, allowing you to save away any dynamic instance state in your activity into the given Bundle, to be later received in onCreate(Bundle) if the activity needs to be re-created.

### the Stack concept regarding the activity lifecycle

A `stack` is a structure that collects data and does something with each piece, one at a time, in a "Last in, first out" manner (always working from the top of the stack).

Android uses a stack as a pattern to run apps on the device. Gogin from "activity a" to "activity b" to "activity c", and them completeing work in "activity c", android returns the user to "activity b" not "activity a".
