import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
/**
 * Tests of Sorter objects.
 *
 * @author Your Name
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void emptyArrayTest() {
    Integer[] original = {};
    Integer[] expected = {};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // emptyArrayTest

  @Test
  public void orderedIntegerTest() {
    Integer[] original = { 0, 1, 2, 3, 4, 5 };
    Integer[] expected = { 0, 1, 2, 3, 4, 5 };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedIntegerTest

  @Test
  public void reversedIntegerTest() {
    Integer[] original = { 5, 4, 3, 2, 1, 0 };
    Integer[] expected = { 0, 1, 2, 3, 4, 5 };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // reversedIntegerTest

  @Test
  public void randomIntegerTest() {
    Integer[] original = { 34, 1, 23, 90, 105, 17, 2, 0, 88, 103, 54 };
    Integer[] expected = { 0, 1, 2, 17, 23, 34, 54, 88, 90, 103, 105 };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // randomIntegerTest

  @Test
  public void similarStringTest() {
    String[] original = { "aab", "aaa", "aae", "aad", "aac" };
    String[] expected = { "aaa", "aab", "aac", "aad", "aae" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedIntegerTest

  @Test
  public void duplicateStringTest() {
    String[] original = { "hello", "hella" , "hello", "hella"};
    String[] expected = { "hella", "hella", "hello", "hello" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedIntegerTest

  @Test
  public void allDuplicateStringTest() {
    String[] original = { "hello", "hello" , "hello", "hello"};
    String[] expected = { "hello", "hello", "hello", "hello" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedIntegerTest

} // class SortTester
