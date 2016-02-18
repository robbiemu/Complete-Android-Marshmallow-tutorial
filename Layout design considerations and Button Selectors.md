# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## Multiple Screen Support Layout Designing and Button Selectors

### Screen Density, Size, and Text Size, and Units

![](http://i.stack.imgur.com/kV4Oh.png)

#### [Screen Support](http://developer.android.com/guide/practices/screens_support.html)

![](https://media-mediatemple.netdna-ssl.com/wp-content/uploads/2011/06/two-mobiles.jpg)

_Screen size_ is always the diagonal. There are four categories:

1. Small - small - 2-3.7"
2. Normal - normal - 3.7-4.3"
3. Large - large - 4-7"
4. Extra Large - xlarge - 7-10"

These size groups are depreciated starting with **API 13** in favor of a new technique for managing screen sizes based on the available screen width. see [Declaring Tablet Layouts for Android 3.2](http://developer.android.com/guide/practices/screens_support.html#DeclaringTabletLayouts)

_Screen density_ is the dpi. The categories are:

![](https://pixplicity.com/wp-content/uploads/2014/04/android_dpi_categories_chart.png)

1. Low density - ldpi - 100-130dpi - ~120dpi
2. Medium density - mdpi - 120dpi-180dpi - ~160dpi
3. High density - hdpi - 180-280dpi - ~240dpi
4. Extra-high density - xhdpi - 280dpi-360dpi - ~320dpi
5. Extra-extra-high density - xxhdpi - ~480dpi
6. Extra-extra-extra-high density xxxhdpi - ~640dpi

_note: as of some years ago, **hdpi** had become the defacto standard for display. Currently, most new displays are 1080p and are either **xhdpi** or **xxhdpi**. Most premium displays are **xxxhdpi** with some **xxhdpi**._

#### Units

![](http://vinsol.com/blog/wp-content/uploads/2014/11/screens-densities.png)

At runtime, _dp_ and _sp_ is converted into pixels. Fonts use _sp_, widgets and views and viewgroups use _dp_. The formula used is:

    px = dp * (dpi / 160)
    
Such that _mdpi_ displays do not modify the dp value (and so `dp = px`), and _xhdpi will set `dp = 2px`.

If we declare sizes in _px_ they will be literal, and will vary significantly from device to device.

_note: with devices like tablets that are meant to be much larger, isntead of just scaling the views appropriately, one can use [Framgments](http://developer.android.com/guide/practices/tablets-and-handsets.html) to create partial views and the partition the screen with them as desired. This way more information is visible only on larger screens, while navigating to the other fragments on smaller screens would require actual navigation, and those elements owuld not be on the default activity of the app._

#### App icon dimensions

![](http://i.stack.imgur.com/HYLWx.png)
_note: in this image, the icons are scaled relative to their approrpiate size, but the details below them both specify the target screen, not the px size of the icons._

* ldpi - 36x36px
* mdpi - 48px sq
* hdpi - 72px sq
* xhdpi - 96px sq
* xxhdpi - 144px sq
* xxxhdpi - 192px sq

You used to have to generate these yourself, but Android studio will do it for you now (although, not of very high quality).

_note: to create an icon for different densities, you should follow the 2:3:4:6:8 scaling ratio between the five primary densities (medium, high, x-high, xx-high, and xxx-high respectively)_

#### Background dimensions

To create a fill background image. The numbers he gives seem wrong to me. He gives:

* ldpi - 240x320px
* mdpi - 320x480px
* hdpi - 480x800px
* xhdpi - 720x1280px

But the screen sizes the android documentation lists are:

* xlarge screens are at least 960dp x 720dp
* large screens are at least 640dp x 480dp
* normal screens are at least 470dp x 320dp
* small screens are at least 426dp x 320dp

Note these are _dp_ values. A full px table would be like these:

##### ldpi
* xlarge screens are at least 480x360px
* large screens are at least 320x240px
* normal screens are at least 235x160px
* small screens are at least 213x160px

##### mdpi
* xlarge screens are at least 960x720px
* large screens are at least 640x480px
* normal screens are at least 470x320px
* small screens are at least 426x320px

and so on..

### Layout and images for multiple screens

_note: When specifying layout and other variations in **xml**, it is important to never change the ids of the elements from one directory's copy to another_

* `res/drawable` - the default image (if there was no dpi keyword match)
* `res/drawable-ldpi` - for ldpi
* `res/drawable-mdpi` -hdpi, etc - for the respective _screen density_   

#### Generic layout

mostly for old phones, around API v8 (Android Froyo 2.2) 

##### Portrait
* `res/layout` - default
* `res/layout-small` -these can be manually created for specific device size/dpi devices
* `res/layout-normal`
* `res/layout-large`
* `res/layout-xlarge`
##### Landscape
add a suffix -land like: `res/layout-land`, `res/layout-small-land`, etc

#### Google layout

for API 13 and above

##### Portrait and Landscape
* `res/layout` - default
* `res/layout-sw320dp` - "smallest width" see [Declaring Tablet Layouts](http://developer.android.com/guide/practices/screens_support.html#DeclaringTabletLayouts) 
* other values are also somewhat common: `res/layout-sw480dp`, `res/layout-sw600dp`, `res/layout-sw720dp`
* `res/layout-w320dp` - this is another form of specification available. Here it is absolute width, so if in landscape mode the device is wide enough, it will switch.

_notes:_ The 'smallest width' could have been better called 'shortest dimension'.

Alternate width spefications are mainly used with tablets.

These layouts will tend to be done with [Fragments](http://developer.android.com/guide/components/fragments.html).

### [Selectors](http://developer.android.com/reference/java/nio/channels/Selector.html)

_see also: [Drawable Resources](http://developer.android.com/guide/topics/resources/drawable-resource.html)_

Creating an xml under `res/drawable` will create an empty `selector` element. In this element, you can define `item` elements, that pint to a recsource for different states of the item. For example, you can use this to give a different background image to your button when pressed. Here is an example:

    <?xml version="1.0" encoding="utf-8"?>
    <selector xmlns:android="http://schemas.android.com/apk/res/android">

        <item android:drawable="@drawable/button_background_pressed" android:state_pressed="true" />
        <!--<item android:drawable="@drawable/button_background_focused" android:state_focused="true" />-->

        <item android:drawable="@drawable/button_background" />
    </selector>

The drawables must be present, and the layout using the selector definitions must use the name of the xml file for the background declaration, like:

    <Button
        android:text="@string/a_button"
        android:id="@+id/a_button"
        android:background="@drawable/button_states" />
        
Selectors can be used for out `View` ui objects, and can select mroe than simple states.
