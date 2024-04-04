import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Candice Lu
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    sort(values, order, 0, values.length);
  } // sort(T[], Comparator<? super T>)

  public <T> void sort(T[] values, Comparator<? super T> order, int lb, int ub) {
    if (ub - lb <= 1) {
      return;
    }

    int pivot = partition(values, order, lb, ub);
    sort(values, order, lb, pivot);
    sort(values, order, pivot, ub);
  } // sort(T[], Comparator<? super T>, int, int)

  // +-----------------+----------------------------------------------
  // | Private Methods |
  // +-----------------+
  
  public static <T> int partition(T[] arr, Comparator<? super T> order, int lb, int ub) {
    int pivot = (lb + ub)/ 2;
    T temp = arr[lb];
    arr[lb] = arr[pivot];
    arr[pivot] = temp;
    T p = arr[lb];

    int small = lb + 1;
    int large = ub;

    while (large - small > 0) {
      if (order.compare(arr[small], p) <= 0) {
        small++;
      } else {
        temp = arr[large - 1];
        arr[large - 1] = arr[small];
        arr[small] = temp;
        large--;
      }
    }
    temp = arr[small - 1];
    arr[small - 1] = arr[lb];
    arr[lb] = temp;

    return small - 1;
  } // partition
} // class Quicksort
