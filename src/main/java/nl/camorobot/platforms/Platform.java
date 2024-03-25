package nl.camorobot.platforms;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Platform extends DynamicSpriteEntity implements Collider {

  private boolean isScoreEnabled;

  protected Platform(String resource, Coordinate2D initialLocation) {
    super(resource, initialLocation);
    setAnchorPoint(AnchorPoint.CENTER_CENTER);
    setMotion(1,0d);
  }

  public Platform(String resource, Coordinate2D initialLocation, Size size) {
    super(resource, initialLocation, size);
    setAnchorPoint(AnchorPoint.CENTER_CENTER);
    setMotion(1,0d);
  }

  public Platform(String resource, Coordinate2D initialLocation, Size size, int rows, int colums) {
    super(resource, initialLocation, size, rows, colums);
    setAnchorPoint(AnchorPoint.CENTER_CENTER);
    setMotion(1,0d);
  }

  public abstract void activeerEffect();

  public boolean getIsScoreEnable(){
    return isScoreEnabled;
  }

  public void setIscScoreEnabled(boolean newScore){
    this.isScoreEnabled = newScore;
  }

}
