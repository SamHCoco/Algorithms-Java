package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class Algorithms {

    public static void main(String[] args) {
        Double[] t = {4000d, -535.5, 54d, 32d, 3.14159, 3.14159};
        quickSort(t, 0, 5);
    }

    /**
     * Sorts a single double array into ascending order.
     * @param array Double array to be sorted
     * @return Array in sorted ascending order
     */
    public static Double[] bubbleSort(Double[] array){
        int arraySize = array.length;
        if(arraySize < 2){
            System.out.println("ERROR: list must contain at least 2 number or more");
            return null;
        }
        boolean isSorted = false;
        int swapsCounter = 0;
        Double higher;
        Double lower;
        int i = 0;
        while(!isSorted){
            while(i < arraySize - 1){
                if(array[i] < array[i + 1]){
                    i++;
                } else if(array[i] > array[i + 1]){
                    higher = array[i];
                    lower = array[i + 1];
                    array[i] = lower;
                    array[i + 1] = higher;
                    swapsCounter++;
                    i++;
                } else if(array[i].equals(array[i + 1])){
                    i++;
                }
            }
            if(swapsCounter == 0){
                isSorted = true;
            } else {
                swapsCounter = 0;
                i = 0;
            }
        }
        System.out.println("BUBBLE SORT: \n" + Arrays.toString(array));
        return array;
    }

    /**
     * Validates array by checking the array isn't empty.
     * @param array the array to be validated
     * @param algorithmName the name of the algorithm calling the method for a validation
     * @return True if array is not empty, false otherwise
     */
    public static boolean isInputValid(Double[] array, String algorithmName){
        if(array.length == 0){
            System.out.println(algorithmName + " ERROR : input array is empty");
            return false;
        }
        return true;
    }

    /**
     * Searches for a specified element in an array using Binary Search algorithm
     * @param searchValue the value to be found
     * @param array the array that is being searched for the specified value
     * @return The index of the value if found, null if not
     */
    public static Integer binarySearch(double searchValue, Double[] array){
        if(!isInputValid(array, "BINARY SEARCH")){
            return null;
        }
        Arrays.sort(array);
        System.out.println("BINARY SEARCH - SORT RESULT: " + Arrays.toString(array));
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        int middleIndex = -1;
        boolean found = false;
        while(!found){
            middleIndex = (int) Math.floor((firstIndex + lastIndex) / 2);
            if(middleIndex == firstIndex){
                System.out.println("BINARY SEARCH: " + searchValue + " not found");
                return null;
            } else if(array[middleIndex] == searchValue){
                System.out.println("BINARY SEARCH: " + searchValue + " found at index " + middleIndex);
                found  = true;
            } else if(searchValue > array[middleIndex]){
                firstIndex = middleIndex;
            } else if(searchValue < array[middleIndex]){
                lastIndex = middleIndex;
            }
        }
        return middleIndex;
    }

    /**
     * Recursively sorts an array of numbers in ascending order using the
     * Quick Sort algorithm.
     * @param array the array to be sorted
     * @param startIndex the beginning index of the array
     * @param endIndex the end index of the array
     * @return Array sorted in ascending order
     */
    public static Double[] quickSort(Double[] array, int startIndex, int endIndex){
        int pivotIndex;
        if(!isInputValid(array, "QUICK SORT")){
            return null;
        }
        if(startIndex < endIndex){
            pivotIndex = partition(array, startIndex, endIndex);
            quickSort(array, startIndex, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, endIndex);
        }
        System.out.println("QUICK SORT COMPLETE: " + Arrays.toString(array));
        return array;
    }

    /**
     * Partitions an array such that all values less than the pivot are to the left of
     * pivot and all values greater to the right. FOR USE AS PART OF QUICK SORT METHOD.
     * @param array the array to be partitioned
     * @param firstIndex the beginning index of the array
     * @param lastIndex the end index of the array
     * @return The array partitioned along its pivot
     */
    private static int partition(Double[] array, int firstIndex, int lastIndex){
        int partitionIndex = firstIndex;
        int pivotIndex = lastIndex;
        double pivotValue = array[pivotIndex];
        int pivotValueCounter = 0;
        double partitionValue;

        for(int i = firstIndex; i < array.length; i++){
            if(array[i] > pivotValue){
                continue;
            }
            if(array[i] < pivotValue){
                partitionValue = array[partitionIndex];
                array[partitionIndex] = array[i];
                array[i] = partitionValue;
                partitionIndex++;
            } else if(array[i] == pivotValue){
                pivotValueCounter++;
            }
        }
        array[pivotIndex] = array[partitionIndex];
        array[partitionIndex] = pivotValue;
        pivotIndex = partitionIndex;
        ArrayList<Double> partitionedArray = new ArrayList<>();
        if(pivotValueCounter > 0){
            for(int i = 0; i < array.length; i++){
                if(array[i] != pivotValue){
                   partitionedArray.add(array[i]);
                }
                if(i == pivotIndex){
                    for(int j = 0; j < pivotValueCounter; j++){
                        partitionedArray.add(pivotValue);
                    }
                }
            }
        }
        for(int k = 0; k < partitionedArray.size(); k++){
            array[k] = partitionedArray.get(k);
        }
        return pivotIndex;
    }

    /**
     * Sorts an array into ascending order using the 'Selection Sort' algorithm.
     * @param array The array to be sorted
     * @return Array sorted in ascending order
     */
    public static Double[] selectionSort(Double[] array){
        double minimum;
        int minimumIndex = 0;
        for(int i = 0; i < array.length - 1; i++){
            minimum = array[i];
            for(int j = i; j < array.length; j++){
                if(array[j] <= minimum){
                    minimum = array[j];
                    minimumIndex = j;
                }
            }
            array[minimumIndex] = array[i];
            array[i] = minimum;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}
