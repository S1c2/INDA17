package main

import "fmt"

func fibonacci() func() int {
	c := 0  
    a := 0  
    b := 1  
    return func() int {  
        c = a  
        a = a + b  
        b = c  
        return c 
	}
}


func main() {
	f := fibonacci()
	for i := 0; i < 10; i++ {
		fmt.Println(f())
	}
}