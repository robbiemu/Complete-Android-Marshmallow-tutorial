# Complete Android Marshmallow tutorial
@ [Complete Web Developer](http://www.completewebdeveloper.com)

## [Text-to-Speech](http://developer.android.com/reference/android/speech/tts/TextToSpeech.html)

Text-to-speech allows for text-to-speech conversion to the end user as long as their language is supported (assuming, I suppose, that the source in the app is also in that language).

Basically, you:

1. create an `TextToSpeech ttsobject` in your app. 
2. In the activity, initialize it with 

    ttsobject = new TextToSpeech( this_or_get_context_, new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status){
            if ( status == TextToSpeech.SUCCESS ) {
                // set language, such as:
                mSetLocaleResult = ttsobject.setLanguage(Locale.US); // in scope of the view visible in the next step
            } else {
                // handle error, notifying th user of a problem. Such as:
                Toast.makeText(getApplicationContext(),
				    "TTS Feature not Supported in Your Device",
					Toast.LENGTH_SHORT
                ).show();
            }
        }
     ... 
    });
3. In the view (ie button) for triggering the TTS event, in the onClick event for it (or however the user tirggers it):

    if (mSetLocaleResult == TextToSpeech.LANG_NOT_SUPPORTED
					|| mSetLocaleResult == TextToSpeech.LANG_MISSING_DATA){
	
    			Toast.makeText(getApplicationContext(),
						"TTS Feature not Supported in Your Device for the Locale: " + Locale.US.toString(),
						Toast.LENGTH_SHORT).show();
    } else {
        ttsobject.speak( text, TextToSpeech.QUEUE_FLUSH, null );
    }

Note: as of API 21, this simple call to `speak()` is depreciated. Instead, follow this pattern:

Instead calling tts.speak() directly, put the following if-else statement.

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        ttsGreater21(text);
    } else {
        ttsUnder20(text);
    }

Then declare ttsGreater21() and ttsUnder20() as follows.

    @SuppressWarnings("deprecation")
    private void ttsUnder20(String text) {
        HashMap<String, String> map = new HashMap<>(); // replace this with a real application index of TTS utterances
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, map);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void ttsGreater21(String text) {
        String utteranceId=this.hashCode() + "";
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    } 
    
Or, if you aren't interested in storing your utternace maps for faster performance, you can shorten the call block to:

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    } else {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

from: http://stackoverflow.com/questions/27968146/texttospeech-with-api-21

