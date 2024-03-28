package nl.camorobot.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.camorobot.Jumper;
import nl.camorobot.buttons.QuitGameButton;
import nl.camorobot.buttons.StartButton;

public class TitleScene extends StaticScene {

  private final Jumper JUMPER;

  public TitleScene(Jumper Jumper) {
    this.JUMPER = Jumper;
  }

  @Override
  public void setupScene() {
    setBackgroundImage("backgrounds/TitleScene.jpg");
  }

  @Override
  public void setupEntities() {
    TextEntity welkomText = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/4), "Welkom bij Jumper!");
    welkomText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
    welkomText.setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    welkomText.setFill(Color.PURPLE);
    addEntity(welkomText);

    StartButton startButton = new StartButton(new Coordinate2D(getWidth()/2, getHeight()/2),JUMPER);
    addEntity(startButton);

    QuitGameButton quitGameButton = new QuitGameButton(new Coordinate2D(getWidth()/2, getHeight()/1.5), JUMPER);
    addEntity(quitGameButton);
  }
}
