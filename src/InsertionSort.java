import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Candice Lu
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    int cur = 1;
    while (cur < values.length) {
      swap(values, order, cur);
      cur++;
    }
  } // sort(T[], Comparator<? super T>)

  // +-----------------+----------------------------------------------
  // | Private Methods |
  // +-----------------+

  public <T> void swap(T[] values, Comparator<? super T> order, int upper){
    while (upper > 0 && order.compare(values[upper], values[upper - 1]) < 0) {
      T temp = values[upper];
      values[upper] = values[upper - 1];
      values[upper - 1] = temp;
      upper--; 
    }
  } // swap
} // class InsertionSort
