package algorithms;

import org.junit.Test;
import static org.junit.Assert.*;

public class AlgorithmsTest {
    private Double[] unsortedArray = {4000d, -535.5, 54d, 32d, 3.14159, 3.14159};
    private Double[] expectedSort = {-535.5, 3.14159, 3.14159, 32d, 54d, 4000d};

    @Test
    public void BubbleSort(){
        assertArrayEquals(Algorithms.BubbleSort(unsortedArray), expectedSort);
    }

}
