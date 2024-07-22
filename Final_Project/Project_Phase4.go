package main

import (
	"fmt"
	//"math/rand"
	"time"
	"os"
	"flag"
	"encoding/csv"
	"strconv"
	"log"
	"strings"
)

func main() {
	//Variables needing initialization
	difficulty := 30
	flagCount := 0
	//csvFilename := flag.String("csv", "problems.csv", "a csv file in the format of 'question, answer'")
	csvFilename := flag.String("csv", "arithmetic.csv", "a csv file in the format of 'question, answer'")
	timeLimit := flag.Int("limit" + strconv.Itoa(flagCount), difficulty, "the time limit for the quiz in second(s)")
	difChoice := 0	// No difficulty by default
	f3, err3 := os.Create("null.csv")	// We will create a new highscore file
	defer f3.Close()	// Make sure to close the file
	//High score file check
	if (!doesExist("highscore.csv")) {	// If there is no highscore file
		f3, err3 = os.Create("highscore.csv")	// We will create a new highscore file
		//f3, err3 := os.Create("highscore.csv")	// We will create a new highscore file
		defer f3.Close()	// Make sure to close the file
		//Error Check
		if err3 != nil {
			log.Fatalln("The highscore file doesn't exist.", err3)
			return
		}
	}
	//Set the newly created file to f reference
	//----f, err2 := os.Open("highscore.csv")
	//----if err2 != nil {
		//----exit(fmt.Sprintf("Failed to open the CSV file: highscore.csv"))
		//fmt.Printf("Failed to open the CSV file: %s", *csvFilename)
		//os.Exit(1)	// Application failed
	//----}

	//The main menu
	choice := 0
	//Game full restart label
	RestartLoop:
	flagCount++
	fmt.Println("Hello, and welcome to the MAIN MENU of my Quiz Game!")
	InvalidMenuLoop:
	fmt.Println("\nMAIN MENU")
	fmt.Println("Please pick an option by typing a (number) corresponding to what you want to do:")
	fmt.Println("(1) Start")
	fmt.Println("(2) Highscore")
	fmt.Println("(3) Exit")
	_, err := fmt.Scanf("%d", &choice)
	//fmt.Println("Before")
	//fmt.Println(choice)

	//Play, Choose mode
	if (choice == 1) {
		goto ModePrompt
		//goto QuizLoop
	} else if (choice == 2) {	// Check highscores		
		fmt.Println()
		//Set the newly created file to f reference
		//-f1, err2 := os.Open("highscore.csv")
		f7, err3 := os.Open("highscore.csv")
		//-if err2 != nil {
		if err3 != nil {
			exit(fmt.Sprintf("Failed to open the CSV file: highscore.csv"))
		//fmt.Printf("Failed to open the CSV file: %s", *csvFilename)
		//os.Exit(1)	// Application failed
		}
		
		r := csv.NewReader(f7)
		//-r := csv.NewReader(f1)
		r.Comma = ','
		//r.UseCRLF = true
		//r.Comment = '#'
		records, err5 := r.ReadAll()
		if err5 != nil {
		   log.Fatal(err)
		}
		fmt.Println(printSlice(records))
		//fmt.Println(records)

		fmt.Println("Returning to MAIN MENU..\n\n")
		goto RestartLoop
	} else if (choice == 3)	{ // Terminate
		fmt.Println("Thank you for playing!.")
		fmt.Println("\nProgram terminated.\n")
		return
	} else	{ // Invalid input
		fmt.Println("\nInvalid input!\n")
		goto InvalidMenuLoop
	}
	//fmt.Println("After")

	//Mode label
	ModePrompt:
	//Pause
	//fmt.Println("(Press enter to continue)")
	temp2 := 0
	//fmt.Println("Before")
	fmt.Scanf("%d", &temp2)
	fmt.Println("\nWhat gamemode do you want to play?")
	fmt.Println("Please pick an option by typing a (number) corresponding to what you want to do:")
	fmt.Println("(1) Arithmetic")
	fmt.Println("(2) True/false")
	//fmt.Println("(3) Multiple choice")
	//_, err6 := fmt.Scanf("%d", &choice)
	fmt.Scanf("%d", &choice)

	//Quiz label
	QuizLoop:
	correct := 0
	//Could add a difficulty component, default is 30 seconds
	//difficulty = 30
	//difChoice := 0	// No difficulty by default
	fmt.Println("\nWhat difficulty do you want?")
	fmt.Println("Please pick an option by typing a (number) corresponding to what you want to do:")
	fmt.Println("(1) Easy")
	fmt.Println("(2) Hard")
	fmt.Println("(3) Speed Demon")
	_, err1 := fmt.Scanf("%d", &difChoice)
	if err1 == nil {
       fmt.Println("Error?")
    }
	fmt.Scanf("%d", &difChoice)

	//difficulty logic
	if (difChoice == 1) {
		difficulty = 31
	} else if (difChoice == 2)	{ // Hard mode
		difficulty = 12
	} else if (difChoice == 3)	{ // Less than 1 second mode
		difficulty = 10
	} else { // Invalid input
		fmt.Println("\nInvalid input!\n")
		goto QuizLoop
	}
	
	fmt.Println("\nYou have", difficulty, "seconds to complete this 12 question quiz. Good luck!")
	//Pause
	//fmt.Println("(Type in any number to continue)")
	temp := 0
	//fmt.Println("Before")
	fmt.Scanf("%d", &temp)
	//fmt.Println("After")
	//csvFilename := flag.String("csv", "problems.csv", "a csv file in the format of 'question, answer'")
	//timeLimit := flag.Int("limit", 30, "the time limit for the quiz in second(s)")	// 30 second timer
	timeLimit = flag.Int("limit" + strconv.Itoa(flagCount), difficulty, "the time limit for the quiz in second(s)")
	//fmt.Println("Commence")
	flagCount++
	flag.Parse()

	//file, err := os.Open(*csvFilename)
	//file, err := os.Open("problems.csv")
	file, err := os.Open("arithmetic.csv")
	//Arithmetic
	if (choice == 1) {
		file, err = os.Open("arithmetic.csv")
		if err != nil {
			exit(fmt.Sprintf("Failed to open the CSV file: %s", *csvFilename))
			//fmt.Printf("Failed to open the CSV file: %s", *csvFilename)
			//os.Exit(1)	// Application failed
		}
	} else if (choice == 2) {	// True/False		
		file, err = os.Open("truefalse.csv")
		if err != nil {
			exit(fmt.Sprintf("Failed to open the CSV file: %s", *csvFilename))
			//fmt.Printf("Failed to open the CSV file: %s", *csvFilename)
			//os.Exit(1)	// Application failed
		}
	} /*else if (choice == 3)	{ // Multiple choice
		file, err = os.Open("multiplechoice.csv") // Not done -----------
		if err != nil {
			exit(fmt.Sprintf("Failed to open the CSV file: %s", *csvFilename))
			//fmt.Printf("Failed to open the CSV file: %s", *csvFilename)
			//os.Exit(1)	// Application failed
		}
	}*/

	//file, err := os.Open("arithmetic.csv")
	if err != nil {
		exit(fmt.Sprintf("Failed to open the CSV file: %s", *csvFilename))
		//fmt.Printf("Failed to open the CSV file: %s", *csvFilename)
		//os.Exit(1)	// Application failed
	}
	//_ = file
	r := csv.NewReader(file)
	lines, err := r.ReadAll()
	if err != nil {
		exit("Failed to parse the CSV file.")
	}
	
	problems := parseLines(lines)
	//fmt.Println(lines)

	timer := time.NewTimer(time.Duration(*timeLimit) * time.Second)
	//<-timer.C	// Wait for the channel

	//correct := 0
	ProblemLoop:
	for i, p := range problems {
		if (choice == 1) {
			fmt.Printf("Problem #%d: %s = \n", i + 1, p.question)
		} else if (choice == 2) {
			fmt.Printf("Problem #%d (t/f?): %s = \n", i + 1, p.question)
		}
		answerCh := make(chan string)
		go func() {
			var answer string
			fmt.Scanf("%s\n", &answer)
			answerCh <- answer
		}()

		//Waits for certain events in the goroutine
		select {
			case <- timer.C:
				fmt.Println()
				//fmt.Printf("\nYou scored %d out of %d,\n", correct, len(problems))
				break ProblemLoop
				//return
			case answer := <-answerCh:
				if answer == p.answer {
					correct++
				}
			//default:
				//fmt.Printf("Problem #%d: %s = \n", i + 1, p.question)
				//var answer string
				//fmt.Scanf("%s\n", &answer)
				//if answer == p.answer {
					//fmt.Println("Correct answer!")
					//correct++
				//}
		}
		//fmt.Printf("Problem #%d: %s = \n", i + 1, p.question)
		//var answer string
		//fmt.Scanf("%s\n", &answer)
		//if answer == p.answer
		//{
		//	fmt.Println("Correct answer!")
		//	correct++
		//}
	}

	//Update high score
	//Store date of current score
	dt := time.Now()
	//sep, err7 := strconv.Unquote(`"` + "	" + `"`)
	/*if err7 != nil {
		panic(err)
	}*/
	//Temp variable
	scoreData := [][]string{
					{"High Score" /*+ sep*/, "Date"},
					{strconv.Itoa(correct) /*+ sep*/, dt.String()},
				}
	//Set the newly created file to f reference
	//f3, err3 = os.Open("highscore.csv")
	f3, err3 = os.Create("highscore.csv")
	//-f4, err4 := os.Open("highscore.csv")
	if err3 != nil {
	//-if err4 != nil {
		exit(fmt.Sprintf("Failed to open the CSV file: highscore.csv"))
		//fmt.Printf("Failed to open the CSV file: %s", *csvFilename)
		//os.Exit(1)	// Application failed
	}
	w := csv.NewWriter(f3)
	//-w := csv.NewWriter(f4)
    defer w.Flush()
	for _, data := range scoreData {
	//Convert integer correct to a string and write to file
		if err := w.Write(data); err != nil {
			log.Fatalln("Could not write to 'highscore.csv'", err)
		}
	}

	fmt.Printf("You scored %d out of %d,\n", correct, len(problems))

	//Pause
	fmt.Println("(Press enter to continue)")
	//fmt.Println("Before")
	fmt.Scanf("%d", &temp)

	resChoice := 0	// Defaulted to no
	//Restart prompt label
	RestartPromptLoop:
	fmt.Printf("\nWould you like to play again?\n")
	fmt.Println("Please pick an option by typing a (number) corresponding to what you want to do:")
	//fmt.Println("Please pick an option by typing a (character) corresponding to what you want to do:")
	fmt.Println("(1) Yes")
	fmt.Println("(2) No")
	//fmt.Println("(Y) Yes")
	//fmt.Println("(N) No")
	//fmt.Println(resChoice)
	fmt.Scanf("%d", &resChoice)
	//fmt.Scanf("%q", &resChoice)

	//difficulty logic
	if (resChoice == 1) {	// Play again
		goto QuizLoop
	} else if (resChoice == 2)	{
		//------fmt.Printf("\nWould you like to return to the MAIN MENU?\n")
		//------fmt.Println("Please pick an option by typing a (number) corresponding to what you want to do:")
		//fmt.Println("Please pick an option by typing a (character) corresponding to what you want to do:")
		//------fmt.Println("(1) Yes")
		//------fmt.Println("(2) No")
		//fmt.Println("(Y) Yes")
		//fmt.Println("(N) No")
		//------fmt.Printf("PAUSE Before")
		//------fmt.Scanf("%d", &resChoice)
		//fmt.Printf("PAUSE After")
		//fmt.Println(resChoice)
		//fmt.Scanf("%q", &resChoice)
		if (resChoice == 1) {	// MAIN MENU
			goto RestartLoop
		} else if (resChoice == 2) { // Terminate program
			fmt.Println("Thank you for playing!.")
			fmt.Println("\nProgram terminated.\n")
			return
		} else {
			fmt.Println("\nInvalid input!\n")
			goto RestartPromptLoop
		}
	} else { // Invalid input
		fmt.Println("\nInvalid input!\n")
		goto RestartPromptLoop
	}

	//slice := generateSlice(20)
	//fmt.Println("\n--- Unsorted --- \n\n", slice)
	//quicksort(slice)
	//fmt.Println("\n--- Sorted ---\n\n", slice, "\n")
}

