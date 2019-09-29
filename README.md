# Algorithms: Java Implementations
The source code samples below are my implementations of various algorithms using Java.

# Introduction
An algorithm can be defined as a series of steps used to produce some result. They have a specific meaning in computer science and are defined by the following **3 characteristics**:
 * *They are finite: algorithms must terminate after a finite number of steps.*
 * *Algorithms operate on data.*
 * *They must produce at least one result as output.*

# Sorting Algorithms
*  ## Bubble Sort
The *Bubble Sort* algorithm compares the value of *array[i]* and its neighbour *array[i+1]*. If the value of *array[i]* is greater than the value at *array[i+1]* then the two values swap positions. If the values are the same or *array[i]* is less than *array[i+1]* then no swap is made. This procedure is repeated using loops until a complete loop is executed with no swaps made, indicating the array has been successfully sorted in ascending order.
#### Time Complexity:
 - WORST CASE -  **О(n^2)**

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
*  ## Quick Sort
Quick sort belongs to the divide-and-conquer family of sorting algorithm. It uses recursion to sort the items of an array that possess a “less than”, "greater than" or "equal to" relationship, such as an array of numbers.
The algorithm works as follows:
1. ) A pivot is selected, typically the last index in the array.
2. ) All the elements in the array whose value is <span style="color:red;">greater than the pivot</span> are placed to the <span style="color:red;">right of pivot</span> and all elements <span style="color:blue;">less than the pivot</span> are placed to the <span style="color:blue;">left of pivot</span>. The array is now partitioned into two segments, with the pivot being the partition point of these two segments.
3. ) Steps 1 and 2 are repeated recursively on the two segments, for *n-1* and *n+1* where *n* is the index of the current pivot, until the entire array is sorted.
```Java
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
```
### Partition Method
```Java
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
```
#### Time Complexity:
 - WORST CASE -  **О(n^2)**

# Searching Algorithms
*  ## Binary Search
Binary Search operates on a sorted array to find a desired search value by continually dividing the array interval it is searching for the value in in half. It begins with the midpoint of the entire array (or approximate midpoint if the array contains an odd number of elements) and determines whether the element at this position is greater, less than or equal to the desired search value. If it is greater than the desired value, the algorithm moves to the midpoint of the array interval to the left of the current midpoint where the array's values are all smaller since this must logically be where the desired value is to be found if it is indeed contained in the array. This same process is applied if the midpoint is found to be less than the desired value, except the new search interval becomes the array interval to the right of the current midpoint where the array's values are all greater than that midpoint. This entire process is repeated until either the value is found or the array cannot further be sub-divided into a smaller search interval in which case the desired element is not contained in the array.
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
#### Time Complexity:
 - WORST CASE - **O(log n)** 
