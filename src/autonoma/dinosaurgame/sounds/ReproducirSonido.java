package autonoma.dinosaurgame.sounds;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ReproducirSonido {
    private static Clip clip;

    public static void playSound(String soundFilePath) {
        try {
            if (clip != null && clip.isRunning()) {
                clip.stop();
            }
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(ReproducirSonido.class.getResource(soundFilePath));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error al reproducir sonido: " + ex.getMessage());
        }
    }
}
