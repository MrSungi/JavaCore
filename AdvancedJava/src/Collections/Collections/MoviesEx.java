package Collections.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoviesEx {

    public static void printMovieList(List<Movies> tempList){
        for(Movies m : tempList){
            System.out.println(m.name +"|"+ m.genre +"|"+ m.length);
        }
    }

    public static void main(String[] args) {
        Movies m1 = new Movies("Evil Dead", "Horror", 100);
        Movies m2 = new Movies("Avengers", "Action", 60);
        Movies m3 = new Movies("Phone Booth", "Thriller", 180);
        Movies m4 = new Movies("Terminator", "Action", 150);

        List<Movies> moviesList = new ArrayList<>();
        moviesList.add(m1);
        moviesList.add(m2);
        moviesList.add(m3);
        moviesList.add(m4);
        printMovieList(moviesList);
        System.out.println("=============================");

        //Collections.sort(moviesList);//error
        MovieComparatorName compareOnName = new MovieComparatorName();
        Collections.sort(moviesList,compareOnName);
        printMovieList(moviesList);
        System.out.println("=============================");

        Movies m5 = new Movies("He Man","Animation",120);
        moviesList.add(m5);
        printMovieList(moviesList);
        System.out.println("=============================");

        MoviesComparatorLen compareOnLen = new MoviesComparatorLen();
        Collections.sort(moviesList,compareOnLen);
        // Collections.sort(moviesList,compareOnLen.reversed());//for reverse
        printMovieList(moviesList);
        System.out.println("=============================");






    }
}
