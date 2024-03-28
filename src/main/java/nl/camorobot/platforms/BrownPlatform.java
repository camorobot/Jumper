package nl.camorobot.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import nl.camorobot.entities.player.Player;

public class BrownPlatform extends Platform{

  private final Player PLAYER;

  private Boolean isBroken = false;

  public BrownPlatform(Coordinate2D initialLocation ,Player player) {
    super("sprites/brownPlatform_sprites.png", initialLocation, new Size(165, 42), 1, 2);
    setCurrentFrameIndex(1);
    this.PLAYER = player;
  }

  // This method will be called when the player collides with the brown platform
  // The platform will break and the player will be boosted
  @Override
  public void activeerEffect() {
    if(!isBroken){
      isBroken = true;
      PLAYER.setMotion(10, 180d);
      setCurrentFrameIndex(0);
    }

  }

}
