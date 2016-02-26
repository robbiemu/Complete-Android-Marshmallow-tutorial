# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## Linear Layout

Linear layout supports two basic `android:orientation`'s: _horizontal,_ and _vertical_. The layout automatically creates columnar divisions (columns or rows), one for each item dragged into it. The objects are therefore serialized in their layout across the page. 

_Question: What do `layout_weight` and `layout_gravity` do to Views?_

### The [layout_gravity](http://developer.android.com/reference/android/widget/LinearLayout.LayoutParams.html#attr_android:layout_gravity) and [gravity](http://developer.android.com/reference/android/widget/LinearLayout.html#attr_android:gravity) attribute

![](http://i.stack.imgur.com/nymDt.png)

The attribute `layout gravity` of a View in a Viewgroup (the LinearLayout and FrameLayout) will align the _inline position_ of the View within its container _with respect to the container's orientation_. So that `android:layout_gravity="left"` will put the View item aligned left (the default). _right_ will align it to the right of the width of the layout, The layout must not `wrap_content` in the direction of the alignment for you to see a change.

_from the documentation: Standard gravity constant that a child supplies to its parent. Defines how the child view should be positioned, on both the X and Y axes, within its enclosing layout._

The `android:gravity` attribute of a View specifies how it should position it's own content, using the same keywords. It has no effect if the element has `wrap_content` set for its spacial dimensions.

For a great illustration of the difference between `gravity` and `layout_gravity` see this [stackexchange answer](http://stackoverflow.com/questions/3482742/gravity-and-layout-gravity-on-android#answer-26190050).

Keyowrds can be chained together with the "pipe" character, such as `bottom|right`.
 
_see also: [Gravity](http://developer.android.com/reference/android/view/Gravity.html) _

## Padding and Margin

![](http://storage15.tunefiles.com/files/thumbs/2014/06/02/1401653645fa1bf-original-1.jpg)

Padding spaces content within the element. Margin changes the spacing around the element.

## [weightSum](http://developer.android.com/reference/android/widget/LinearLayout.html#attr_android:weightSum) and [layout_weight](http://developer.android.com/reference/android/widget/LinearLayout.LayoutParams.html#attr_android:layout_weight)

The `weightSum` attribute of a viewgroup defines a total weight to be distributed among the children of the viewgroup.

The `layout_weight` of an element defines the relative weight of the `weightsum` total that the element demands (or by tedfault, of the total of all the weights, I imagine). Assuming no `layout_width` , etc is competing with the specified values here, the proportions specified are applied to the layout's cells to mete out space to the children.

If the weightSum is higher than the sum of the child layout_weights, the remaining portion will be empty space.

Another interesting effect you can achieve is to take a layout that has N elements, but specify instead some M-column or M-row division of the space. For example, 3 Views with a weightSum of 4, and one of the views having the `laoyut_weight` of 2, would divide it up into a 4 column layout, the last View taking the space of 2 columns.