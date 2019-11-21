
import java.util.Random;
/**
 * Created by Sabrina on 2/28/18.
 */
public class QuicksortRandomPivot extends QuicksortFixedPivot{
    private static Random rand = new Random();

    /**
     * Generates a random pivot from the array
     */
    protected int getPivot(int[] v, int first, int last){

        return v[rand.nextInt(last-first+1)+first];
    }
}
