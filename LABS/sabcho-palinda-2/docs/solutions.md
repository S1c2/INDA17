

<!-- Put your answer here -->

### Task 2 - Many Senders; Many Receivers

The program [many2many.go](code/many2many.go) contains four producers that together send 32 strings over a channel.  At the other end there are two consumers that receive the strings.  Describe what happens, and explain why it happens, if you make the following changes in the program.  Try first to reason your way through, and then test your hypothesis by changing and running the program.

* What happens if you switch the order of the statements `wgp.Wait()` and `close(ch)` in the end of the `main` function?

Panic, because we try sending something to a closed channel
* What happens if you move the `close(ch)` from the `main` function and instead close the channel in the end of the function `Produce`?

The channel is closed in the beginning and nothing can be produced
* What happens if you remove the statement `close(ch)` completely?

Then the channel is never closed for consumers
* What happens if you increase the number of consumers from 2 to 4?

2 additional go routines will run
* Can you be sure that all strings are printed before the program stops?

Yes

Finally, modify the code by adding a new WaitGroup that waits for all consumers to finish.
