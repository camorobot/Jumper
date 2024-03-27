package nl.camorobot.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.camorobot.Jumper;
import nl.camorobot.entities.finish.Finish;
import nl.camorobot.platforms.BombPlatform;
import nl.camorobot.entities.rocket.Rocket;
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
  private boolean gameStarted = false;

  public Player(String resource, Coordinate2D location, Size size, Integer rows, Integer columns, Jumper jumper, ScoreText scoreText) {
    super(resource, location, size, rows, columns);
    this.scoreText = scoreText;
    this.jumper = jumper;
    setFrictionConstant(0.04);
  }



  @Override
  public void onCollision(List<Collider> list) {

    if(list.get(0) instanceof Rocket){
      ((Rocket) list.get(0)).boost();
    }

    if (list.get(0) instanceof Finish) {
      jumper.setDeadMessage("Finished");
      jumper.setActiveScene(2);
    }

    if(list.get(0) instanceof Platform){
      gameStarted = true;
      if (((Platform) list.get(0)).getIsScoreEnable()) {
        updatePlayerScore();
        scoreText.setScoreText(jumper.getPlayerScore());
        ((Platform) list.get(0)).setIsScoreEnabled(false);
      }
    }


    if (list.get(0) instanceof GreenPlatform) {
      ((GreenPlatform) list.get(0)).activeerEffect();
    } else if (list.get(0) instanceof BrownPlatform) {
      ((BrownPlatform) list.get(0)).activeerEffect();
    } else if (list.get(0) instanceof BluePlatform) {
      ((BluePlatform) list.get(0)).activeerEffect();
    } else if(list.get(0) instanceof BombPlatform){
      ((BombPlatform) list.get(0)).activeerEffect();
    }
  }

  @Override
  public void notifyBoundaryTouching(SceneBorder border) {
    setSpeed(0);

    switch (border) {
      case TOP:
        setAnchorLocationY(1);
        break;
      case BOTTOM:
        if (gameStarted) {
          jumper.setDeadMessage("Fell");
          jumper.setActiveScene(2);
        }
        setAnchorLocationY(getSceneHeight() - getHeight() - 1);
        break;
      case LEFT:
        setAnchorLocationX(getSceneWidth() - 45);
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
      maximizeMotionInDirection(Direction.LEFT, 2);
    } else if (pressedKeys.contains(KeyCode.RIGHT)) {
      setCurrentFrameIndex(1);
      maximizeMotionInDirection(Direction.RIGHT, 2);
    } else if (pressedKeys.contains(KeyCode.UP)) {
      setMotion(3, 180d);
    } else if (pressedKeys.contains(KeyCode.DOWN)) {
      setMotion(3, 0d);
    } else if (pressedKeys.contains(KeyCode.Q)) {
      jumper.setActiveScene(2);
    }
  }

  public void updatePlayerScore() {
    int score = jumper.getPlayerScore() + 1;
    jumper.setPlayerScore(score);
    scoreText.setScoreText(jumper.getPlayerScore());
  }
}
