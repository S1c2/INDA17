

### Task 1 - Matching Behaviour

Take a look at the program [matching.go](code/matching.go). Explain what happens and why it happens if you make the following changes. Try first to reason about it, and then test your hypothesis by changing and running the program.

  * What happens if you remove the `go-command` from the `Seek` call in the `main` function?

    "name declared and not used"

  * What happens if you switch the declaration `wg := new(sync.WaitGroup`) to `var wg sync.WaitGroup` and the parameter `wg 
  *sync.WaitGroup` to `wg sync.WaitGroup`?

    "Eva sent a message to Bob.
     Cody sent a message to Dave.
     fatal error: all goroutines are asleep - deadlock!"

  * What happens if you remove the buffer on the channel match?

  "Anna sent a message to Cody.
   Bob sent a message to Dave.
   fatal error: all goroutines are asleep - deadlock!"

  * What happens if you remove the default-case from the case-statement in the `main` function?

  "Eva sent a message to Cody.
   Bob sent a message to Anna.
   No one received Daveâ€™s message."

   But if I remove a name, I get deadlock