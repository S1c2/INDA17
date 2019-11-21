package main

import (
	"fmt"
	"math"
	
)

func Sqrt(x float64) float64 {
	z := 1.0
	for {
		previous := z
		z = z - (z*z-x)/(2*z)
		//returns the next representable value after z towards last
		next := math.Nextafter(z, previous)
		fmt.Println(z)
		if next == previous {
			break
		}
	}
	return z
}

func main() {
	fmt.Println(Sqrt(2))
	
}
