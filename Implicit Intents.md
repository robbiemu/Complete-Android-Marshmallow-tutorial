# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## Implicit Intents

Implicit intents are called through a URI: 

    try {
	    Uri uri = Uri.parse("market://details?id="+ getPackageName());
	    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(goToMarket);
	}catch(ActivityNotFoundException e){
        ...

They are implicit in that they do not specify a handler. _Compare to the original [intents](Intents.md) lesson._
