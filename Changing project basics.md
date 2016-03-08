# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## Changing project basics

### Project Name

You can use the context-menu refactor -> rename t change the project name on the left window tree view of the project. Afterwards, you also need to change the package name in the `manifest`. Finally, you need to change the `import` statements in all of your java class files that referred to the old package name.

### Application Name

This is the name that you would see as a user of the app. In the manifest, you will see the app name is listed under the label attribute of he application tag. It points typically to a `strings.xml` value, which you would change. This is the only change that is necessary. 