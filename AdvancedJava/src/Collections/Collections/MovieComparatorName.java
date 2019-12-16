package Collections.Collections;

import java.util.Comparator;

public class MovieComparatorName implements Comparator<Movies> {

    @Override
    public int compare(Movies o1, Movies o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
