package org.queue;

import org.model.Console;
import org.model.ESRB;
import org.model.VideoGame;

import static org.model.Console.*;
import static org.model.ESRB.*;

public class QueueImpl {

    private MyQueue<VideoGame> gameQueue;

    public QueueImpl(int capacity) {
        this.gameQueue = new MyQueue<>(capacity);
    }

    private void printAdd(boolean added, String title) {
        String message = (added)
                ? title + " Was Added To Queue"
                : title + " Was Not Added To Queue";
        System.out.println(message);
    }

    private void printRemove(VideoGame game) {
        if (game == null) {
            System.out.println("No Game Was Removed");
            return;
        }
        System.out.println("Removed The Following Game:\n");
        System.out.println(game);
    }

    private void nextQueue(){
        System.out.println("Next In Queue");
        VideoGame game = gameQueue.peek();
        String message = game != null ? game.toString() : "Queue is Empty";
        System.out.println(message);
    }

    public void addToQueue(String title, Console console, ESRB rating) {
        boolean add = gameQueue.enqueue(new VideoGame(title, console, rating));
        printAdd(add, title);
    }

    public void removeFromQueue() {
        VideoGame removedGame = gameQueue.dequeue();
        printRemove(removedGame);
    }

    public void printQueue() {
        gameQueue.printAll();
    }

    public static void main(String[] args) {
        QueueImpl queueImp = new QueueImpl(3);
        queueImp.addToQueue("Resident Evil 4", NINTENDO, M);
        queueImp.addToQueue("Gears of War", XBOX, M);
        queueImp.addToQueue("Mario Kart", NINTENDO, E);
        queueImp.addToQueue("The Sims", PC, T);
        queueImp.printQueue();
        System.out.println();
        queueImp.removeFromQueue();
        System.out.println("\nPrint All\n");
        queueImp.printQueue();
        queueImp.removeFromQueue();
        System.out.println("\nPrint All -- 2\n");
        queueImp.printQueue();
        queueImp.removeFromQueue();
        System.out.println("\nPrint All -- 3\n");
        queueImp.printQueue();
    }
}
