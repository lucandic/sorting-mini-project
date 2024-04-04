import java.util.Arrays;
import java.util.Comparator;

public class LuCandiceSort implements Sorter{

/**
 * A quicker version of Insertion sort.
 * Basic idea:
 *   First check if array is completely reversed. In this case we simply flip it.
 *   Second we see if length of array is less than ten or there are over ten consecutive elements that are completely reversed. In this case we use Quicksort.
 *   For other cases we use insertion sort.
 *
 * @author Candice Lu
 */
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new LuCandiceSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  LuCandiceSort() {
  } // LuCandiceSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if (checkCompleteReverse(values, order)) {
        return;
    }
    if (checkTenReverse(values, order) || values.length <= 10) {
        quickSort(values, order, 0, values.length);
        return;
    }
    insertionSort(values, order);
  } // sort(T[], Comparator<? super T>

  // +-----------------+----------------------------------------------
  // | Private Methods |
  // +-----------------+

  public <T> void insertionSort(T[] values, Comparator<? super T> order) {
    int cur = 1;
    while (cur < values.length) {
      swap(values, order, cur);
      cur++;
    }
  } // sort(T[], Comparator<? super T>

  public <T> void quickSort(T[] values, Comparator<? super T> order, int lo, int hi) {
    if (hi - lo <= 1) {
        return;
      }
  
      int pivot = partition(values, order, lo, hi);
      quickSort(values, order, lo, pivot);
      quickSort(values, order, pivot, hi);
  } // sort(T[], Comparator<? super T>

  /*
   * Checks to see if there are more than ten consecutive terms that are completely reversed
   */
  static <T> boolean checkTenReverse(T[] vals, Comparator<? super T> comparator) {
    int counter = 0;
    for (int i = 0; i < (vals.length - 1); i++) {
        if (counter >= 10) {
            return true;
        }
        if (comparator.compare(vals[i], vals[i+1]) >= 0) {
            counter++;
        } else {
            counter = 0;
        }
    }
    return false;
  }  // checkTenReverse

  /*
   * Checks to see if given array is completely reversed, if yes reverse it and return true, else return false
   */
  static <T> boolean checkCompleteReverse(T[] vals, Comparator<? super T> comparator) {
    for (int i = 0; i < (vals.length - 1); i++) {
        if (comparator.compare(vals[i], vals[i+1]) <= 0) {
            return false;
        }
    }
    
    int swaps = vals.length;
    if (swaps % 2 != 0) {
        swaps--;
    }
    for (int i = 0; i < swaps / 2; i++) {
        T temp = vals[i];
        vals[i] = vals[vals.length - i - 1];
        vals[vals.length - i - 1] = temp;
    }
    return true;
  }  // checkCompleteReverse

  public <T> void swap(T[] values, Comparator<? super T> order, int upper){
    while (upper > 0 && order.compare(values[upper], values[upper - 1]) < 0) {
      T temp = values[upper];
      values[upper] = values[upper - 1];
      values[upper - 1] = temp;
      upper--; 
    }
  }

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
}
