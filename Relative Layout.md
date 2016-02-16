# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## Relative Layout lesson

### Making an app

We will be making an app that utilizes buttons that load different pages, with dynamic data on each page, and tie in to the google speach system to read the text aloud.
 
 This project will review:
* consider different screen sizes 
* tablets too
* from 2.2 Froyo forward (ugh!)
* relative and linear layout
* `scrollview`
* UI - styling and graphics
* action bar with widgets
* text to speech conversion

[Units](http://stackoverflow.com/questions/2025282/difference-between-px-dp-dip-and-sp-on-android): we will be using `dp` (density-independent pixels) for specifying buttons and layout, and `sp` for text.

### [Relative layout](http://developer.android.com/guide/topics/ui/layout/relative.html) and its attributes

Relative layout divides the screen into 4 quadrants.

Alignment of views in the layout will be relative to `ParentLeft` and `ParentTop` in the top left quadrant (with margins specifying how far from the edge the view should be placed), and so on for each of the 4 quadrants. `centerHorizontal` and `centerVertical` is used for views aligned on the division between the four quadrants. `layout_below` and `layout_above`, etc can be used to specify a view's layout relative to another view.

#### assignment of Resources in XML

In XML layouts you will see assignments like `android:id="@+id/FOO"`. Other strings, etc, have no plus. Neither does an id have a + sign in front of it when used in a different attribute in the layout, like `alignRight="@id/button"`. This is because the plus symbol differntiates from the normal `@id` and is used for the declaration and initialization of the id from the xml layout. Without the `+`, it would instead refer directly to an id that was already specified.

