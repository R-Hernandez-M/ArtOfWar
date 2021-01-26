import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
public class DJ {
    public DJ(){

    }

    public void playAttack(){
        try{
            AudioInputStream ais=AudioSystem.getAudioInputStream(new File("C:\\Users\\Kayserend\\IdeaProjects\\learn jpanel\\src\\nian.wav").getAbsoluteFile());
            Clip clip =AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        }catch(Exception ex)
        {
            System.out.println("no se pudo reproducir");
        }
    }
    public void playMove(){
        try{
            AudioInputStream ais=AudioSystem.getAudioInputStream(new File("C:\\Users\\Kayserend\\IdeaProjects\\learn jpanel\\src\\nian.wav").getAbsoluteFile());
            Clip clip =AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        }catch(Exception ex)
        {
            System.out.println("no se pudo reproducir");
        }
    }
    public void playDefend(){

    }
    public void playMenu(){

    }
    public void playVictory(){

    }
    public void playDefeat(){

    }
    public void playCombat(){
        try{
            AudioInputStream ais=AudioSystem.getAudioInputStream(new File("src/main/resources/Combat.wav").getAbsoluteFile());
            Clip clip =AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        }catch(Exception ex)
        {
            System.out.println("no se pudo reproducir");
        }
    }
}
