package main

import "fmt"

// I want this program to print "Hello world!", but it doesn't work.
func main() {

    ch := make(chan string)

      // Make the writing operation be performed in
     // another goroutine.
     go func() {
     	ch <- "Hello world!"
     }()

	text := <-ch // read from a channel
	fmt.Println(text)
}


//we get a deadlock error because we have two routines that wait for each other and so cannot proceed
//To fix this we send the string in a separate go function
//http://guzalexander.com/2013/12/06/golang-channels-tutorial.html