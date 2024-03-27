package nl.camorobot.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.camorobot.entities.player.Player;

public class BluePlatform extends Platform implements SceneBorderTouchingWatcher {

  Player player;

  public BluePlatform(Coordinate2D initialLocation, Size size, Player player){
    super("sprites/blueplatform.png", initialLocation, size);
    this.player = player;
    setMotion(2, 60d);
  }

  @Override
  public void activeerEffect() {
    player.setMotion(8, 180d);
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
