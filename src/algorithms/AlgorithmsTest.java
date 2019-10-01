package algorithms;

import org.junit.Test;
import static org.junit.Assert.*;


public class AlgorithmsTest {
    private Double[] unsortedArray = {4000d, -535.5, 54d, 32d, 3.14159, 3.14159};
    private Double[] expectedSort = {-535.5, 3.14159, 3.14159, 32d, 54d, 4000d};
    private Double[] unsortedArray2 = {0d, 0d, 0d, 0d, 0d};
    private Double[] expectedSort2 = {0d, 0d, 0d, 0d, 0d};
    private Double[] emptyArray = {};

    @Test
    public void bubbleSort(){
        assertArrayEquals(Algorithms.bubbleSort(unsortedArray), expectedSort);
    }

    @Test
    public void binarySearch(){
        assertEquals(Algorithms.binarySearch(32, unsortedArray), 3, 0);
        assertNull(Algorithms.binarySearch(1_000, unsortedArray));
    }

    @Test
    public void quickSort(){
        assertArrayEquals(Algorithms.quickSort(unsortedArray, 0, 5), expectedSort);
        assertArrayEquals(Algorithms.quickSort(unsortedArray2, 0, 4), expectedSort2);
        assertNull(Algorithms.quickSort(emptyArray,0, 0));
    }

    @Test
    public void selectionSort(){
        assertArrayEquals(Algorithms.selectionSort(unsortedArray), expectedSort);
        assertArrayEquals(Algorithms.selectionSort(unsortedArray2), expectedSort2);
        assertNull(Algorithms.selectionSort(emptyArray));
    }
}
