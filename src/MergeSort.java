import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import java.lang.String;

/**
 * Sort using merge sort.
 *
 * @author Candice Lu
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    sort(values, order, 0, values.length);
  } // sort(T[], Comparator<? super T>)

  public <T> void sort(T[] values, Comparator<? super T> order, int lo, int hi) {
    if (hi - lo <= 1){
      return;
    }

    int mid = (hi + lo) / 2;
    sort(values, order, lo, mid);
    sort(values, order, mid, hi);
    merge(values, lo, mid, hi, order);
  } // sort(T[], Comparator<? super T>, int, int)

  // +-----------------+----------------------------------------------
  // | Private Methods |
  // +-----------------+

  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    //T[] temp1 = Arrays.copyOfRange(vals, lo, mid);
    //T[] temp2 = Arrays.copyOfRange(vals, mid, hi);

    T[] temp = Arrays.copyOfRange(vals, lo, hi);

    int counter1 = 0;
    int counter2 = mid - lo;

    for (int i = lo; i < hi; i++) {
      if (counter1 >= mid - lo && counter2 >= hi - mid) {
        break;
      }
      if (counter1 >= mid - lo) {
        vals[i] = temp[counter2];
        counter2++;
      } else if (counter2 >= hi - lo) {
        vals[i] = temp[counter1];
        counter1++;
      } else {
        if (comparator.compare(temp[counter1], temp[counter2]) <= 0) {
          vals[i] = temp[counter1];
          counter1++;
        } else {
          vals[i] = temp[counter2];
          counter2++;
        }
      }
    }
  } // merge
} // class MergeSort
