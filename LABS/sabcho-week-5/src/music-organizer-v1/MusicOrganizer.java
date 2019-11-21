import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
	// An ArrayList for storing the file names of music files.
	private ArrayList<String> files;

	/**
 	* Create a MusicOrganizer
 	*/
	public MusicOrganizer()
	{
    	files = new ArrayList<>();
	}
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

	/**
 	* Add a file to the collection.
 	* @param filename The file to be added.
 	*/
	public void addFile(String filename)
	{
    	files.add(filename);
	}

	/**
 	* Return the number of files in the collection.
 	* @return The number of files in the collection.
 	*/
	public int getNumberOfFiles()
	{
    	return files.size();
	}

	/**
 	* List a file from the collection.
 	* @param index The index of the file to be listed.
 	*/
 
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

