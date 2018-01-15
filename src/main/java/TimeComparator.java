import java.util.Comparator;

public class TimeComparator implements Comparator<Confirmation> {
    public int compare(Confirmation a, Confirmation b) {
        return a.compareByTime(b);
    }
}
