
/**
 * Write a description of class NameGenerator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NameGenerator
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class NameGenerator
     */
    public NameGenerator()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String generateStarWarsName()
    {
        String name = "Sabrina";
        String surname = "Chowdhury";
        String momMaidenName = "Testing";
        String cityWhereBorn = "Stockholm";
        
        String firstThreeSurname = surname.substring(0, 3);
        String firstTwoName = name.substring(0,2);
        
        String firstTwoMomMaidenName = momMaidenName.substring(0,2);
        String firstThreeCityWhereBorn = cityWhereBorn.substring(0,3);
        
        String starWarsFirstName = firstThreeSurname + firstTwoName;
        String starWarsLastName = firstTwoMomMaidenName + firstThreeCityWhereBorn;
        
        String starWarsName = starWarsFirstName + " " + starWarsLastName;
        
        return starWarsName;
    }
}
