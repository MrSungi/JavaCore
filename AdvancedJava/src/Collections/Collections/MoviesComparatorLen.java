package Collections.Collections;

import java.util.Comparator;

public class MoviesComparatorLen implements Comparator<Movies> {
    @Override
    public int compare(Movies o1, Movies o2) {
        if(o1.length > o2.getLength()){
            return 1;
        }
        else if(o1.length < o2.getLength()){
            return -1;
        }
        else{
            return  0;
        }

    }
}
