package algorithms;

import java.util.Arrays;

public class Algorithms {

    public static void main(String[] args) {
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
     * @return true if array is not empty, false otherwise
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
     * @return the index of the value if found, null if not
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
}
