# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## [String Resources](http://developer.android.com/guide/topics/resources/string-resource.html)

You can create your own files to support your own logical organization.

By default, `strings.xml` is under the `res/values` folder, and stores strings in a key-value pair. R.string.name will load the string with that name, like this: `<string name="foo">foo!</string>`

Arrays can also be stored in `strings.xml` using a `string array` element like:

    <string-array name="foo">
        <item>foo</item>
        <item>bar</item>
        <!-- ... -->
    </string>

`R.array.foo` will access this array.

All such strings and string arrays must be defined within an outer `<resources>` tag.