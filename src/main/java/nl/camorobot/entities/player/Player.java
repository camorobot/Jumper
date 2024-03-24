package nl.camorobot.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided {
  public Player(String resource, Coordinate2D initialLocation) {
    super(resource, initialLocation);
    setGravityConstant(0.00);
    setFrictionConstant(0.04);

  }

  @Override
  public void onCollision(List<Collider> list) {

  }

  @Override
  public void notifyBoundaryTouching(SceneBorder sceneBorder) {

  }

  @Override
  public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
    if (pressedKeys.contains(KeyCode.LEFT)) {
      setMotion(3, 270d);
      setCurrentFrameIndex(0);
    } else if (pressedKeys.contains(KeyCode.RIGHT)) {
      setMotion(3, 90d);
      setCurrentFrameIndex(1);
    } else if (pressedKeys.contains(KeyCode.UP)) {
      setMotion(3, 180d);
    } else if (pressedKeys.contains(KeyCode.DOWN)) {
      setMotion(3, 0d);
    }
  }
}
