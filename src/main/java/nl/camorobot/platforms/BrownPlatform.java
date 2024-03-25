package nl.camorobot.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import nl.camorobot.entities.player.Player;

public class BrownPlatform extends Platform{

  private Player player;
  private Coordinate2D initialLocation;
  private Boolean isBroken = false;

  public BrownPlatform(Coordinate2D initialLocation ,Player player) {
    super("sprites/brownPlatform_sprites.png", initialLocation, new Size(165, 42), 1, 2);
    setCurrentFrameIndex(1);
    this.initialLocation = initialLocation;
    this.player = player;
  }

  @Override
  public void activeerEffect() {
    System.out.println("Brown platform activeert effect");

    if(!isBroken){
      isBroken = true;
      player.setMotion(10, 180d);
      setCurrentFrameIndex(0);
    }

  }

}
