package Library;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        int titleCmp = o1.compareTo(o2);
        if (titleCmp == 0) {
            return Integer.compare(o1.getYear(), o2.getYear());
        }
        return titleCmp;
    }
}
