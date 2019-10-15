package algorithms;

import org.junit.Test;
import static org.junit.Assert.*;

public class AlgorithmsTest {
    private Double[] unsortedArray1 = {4000d, -535.5, 54d, 32d, 3.14159, 3.14159};
    private Double[] expectedSort1 = {-535.5, 3.14159, 3.14159, 32d, 54d, 4000d};
    private Double[] unsortedArray2 = {0d, 0d, 0d, 0d, 0d};
    private Double[] expectedSort2 = {0d, 0d, 0d, 0d, 0d};
    private Double[] unsortedArray3 = {5.0, 256.0, -374.56, 76.9, -2_000.14};
    private Double[] expectedSort3 = {-2_000.14, -374.56, 5.0, 76.9, 256.0};
    private Double[] singleArray = {3.14};
    private Double[] expectedSingleArray = {3.14};
    private Double[] emptyArray = {};

    @Test
    public void bubbleSort(){
        assertArrayEquals(Algorithms.bubbleSort(unsortedArray1), expectedSort1);
    }

    @Test
    public void binarySearch(){
        assertEquals(Algorithms.binarySearch(32, unsortedArray1), 3, 0);
        assertNull(Algorithms.binarySearch(1_000, unsortedArray1));
    }

    @Test
    public void quickSort(){
        assertArrayEquals(Algorithms.quickSort(unsortedArray1, 0, 5), expectedSort1);
        assertArrayEquals(Algorithms.quickSort(unsortedArray2, 0, 4), expectedSort2);
        assertArrayEquals(Algorithms.quickSort(unsortedArray3, 0, 4), expectedSort3);
        assertArrayEquals(Algorithms.quickSort(singleArray, 0, 0), expectedSingleArray);
        assertNull(Algorithms.quickSort(emptyArray,0, 0));
    }

    @Test
    public void selectionSort(){
        assertArrayEquals(Algorithms.selectionSort(unsortedArray1), expectedSort1);
        assertArrayEquals(Algorithms.selectionSort(unsortedArray2), expectedSort2);
        assertArrayEquals(Algorithms.selectionSort(unsortedArray3), expectedSort3);
        assertArrayEquals(Algorithms.selectionSort(singleArray), expectedSingleArray);
        assertNull(Algorithms.selectionSort(emptyArray));
    }

    @Test
    public void insertionSort(){
        assertArrayEquals(Algorithms.insertionSort(unsortedArray1), expectedSort1);
        assertArrayEquals(Algorithms.insertionSort(unsortedArray2), expectedSort2);
        assertArrayEquals(Algorithms.insertionSort(unsortedArray3), expectedSort3);
        assertArrayEquals(Algorithms.insertionSort(singleArray), expectedSingleArray);
        assertNull(Algorithms.insertionSort(emptyArray));
    }
}
