package nl.camorobot.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.camorobot.entities.player.Player;

public class BluePlatform extends Platform implements SceneBorderTouchingWatcher {

  Player player;

  public BluePlatform(Coordinate2D initialLocation, Player player) {
    super("sprites/blueplatform.png", initialLocation);
    this.player = player;
    setMotion(2, 270d);
  }

  @Override
  public void activeerEffect() {

  }

  @Override
  public void notifyBoundaryTouching(SceneBorder sceneBorder) {
    System.out.println(sceneBorder);
    if(sceneBorder.equals(SceneBorder.RIGHT)){
      setMotion(2, 270d);
    } else if(sceneBorder.equals(SceneBorder.LEFT)){
      setMotion(2, 90d);
    }
  }
}
