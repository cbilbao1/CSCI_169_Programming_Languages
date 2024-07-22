package main

import "fmt"

func main() {
//Create an array of arrays, an 8x8 2D array
	boardArr := [][]uint8{
    {0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
}

    //Run the solver, passing in 2D array starting at recursive call in column 0
    eightQueensSolver(boardArr, 0)


    //Print the solution
    for i := range boardArr {
		boardArr[i] = make([]uint8, 8)
	}
	fmt.Println(a)


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

#Function that traverses the 2D array
def eightQueensSolver(boardArr, col1):
    #Base case, all queens have been placed
    if col1 >= 8:
        return True

    #Recursive case, look at current column col
    for i in range(8):

        #Check if we can place queen in some row i
        if check(boardArr, i, col1) == True:

            #Place a queen in slot row i column col
            boardArr[i][col1] = 1

            #Recursive call, go to next column
            if eightQueensSolver(boardArr, col1 + 1) == True:
                return True

            #Don't place queen
            boardArr[i][col1] = 0

    #Queen can't be placed in this column in any of the rows
    return False

#Function that checks if we can place queen in slot
def check(boardArr, row2, col2):
    #Check the current row going left
    for i in range(col2):
        if boardArr[row2][i] == 1:
            return False

    #Check diagonally going up and to the left
    for i, j in zip(range(row2, -1, -1), 
                    range(col2, -1, -1)):
        if boardArr[i][j] == 1:
            return False

    #Check diagonally going up and to the left
    for i, j in zip(range(row2, 8, 1), 
                    range(col2, -1, -1)):
        if boardArr[i][j] == 1:
            return False

    return True

def main():
    #Create an array of arrays, an 8x8 2D array
    boardArr =  [[0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0]]

    #Run the solver, passing in 2D array starting at recursive call in column 0
    eightQueensSolver(boardArr, 0)

    #Print the solution
    for i in range(8):
        for j in range(8):
            print (boardArr[i][j], end = " ")
        print()
    return
  
#Run the main function
main()




//______________________________________________________

package main

import "fmt"

func main() {
//Create an array of arrays, an 8x8 2D array
	boardArr := [][]int{
    {0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
}

    //Run the solver, passing in 2D array starting at recursive call in column 0
    eightQueensSolver(boardArr, 0)


    //Print the solution
	for i := 0; i < 8; i++ {
		for j := 0; j < 8; j++ {
			fmt.Printf("%d ", boardArr[i][j])
		}
		fmt.Printf("\n")
	}
	fmt.Printf("\n")
//     for i := range boardArr {
// 		boardArr[i] = make([]uint8, 8)
// 	}
// 	for i := range boardArr {
// 		for j := range boardArr {
// 		    fmt.Printf(boardArr[i][j])
// 	    }
// 	}
}

//Function that traverses the 2D array
func eightQueensSolver(boardArr [][]int, col1 int) bool {
    //Base case, all queens have been placed
    if col1 >= 8 {
        return true
    }

    //Recursive case, look at current column col
    for i:= 0; i < 8; i++ {

        //Check if we can place queen in some row i
        if check(boardArr, i, col1) == true {

            //Place a queen in slot row i column col
            boardArr[i][col1] = 1

            //Recursive call, go to next column
            if eightQueensSolver(boardArr, col1 + 1) == true {
                return true
            }

            //Don't place queen
            boardArr[i][col1] = 0
        }
    }

    //Queen can't be placed in this column in any of the rows
    return false
}

//Function that checks if we can place queen in slot
func check(boardArr [][]int, row2 int, col2 int) bool {
    //Check the current row going left
    for i := 0; i < col2; i++ {
    //for i := range(col2) {
        if boardArr[row2][i] == 1 {
            return false
        }
    }

    //Check diagonally going up and to the left
    for i := row2; i > -1; i-- {
    //for i, j := zip(range(row2, -1, -1), 
                    //range(col2, -1, -1)) {
        for j := col2; j > -1; j-- {
            if boardArr[i][j] == 1 {
                return false
            }
        }
    }

    //Check diagonally going up and to the left
    for i := row2; i < 8; i++ {
    //for i, j := zip(range(row2, 8, 1), 
                    //range(col2, -1, -1)) {
        for j := col2; j > -1; j-- {
            if boardArr[i][j] == 1 {
                return false
            }
        }
    }

    return true
}

//A copycat of the Python Zip() function
type intTuple struct {
    a, b int
}

func zip(a, b []int) ([]intTuple, error) {

    if len(a) != len(b) {
        return nil, fmt.Errorf("zip: arguments must be of same length")
    }

    r := make([]intTuple, len(a), len(a))

    for i, e := range a {
        r[i] = intTuple{e, b[i]}
    }

    return r, nil
}

//_________________________________________________________________

package main

import "fmt"

func main() {
//Create an array of arrays, an 8x8 2D array
	boardArr := [][]int{
    {0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
}

    //Run the solver, passing in 2D array starting at recursive call in column 0
    eightQueensSolver(&boardArr, 0)


    //Print the solution
	for i := 0; i < 8; i++ {
		for j := 0; j < 8; j++ {
			fmt.Printf("%d ", boardArr[i][j])
		}
		fmt.Printf("\n")
	}
	fmt.Printf("\n")
//     for i := range boardArr {
// 		boardArr[i] = make([]uint8, 8)
// 	}
// 	for i := range boardArr {
// 		for j := range boardArr {
// 		    fmt.Printf(boardArr[i][j])
// 	    }
// 	}
}

//Function that traverses the 2D array
func eightQueensSolver(boardArr *[][]int, col1 int) bool {
    //Base case, all queens have been placed
    if col1 >= 8 {
        return true
    }

    //Recursive case, look at current column col
    for i:= 0; i < 8; i++ {

        //Check if we can place queen in some row i
        if check((*boardArr), i, col1) == true {

            //Place a queen in slot row i column col
            (*boardArr)[i][col1] = 1

            //Recursive call, go to next column
            if eightQueensSolver(boardArr, col1 + 1) == true {
                return true
            }

            //Don't place queen
            (*boardArr)[i][col1] = 0
        }
    }

    //Queen can't be placed in this column in any of the rows
    return false
}

//Function that checks if we can place queen in slot
func check(boardArr [][]int, row2 int, col2 int) bool {
    //Check the current row going left
    for i := 0; i < col2; i++ {
    //for i := range(col2) {
        if boardArr[row2][i] == 1 {
            return false
        }
    }

    //Check diagonally going up and to the left
    for i := row2; i > -1; i-- {
    //for i, j := zip(range(row2, -1, -1), 
                    //range(col2, -1, -1)) {
        for j := col2; j > -1; j-- {
            if boardArr[i][j] == 1 {
                return false
            }
        }
    }

    //Check diagonally going up and to the left
    for i := row2; i < 8; i++ {
    //for i, j := zip(range(row2, 8, 1), 
                    //range(col2, -1, -1)) {
        for j := col2; j > -1; j-- {
            if boardArr[i][j] == 1 {
                return false
            }
        }
    }

    return true
}

//A copycat of the Python Zip() function
type intTuple struct {
    a, b int
}

func zip(a, b []int) ([]intTuple, error) {

    if len(a) != len(b) {
        return nil, fmt.Errorf("zip: arguments must be of same length")
    }

    r := make([]intTuple, len(a), len(a))

    for i, e := range a {
        r[i] = intTuple{e, b[i]}
    }

    return r, nil
}