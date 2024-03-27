package nl.camorobot.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import nl.camorobot.Jumper;

public class BombPlatform extends Platform implements Collider {

  private Jumper jumper;

  public BombPlatform(Coordinate2D initialLocation, Size size, Jumper jumper) {
    super("sprites/bombPlatform.png", initialLocation, size);
    this.jumper = jumper;
    setMotion(1,0d);
  }

  @Override
  public void activeerEffect() {
    jumper.setDeadMessage("Bomb");
    jumper.setActiveScene(2);
  }
}
