package main

import "fmt"

func main() {
	var l int = 0
	var r int = 3
	//Our target is 2
	var target int = 2
	//Create integer array of size 4, initialized with values	
	var arr [4]int
	arr = [4]int{0, 1, 2, 3}
	//Print array
	fmt.Println(arr)
	for l <= r {
        var m int = l + (r - l) / 2
  
        // Check if target is present at mid
        if arr[m] == target {
            fmt.Println(m)
			return
		}
  
        // If target greater, ignore left half
        if arr[m] < target {
            l = m + 1
		} else { // If target is smaller, ignore right half
            r = m - 1
		}
    }
  
    // if we reach here, then element was not present
	fmt.Println("Target: ", target, ", was not found!")
}