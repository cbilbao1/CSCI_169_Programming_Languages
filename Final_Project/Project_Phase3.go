package main

import "fmt"

func main() {
	//Create an unsorted array of 10 integers
	myArr := make([]int, 10, 10)
	myArr[0] = 10
	myArr[1] = 21
	myArr[2] = 1
	myArr[3] = 4
	myArr[4] = 19
	myArr[5] = 29
	myArr[6] = 6
	myArr[7] = 9
	myArr[8] = 11
	myArr[9] = 2
	
	fmt.Println("Original Array:\n", myArr)
	quicksort(myArr)
	fmt.Println("\nSorted Array:\n", myArr)
}
 
func quicksort(array1 []int) []int {
	//Base case, return the single element
    if len(array1) < 2 {
        return array1
    }
     
    left, right := 0, len(array1) - 1
    pivot := left % len(array1)
     
    array1[pivot], array1[right] = array1[right], array1[pivot]
    
    //Traverse through array1
    for i, _ := range array1 {
        if array1[i] < array1[right] {
            array1[left], array1[i] = array1[i], array1[left]
            left += 1
        }
    }
     
    array1[left], array1[right] = array1[right], array1[left]
	
    //Recursion
    quicksort(array1[:left])
    quicksort(array1[left + 1:])
     
    return array1
}