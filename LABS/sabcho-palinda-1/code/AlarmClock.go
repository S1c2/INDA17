package main

import (
	"fmt"
	"time"
	
)

func Remind(text string, delay time.Duration) {
	specificTimeChannel := time.Tick(delay) //time when reminder is needed is sent to specificTimeChannel
	for{ //will iterate forever
	//for is golangs "while", so while select is in use
		//select lets you wait on multiple channel operations
		//basically we select which channels to use based on the case
		//when this channel arrives we print the following
		select{
			//send tickChannel to channel now
			//the data flows in the direction of the arrow
			//so we print it when it arrives
		case current := <-specificTimeChannel: //case, send tickChannel to channel now?
		    //so basically when the current time corresponds with the time given to specificTimeChannel, we print
			fmt.Printf(text, current.Format("15:04PM"))
			//https://gobyexample.com/time-formatting-parsing
			//tutorial on time-formatting
		}
	}
	
}



func main() {
	
	fmt.Printf("Test Now : The time is %s", time.Now().Format("15:04PM \n"))
	go Remind("Klockan är %s: Dags att äta\n", 3*time.Millisecond)
	go Remind("Klockan är %s: Dags att arbeta\n", 8*time.Millisecond)
	go Remind("Klockan är %s: Dags att sova\n", 24*time.Millisecond)
	select{}
	//prevents the main program from exciting early
	

}





