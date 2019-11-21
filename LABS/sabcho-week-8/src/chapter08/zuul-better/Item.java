/*
Class Character - holds the information for one item in the game

@author  Sabrina Chowdhury
@version 2017.11.09
*/

import java.util.HashMap;
public class Item
{
    
	private String name;
	private String description;
	private int weight;
    
    /**
     * Create the item and initialise its name, description and weight
     */
	public Item(String name,String description, int weight)
	{
		this.name = name;
		this.description = description;
		this.weight=weight;

	}
    
    /*
    * @return the name of the item
    */
	public String getNameOfItem()
	{
		return name;
	}
    
    /*
    * @return the description of the item
    */
	public String getDescriptionOfItem()
	{
		return description;
	}
     
    /*
    * @return the weight of the item
    */
	public int getWeightOfItem()
	{
		return weight;
	}


}