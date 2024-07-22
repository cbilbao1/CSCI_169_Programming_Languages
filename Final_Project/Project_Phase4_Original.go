package main

import (
	"fmt"
	//"math/rand"
	"time"
	"os"
	"flag"
	"encoding/csv"
)

func main() {
	csvFilename := flag.String("csv", "problems.csv", "a csv file in the format of 'question, answer'")
	timeLimit := flag.Int("limit", 30, "the time limit for the quiz in second(s)")	// 30 second timer
	flag.Parse()

	//file, err := os.Open(*csvFilename)
	file, err := os.Open("problems.csv")
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

	correct := 0
	ProblemLoop:
	for i, p := range problems {
		fmt.Printf("Problem #%d: %s = \n", i + 1, p.question)
		answerCh := make(chan string)
		go func() {
			var answer string
			fmt.Scanf("%s\n", &answer)
			answerCh <- answer
		}()

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

	fmt.Printf("You scored %d out of %d,\n", correct, len(problems))

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
			//answer: strings.TrimSpace(line[1]),	// In case there was a space in format
			answer: line[1],
			//a: line[1],
		}
	}
	return ret
}