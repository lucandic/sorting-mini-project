import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.Arrays;
import org.junit.Test;

public class LuCandiceSortTester extends SortTester{

/**
 * Tests of LuCandiceSort.
 */

// +--------------+------------------------------------------------
// | Constructors |
// +--------------+
  
    public LuCandiceSortTester() {
      super();
      this.sorter = LuCandiceSort.SORTER;
    } // LuCandiceSortTester()

    /*
    @Test
    public void exampleTest() {
        String[] original = { "aab", "aaa", "aae", "aad", "aac" };
        String[] expected = { "aaa", "aab", "aac", "aad", "aae" };
        sorter.sort(original, (x, y) -> x.compareTo(y));
        assertArrayEquals(original, expected);
    }
    */
    
    
  
} // class LuCandiceSortTester

