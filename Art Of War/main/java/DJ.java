import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
public class DJ {
    Clip clipMenu;
    Clip clipDefeat;
    Clip clipCombat;
    Clip clipVictory;
    public DJ(){

    }

    public void playAttack(){
        try{
            AudioInputStream ais=AudioSystem.getAudioInputStream(new File("src/main/resources/Attack.wav").getAbsoluteFile());
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
            AudioInputStream ais=AudioSystem.getAudioInputStream(new File("src/main/resources/Moverse.wav").getAbsoluteFile());
            Clip clip =AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        }catch(Exception ex)
        {
            System.out.println("no se pudo reproducir");
        }
    }
    public void playDefend(){
        try{
            AudioInputStream ais=AudioSystem.getAudioInputStream(new File("src/main/resources/block.wav").getAbsoluteFile());
            Clip clip =AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        }catch(Exception ex)
        {
            System.out.println("no se pudo reproducir");
        }
    }
    public void playMenu() {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src/main/resources/Menu.wav").getAbsoluteFile());
            clipMenu = AudioSystem.getClip();
            clipMenu.open(ais);
            clipMenu.start();
            clipMenu.loop(10);
        } catch (Exception ex) {

            System.out.println("no se pudo reproducir");

        }
    }
    public void playVictory(){

        try {
            clipCombat.close();
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src/main/resources/Victory.wav").getAbsoluteFile());
            clipVictory = AudioSystem.getClip();
            clipVictory.open(ais);
            clipVictory.start();
        } catch (Exception ex) {

            System.out.println("no se pudo reproducir");

        }
    }
    public void playDefeat(){
        try {
        clipCombat.close();
        AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src/main/resources/Defeat.wav").getAbsoluteFile());
        clipDefeat = AudioSystem.getClip();
        clipDefeat.open(ais);
        clipDefeat.start();
    } catch (Exception ex) {

        System.out.println("no se pudo reproducir");

    }

    }
    public void playCombat(){
        try{
            clipCombat.close();
            AudioInputStream ais=AudioSystem.getAudioInputStream(new File("src/main/resources/Combat.wav").getAbsoluteFile());
            clipCombat =AudioSystem.getClip();
            clipCombat.open(ais);
            clipCombat.start();
        }catch(Exception ex)
        {
            System.out.println("no se pudo reproducir");
        }
    }
}