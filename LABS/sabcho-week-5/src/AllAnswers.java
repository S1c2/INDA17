    // Answer to 4.14
	public void checkIndex(int index)
	// void method : does not return anything
	//we pass an int value to this method
	{
    	if (index>=0 && index<=(files.size()-1))
    	//if index is between 0 and the size of the files - 1
    	//minus one because an array starts with index 0, and thus if we have 
    	//our end index at 9, this means there are 10 elements in the array
    	{
        	System.out.println("");
    	}
    	else
    	{
        	System.out.println("The valid range is: 0-" + (files.size()-1));
        	//will return an ERROR when the index tested does not have
        	//anything in it
        	//i.e. it will also return and ERROR when the collection
        	//is empty
    	}
   	 
	}
    //Answer to 4.15
	public boolean validIndex(int index)
	//returns a boolean result
	{
    	if (index>=0 && index<=(files.size()-1))
    	{
        	return true;
    	}
    	else
    	{
        	return false;
        	//will return false when the index tested does not have  
        	//anything in it
        	//i.e. it will also return false when the collection
        	//is empty
    	}
	}

 //Answer to 4.16
	public void listFile(int index){
    	if(validIndex(index)==true) {
    	    // call the method validIndex and send index to it
    	    //test if it returns true
        	String filename = files.get(index);
        	System.out.println(filename);
    	}
	}

	/**
 	* Remove a file from the collection.
 	* @param index The index of the file to be removed.
 	*/
	public void removeFile(int index)
	{    
    	if(validIndex(index)==true) {
        	files.remove(index);
        	
    	}
	}

//Answer to Exercise 4.24
    
    public void listAllFiles()
    {
        int position=0;
        for(String filename : files) {
            position = position + 1;
            System.out.println(position + ": " + filename);
        }
    }


//Answer to Exercise 4.26
public void listMatching(String searchString)
    {
        boolean fileTest = false;
        for(String filename : files) {
            if(filename.contains(searchString)) {
                // A match.
                fileTest = true;
            }
        }
        
        if (fileTest==false)
        {
            System.out.println("No match");
        }
        
    }
//Answer to 4.27
public void playCertainArtist(String artist)
    { 
       
        for(String filename : files) {
            if(filename.contains(artist)) {
                // A match.
                
                player.playSample(filename);
            }
            
        }
        System.out.println("h");
        
       
    }



    //Answer to 4.30
    public void multiplesOfFive()
    { 
        int mod;
        int x = 10;
        while(x<=95)
        {
            mod = x%5;
            if (mod == 0)
            {
                System.out.println(x);
            }
            x++;
        }
    } 
    
    //Answer to 4.31
    public void printSum()
    {
        int x = 1;
        int sum = 0;
        while (x <= 10)
        {
            sum = sum + x;
            System.out.println(sum);
            x++;
        }
        System.out.println(sum);
        
    }
    
    //Answer to 4.32
    public int sum(int a, int b)
    {
      int sum = 0;
      while (a <= b)
      {
          sum = sum + a;
          System.out.println(a);
          a++;
          System.out.println(sum);
          
      }
      return sum;
    }
    
    //Answer to 4.33
    public boolean isPrime(int n)
    {
        int x = 2;
        while (x<=(n-1))
        {
            if(n%x == 0)
            {
                return false;
            }
            
            x++;
            
        }
        
        return true;
    }

//Answer for 4.43
     public void playRandom()
    {
        Random random = new Random();
        playTrack(random.nextInt(tracks.size()));
    }

//Answer to 4.44

If we wanted to listen to multiple tracks in a random order without favorites we would probably want to shuffle the tracks as in 4.45 where we first create a shuffled playlist and then just play that whole thing. 

If we wanted to listen to the favorites first we would utilise "play count" field such that each track, when played gets a higher value (by one), but we can´t really  play the songs in the order of how popular they are, so we could instead take all songs that have maybe over 10 listens and create a favorite list from them, then shuffle this list and play it, then shuffle the rest of the songs and play them afterwards.

//Answer to 4.45
    public void shufflePlaylist()
    {
        //first take the size of tracks
        //make a new array with index 0 to the size of tracks - 1
        //shuffle this array
        //then make a for loop starting from index 0 to index size of tracks -1
        //take this index and send it to playTrack
        
        int s = tracks.size();
        List<Integer>randomNewList = new ArrayList<Integer>();
        
        for (int i = 0; i <=((tracks.size()) - 1); i++)
        {
            randomNewList.add(i);
        }
        
        Collections.shuffle(randomNewList);
        
        for (int i = 0; i<=((randomNewList.size())-1);i++)
        {
            int position = randomNewList.get(i);
            playTrack(position);
            
        }
        
    }
