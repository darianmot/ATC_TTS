import marytts.LocalMaryInterface;
import marytts.util.data.audio.MaryAudioUtils;
import marytts.util.dom.DomUtils;
import org.w3c.dom.Document;
import sun.audio.AudioPlayer;
import javax.sound.sampled.*;
import java.io.File;


public class MaryTTS {

    public void saveStream(AudioInputStream stream, String outputFileName){
        /**
         * Save the stream to an .wav output file
         */
        double[] samples = MaryAudioUtils.getSamplesAsDoubleArray(stream);
        try {
            MaryAudioUtils.writeWavFile(samples, outputFileName, stream.getFormat());
            System.out.println("Output written to " + outputFileName);
        } catch (Exception e) {
            System.err.println("Could not write to file: " + outputFileName + "\n" + e.getMessage());
            System.exit(1);
        }
    }


    public static void main (String arg[]){
        try {
            LocalMaryInterface myinterface = new LocalMaryInterface();
            System.out.println(myinterface.getAvailableVoices());

            File xml = new File("data/test.xml");
            Document ssml = DomUtils.parseDocument(xml);
            myinterface.setInputType("SSML");
            AudioInputStream stream =  myinterface.generateAudio(ssml);


            AudioFormat format;
            DataLine.Info info;
            Clip clip;
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
            while (!clip.isRunning())
                Thread.sleep(10);
            while (clip.isRunning())
                Thread.sleep(10);

            clip.close();
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
