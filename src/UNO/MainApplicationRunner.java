package UNO;

import Arcade.ArcadeMachine;
import Exceptions.NoCardRemainingException;
import Exceptions.OneCardAllowedException;

import java.io.IOException;


public class MainApplicationRunner {

    public static void main(String [ ] args) throws IOException, NoCardRemainingException, OneCardAllowedException {

        ArcadeMachine firstArcade  = new ArcadeMachine();
        firstArcade.run();

    }

    }
