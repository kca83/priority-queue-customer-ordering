import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProcessConfirmationsTest {

    ProcessConfirmations processConfirmations;
    Integer[] inputTimeArray;
    Integer[] inputPriorityArray;
    Integer[] expectedOrder;

    @Before
    public void initialize() {
        processConfirmations = new ProcessConfirmations();
                            //  0,  1,  2,  3,  4,  5,   6,   7
        Integer[] timeArray = {30, 60, 64, 65, 400, 180, 190, 200};
                            // 90, 150, 210, 270, 330, 390, 450
        inputTimeArray = timeArray;

        Integer[] priorityArray = {11, 3, 4, 2, 1, 17, 5, 2};
        inputPriorityArray = priorityArray;

        Integer[] order = {0, 3, 1, 7, 2, 6, 5, 4};
        expectedOrder = order;
    }

    @Test
    public void orderOfConfirmationsTest() {
        Integer[] actual = processConfirmations.orderOfConfirmations(inputTimeArray, inputPriorityArray);
        for(Integer i : actual) {
            System.out.println(i);
        }
        Assert.assertArrayEquals(expectedOrder, actual);
    }
}
