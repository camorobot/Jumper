package nl.camorobot.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.camorobot.Jumper;

public class TryAgainButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

  private final Jumper JUMPER;

  public TryAgainButton(Coordinate2D initialLocation, Jumper jumper) {
    super(initialLocation, "Try Again");
    this.JUMPER = jumper;
    setAnchorPoint(AnchorPoint.CENTER_CENTER);
    setFill(Color.PURPLE);
    setFont(Font.font("Roboto", FontWeight.BOLD, 30));
  }

  @Override
  public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
    JUMPER.setActiveScene(1);
  }

  @Override
  public void onMouseEntered() {
    setFill(Color.VIOLET);
    setCursor(Cursor.HAND);
  }

  @Override
  public void onMouseExited() {
    setFill(Color.PURPLE);
    setCursor(Cursor.DEFAULT);
  }
}
