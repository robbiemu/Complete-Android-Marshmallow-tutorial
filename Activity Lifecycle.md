# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## Activity LifeCycle - in context of two Acitvities

### The Acitivty Lifecycle

An activity has methods that are always executed at various states of the application:

* onCreate - called from the launch of the application. initialize your variables and widgets
* onStart - called as soon as oncreate completes
* onResume - called immediately from onstart, and at any point when the application because interactive
* onPause - called when switching acitivties through intents, etc (as soon as oncreate is triggered elsewhere)
* onStop - called from a subactivity when onResume kicks off in the main activity, and called when triggering "back" from an activity
* onDestroy - called after onStrop, when an activity should no longer be visible.
* onRestart - called when switching back to an already launched acitivty that has not been closed. It passes subsequently will call onStart, not onCreate.

### the Stack concept regarding the activity lifecycle