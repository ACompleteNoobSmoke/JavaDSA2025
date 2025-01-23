package org.stack;

import org.model.VideoGame;
import static org.model.Console.*;
import static org.model.ESRB.*;

public class StackImplementation {

    public static void main(String[] args) {
        VideoGame game1 = new VideoGame("Resident Evil 4", NINTENDO, M);
        VideoGame game2 = new VideoGame("Gears of War", XBOX, M);
        VideoGame game3 = new VideoGame("Mario Kart", NINTENDO, E);
        VideoGame game4 = new VideoGame("The Sims", PC, T);

        MyStack<VideoGame> gameStack = new MyStack<>(3);
        gameStack.push(game1);
        gameStack.push(game2);
        gameStack.push(game3);
        gameStack.push(game4);
        gameStack.printAll();
        gameStack.pop();
        System.out.println("------");
        gameStack.printAll();
    }
}
