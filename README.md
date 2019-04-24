# Algorithms: Java Implementations
Implementation of various classes of algorithms (e.g. search or sort) in Java.
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
