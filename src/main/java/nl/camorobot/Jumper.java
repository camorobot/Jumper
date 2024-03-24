package nl.camorobot;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.camorobot.scenes.GameScene;
import nl.camorobot.scenes.TitleScene;

public class Jumper extends YaegerGame
{
    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Jumper");
        setSize(new Size(600, 800));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameScene(this));
    }
}
