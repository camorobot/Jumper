package nl.camorobot.platforms;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Platform extends DynamicSpriteEntity implements Collider {

  private boolean isScoreEnabled;

  public Platform(String resource, Coordinate2D initialLocation, Size size) {
    super(resource, initialLocation, size);
    setupPlatform();
  }

  public Platform(String resource, Coordinate2D initialLocation, Size size, int rows, int columns) {
    super(resource, initialLocation, size, rows, columns);
    setupPlatform();
  }

  public abstract void activeerEffect();

  private void setupPlatform(){
    isScoreEnabled = true;
    setAnchorPoint(AnchorPoint.CENTER_CENTER);
    setMotion(1,0d);
  }

  public boolean getIsScoreEnable(){
    return isScoreEnabled;
  }

  public void setIsScoreEnabled(boolean newScore){
    this.isScoreEnabled = newScore;
  }

}
