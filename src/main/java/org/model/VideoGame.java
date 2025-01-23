package org.model;

public class VideoGame {
    private final String title;
    private final Console console;
    private final ESRB esrbRating;

    public VideoGame(String title, Console console, ESRB esrbRating) {
        this.title = title;
        this.console = console;
        this.esrbRating = esrbRating;
    }

    public String getTitle () {
        return this.title;
    }

    public Console getConsole() {
        return this.console;
    }

    public ESRB getEsrbRating() {
        return this.esrbRating;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Console: " + console.toString() + "\n" +
                "Rating: " + esrbRating.toString() + "\n";
    }
}
