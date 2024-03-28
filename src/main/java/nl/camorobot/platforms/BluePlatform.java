package nl.camorobot.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.camorobot.entities.player.Player;

public class BluePlatform extends Platform implements SceneBorderTouchingWatcher {

  private final Player PLAYER;

  public BluePlatform(Coordinate2D initialLocation, Size size, Player player){
    super("sprites/blueplatform.png", initialLocation, size);
    this.PLAYER = player;
    setMotion(2, 60d);
  }

  // This method will be called when the player collides with the blue platform
  // The player will be boosted.
  @Override
  public void activeerEffect() {
    PLAYER.setMotion(8, 180d);
  }

  @Override
  public void notifyBoundaryTouching(SceneBorder sceneBorder) {
    if(sceneBorder.equals(SceneBorder.RIGHT)){
      setMotion(2, 300d);
    } else if(sceneBorder.equals(SceneBorder.LEFT)){
      setMotion(2, 60d);
    }
  }
}
