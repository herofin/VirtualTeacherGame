package team14.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import team14.game.screens.AccountManagementScreen;
import team14.game.screens.GameOptionsScreen;
import team14.game.screens.HouseScreen;
import team14.game.screens.LoginScreen;
import team14.game.screens.MapScreen;
import team14.game.screens.SchoolScreen;

public class SchoolGame extends StateBasedGame
{
    public SchoolGame(String name)
    {
        super(name);

        this.addState(new LoginScreen());
        this.addState(new AccountManagementScreen());
        this.addState(new GameOptionsScreen());
        this.addState(new MapScreen());
        this.addState(new SchoolScreen());
        this.addState(new HouseScreen());
    }

    @Override
    public void initStatesList(GameContainer app) throws SlickException
    {
        this.getState(GameStates.Login).init(app, this);
        this.getState(GameStates.AccountManagement).init(app, this);
        this.getState(GameStates.GameOptions).init(app, this);
        this.getState(GameStates.Map).init(app, this);
        this.getState(GameStates.School).init(app, this);
        this.getState(GameStates.House).init(app, this);

        this.enterState(GameStates.Login);
    }

    public static void main(String[] args)
    {
        for (String s : args)
            System.out.println(s);
        
        String title = "Virtual Teacher Game";
        int width  = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        boolean fullscreen = Boolean.parseBoolean(args[2]);

        AppGameContainer app;

        try
        {
            app = new AppGameContainer(new SchoolGame(title));
            app.setDisplayMode(width, height, fullscreen);
            app.start();
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }
}
