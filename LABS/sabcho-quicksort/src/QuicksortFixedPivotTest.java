/**
 * Created by Sabrina on 2/28/18.
 */
public class QuicksortFixedPivotTest extends IntSorterTest {
    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortFixedPivot();
    }
}
