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
