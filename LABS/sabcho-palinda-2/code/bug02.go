package main

import "fmt"



// This program should go to 11, but sometimes it only prints 1 to 10.
func main() {
	//it´s a buffer because we assign how many values the channel can take in
	queue := make(chan int,11)

	for i := 1; i <= 11; i++ {
		queue <- i
		}
close(queue)

for n := range queue { // reads from channel until it's closed
		fmt.Println(n)

	}
}
// Print prints all numbers sent on the channel.
// The function returns when the channel is closed.


