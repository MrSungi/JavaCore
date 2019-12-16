package Collections.Collections;

public class Movies {

    String name, genre;
    int length;

    public Movies(String name, String genre, int length) {
        this.name = name;
        this.genre = genre;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }
}