func exit(msg string) {
	// Application failed, exit function
	fmt.Println(msg)
	os.Exit(1)
}

//Struct for the problems read in the file
type problem struct {
	question string
	answer string

}

func parseLines(lines [][]string) []problem {
	ret := make([]problem, len(lines))
	for i, line := range lines {
		ret[i] = problem {
			question: line[0],
			answer: strings.TrimSpace(line[1]),	// In case there was a space in format
			//answer: line[1],
			//a: line[1],
		}
	}
	return ret
}

type printSlice [][]string
func (contents printSlice) String() string {
    var s string
    for _, i := range contents {
        s += fmt.Sprintf("%q\n", i)
    }
    return s
}

//Check if highscore file before creating text file
func doesExist(filename string) bool {
    info, err := os.Stat(filename)
    if os.IsNotExist(err) {
        return false
    }
    return !info.IsDir()
}

//True/False file answer key
/*Abraham Lincoln had no middle name,t
Germany drinks the most beer in the world per person,f
Ronald Reagan was a waiter during high school,f
The kids' bathroom on The Brady Bunch didn't have a toilet,t
Nemo is a puffer fish,f
There was no World Series in 1994,t
John Lennon's middle name was Edward,f
Broccoli was once banned from the White House,t
Japan has square watermelons,t
Pinocchio was the first animated full-color Walt Disney feature film,f
Porcupines can float,t
There are 100 dimples on a golf ball,f*/