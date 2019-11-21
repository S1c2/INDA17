/*
* Class Character - holds the information for one character in the game
*
* @author  Sabrina Chowdhury
* @version 2017.11.09
*/


import java.util.HashMap;
public class Character
{

	private String name;
	private String question;
	private String answer;
	
    /**
     * Create the character and initialise its name, question and answer.
     */
	public Character(String name,String question, String answer)
	{
		this.name = name;
		this.question = question;
		this.answer = answer;

	}
    
    /*
    * @return the name of the character
    */
	public String getNameOfCharacter()
	{
		return name;
	}
    
    /*
    * @return the question that the character will ask the user
    */
	public String getQuestionFromCharacter()
	{
		return question;
	}
    
    /*
    * @return the right answer to the characters question
    */
	public String getAnswerFromCharacter()
	{
		return answer;
	}


}