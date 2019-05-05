# Algorithms: Java Implementations
The source code samples below are my implementations of various algorithms using Java.

# Introduction
An algorithm can be defined as a series of steps used to produce some result. They have a specific meaning in computer science and are defined by the following **3 characteristics**:
 * *They are finite: algorithms must terminate after a finite number of steps.*
 * *Algorithms operate on data.*
 * *They must produce at least one result as output.*

# Sorting Algorithms
*  ## Bubble Sort
```Java
/**
 * Sorts a single double array into ascending order.
 * @param array Double array to be sorted
 * @return Array in sorted ascending order
 */
private static Double[] BubbleSort(Double[] array){
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
    System.out.println("ARRAY SUCCESSFULLY SORTED: \n" + Arrays.toString(array));
    return array;
}
```
# Searching Algorithms
*  ## Binary Search
```Java
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
```
