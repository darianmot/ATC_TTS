import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class FreeTTS {

    private static final String VOICENAME_kevin = "kevin16";
    private String text; // string to speech

    public FreeTTS(String text) {
        this.text = text;
    }

    public void speak() {
        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICENAME_kevin);
        voice.allocate();
        boolean a = voice.speak(text);
        System.out.print(a);
    }

    public static void main(String[] args) {
        System.setProperty("com.sun.speech.freetts.audio.AudioPlayer.openFailDelayMs", "100");
        System.setProperty("com.sun.speech.freetts.audio.AudioPlayer.totalOpenFailDelayMs", "30000");
        String text = "FreeTTS was written by the Sun Microsystems Laboratories "
                + "Speech Team and is based on CMU's Flite engine.";
        FreeTTS freeTTS = new FreeTTS(text);
        System.out.print("otot0");
        freeTTS.speak();

    }
}