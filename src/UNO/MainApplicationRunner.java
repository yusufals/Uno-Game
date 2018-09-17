package UNO;

import Arcade.ArcadeMachine;
import Exceptions.InvalidCardException;
import Exceptions.MaxPlayerReachedException;
import Exceptions.NoCardRemainingException;
import Exceptions.OneCardAllowedException;

import java.io.IOException;


public class MainApplicationRunner {

    public static void main(String [ ] args) throws IOException, NoCardRemainingException, OneCardAllowedException, InvalidCardException, MaxPlayerReachedException {

        ArcadeMachine firstArcade  = new ArcadeMachine();
        firstArcade.run();

    }

    }
