package nl.camorobot.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.camorobot.Jumper;
import nl.camorobot.platforms.BluePlatform;
import nl.camorobot.platforms.BrownPlatform;
import nl.camorobot.platforms.GreenPlatform;
import nl.camorobot.platforms.Platform;
import nl.camorobot.text.ScoreText;

import java.util.List;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided {

  private Jumper jumper;
  private ScoreText scoreText;

  public Player(String resource, Coordinate2D initialLocation, Size size, Integer rows, Integer columns, Jumper jumper, ScoreText scoreText) {
    super(resource, initialLocation, size, rows, columns);
    this.scoreText = scoreText;
    this.jumper = jumper;
    setFrictionConstant(0.04);
  }

  @Override
  public void onCollision(List<Collider> list) {

    updatePlayerScore();
    scoreText.setScoreText(jumper.getPlayerScore());
    System.out.println("Player score: " + jumper.getPlayerScore());

    if (list.get(0) instanceof GreenPlatform) {
      ((GreenPlatform) list.get(0)).activeerEffect();
      ((GreenPlatform) list.get(0)).setIscScoreEnabled(false);
    } else if (list.get(0) instanceof BrownPlatform) {
      ((BrownPlatform) list.get(0)).activeerEffect();
      ((BrownPlatform) list.get(0)).setIscScoreEnabled(false);
    }
  }

  @Override
  public void notifyBoundaryTouching(SceneBorder border) {
    setSpeed(0);

    switch (border) {
      case TOP:
        jumper.setActiveScene(2);
        setAnchorLocationY(1);
        break;
      case BOTTOM:
        setAnchorLocationY(getSceneHeight() - getHeight() - 1);
        break;
      case LEFT:
        setAnchorLocationX(getSceneWidth());
        break;
      case RIGHT:
        setAnchorLocationX(1);
      default:
        break;
    }
  }

  @Override
  public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
    if (pressedKeys.contains(KeyCode.LEFT)) {
      setCurrentFrameIndex(0);
      setMotion(3, 270d);
    } else if (pressedKeys.contains(KeyCode.RIGHT)) {
      setCurrentFrameIndex(1);
      setMotion(3, 90d);
      // Hiermee word je heen en weer geschoten
//      setDirection(90d);
    } else if (pressedKeys.contains(KeyCode.UP)) {
      setMotion(3, 180d);
    } else if (pressedKeys.contains(KeyCode.DOWN)) {
      setMotion(3, 0d);
    }
  }

  public void updatePlayerScore() {
    int score = jumper.getPlayerScore() + 1;
    jumper.setPlayerScore(score);
    scoreText.setScoreText(jumper.getPlayerScore());
  }
}
