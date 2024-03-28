package nl.camorobot.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import nl.camorobot.Jumper;

public class BombPlatform extends Platform {

  private final Jumper JUMPER;

  public BombPlatform(Coordinate2D initialLocation, Size size, Jumper jumper) {
    super("sprites/bombPlatform.png", initialLocation, size);
    this.JUMPER = jumper;
    setMotion(1,0d);
  }

  // This method will be called when the player collides with the bomb platform
  // The player will die and the game will be over
  @Override
  public void activeerEffect() {
    JUMPER.setDeadMessage("Bomb");
    JUMPER.setActiveScene(2);
  }
}
