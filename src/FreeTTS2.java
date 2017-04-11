
/**
 * Copyright 2003 Sun Microsystems, Inc.
 * 
 * See the file "license.terms" for information on usage and
 * redistribution of this file, and for a DISCLAIMER OF ALL 
 * WARRANTIES.
 */
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


/**
 * Simple program to demonstrate the use of the FreeTTS speech
 * synthesizer.  This simple program shows how to use FreeTTS
 * without requiring the Java Speech API (JSAPI).
 */
public class FreeTTS2 {


    public synchronized static void speakText(String text) {

       // listAllVoices();
        
        String voiceName = "kevin16";;
          
         
        
        System.out.println();
       // System.out.println("Using voice: " + voiceName);
        
        /* The VoiceManager manages all the voices for FreeTTS.
         */
        voiceManager = VoiceManager.getInstance();
        helloVoice = voiceManager.getVoice(voiceName);

        if (helloVoice == null) {
            System.err.println(
                "Cannot find a voice named "
                + voiceName + ".  Please specify a different voice.");
            System.exit(1);
        }
        
        /* Allocates the resources for the voice.
         */
        helloVoice.allocate();
        
        helloVoice.setVolume(volumeRate);
        
        helloVoice.setPitch(pitchRate);
        
        helloVoice.setRate(speakingRate);
        
       
        
        /* Synthesize speech.
         */
        helloVoice.speak(text);
                         

        /* Clean up and leave.
         */
        helloVoice.deallocate();
       
    }
    
 public void  setVolume(float sV)
  {
	volumeRate=sV;
  }
 
 public void  setSpeakingRate(float sR)
 {
	speakingRate=sR;
 }
 public void  setPitch(float sP)
 {
	pitchRate=sP;
 }
 public void setRange(float sR)
 {
	rangeRate=sR;
 }
    
private static  VoiceManager voiceManager;
 private  static  Voice helloVoice;
 private static float volumeRate=10;
 private static float speakingRate=150;
 private static float rangeRate=12;
 private static float pitchRate=100;
}
