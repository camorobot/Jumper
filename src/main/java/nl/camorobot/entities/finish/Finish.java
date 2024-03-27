package nl.camorobot.entities.finish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Finish extends SpriteEntity implements Collider {

  public Finish(Coordinate2D initialLocation, Size size) {
    super("sprites/finish.png", initialLocation, size);
  }
}
