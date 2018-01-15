import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class TimeComparatorTest {

    @Test
    public void timeComparatorTest() {
        Confirmation a = new Confirmation(0, 11, 30);
        Confirmation b = new Confirmation(1, 4, 400);
        Comparator<Confirmation> confirmationComparator = new TimeComparator();
        Assert.assertEquals(-1, confirmationComparator.compare(a, b));
    }
}
