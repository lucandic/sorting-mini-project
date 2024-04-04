import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;

/**
 * Tests of Quicksort.
 */
public class QuicksortTester extends SortTester {

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public QuicksortTester() {
    super();
    this.sorter = Quicksort.SORTER;
  } // QuicksortTester()

} // class QuicksortTester
