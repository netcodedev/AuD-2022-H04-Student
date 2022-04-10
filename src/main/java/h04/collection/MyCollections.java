package h04.collection;

import h04.function.ListToIntFunction;

import java.util.Comparator;
import java.util.List;


/**
 * A collection that allows to order (sort) the unordered sequence. The sorting algorithm is based on merge-sort, switching to
 * selection-sort when the sequence is small to increase performance.
 *
 * @param <T> the type of the elements in the list that can be sorted
 *
 * @author Nhan Huynh
 */
public class MyCollections<T> {

    /**
     * Determines the toggle length when the sorting algorithm should be toggled (usage of another sorting algorithm).
     */
    private final ListToIntFunction<T> function;

    /**
     * The comparator used to compare the elements of the list.
     */
    private final Comparator<? super T> cmp;

    /**
     * Constructs and initializes a {@code MyCollections}.
     *
     * @param function the function determining the toggle length
     * @param cmp      the comparator used to compare the elements of the list
     */
    public MyCollections(ListToIntFunction<T> function, Comparator<? super T> cmp) {
        this.function = function;
        this.cmp = cmp;
    }

    /**
     * Sorts the list in place.
     *
     * @param list the list to sort
     */
    public void sort(List<T> list) {
        throw new RuntimeException("H2.1 - not implemented"); // TODO: H2.1 - remove if implemented
    }

    /**
     * Transfers all elements from a list to a list item sequence.
     *
     * @param list the list to transfer from
     *
     * @return the list item sequence containing the element of the list
     */
    private ListItem<T> listToListItem(List<T> list) {
        throw new RuntimeException("H2.1 - not implemented"); // TODO: H2.1 - remove if implemented
    }

    /**
     * Transfers all elements from a ListItem sequence to a list.
     *
     * @param head the list item sequence
     * @param list the list to transfer to
     */
    private void listItemToList(ListItem<T> head, List<T> list) {
        throw new RuntimeException("H2.1 - not implemented"); // TODO: H2.1 - remove if implemented
    }

    /**
     * Sorts the list in place using the merge sort algorithm. If the (sub-)sequence is smaller than the specified threshold, the
     * selection sort algorithm  (in place) is used.
     *
     * @param head      the list to sort
     * @param threshold the threshold determining the toggle length
     *
     * @return the sorted list
     */
    private ListItem<T> adaptiveMergeSortInPlace(ListItem<T> head, int threshold) {
        throw new RuntimeException("H2.2 - not implemented"); // TODO: H2.2 - remove if implemented
    }

    /**
     * Splits the list into two subsequences.
     *
     * <p>The decomposition of the list into two subsequences is related to the searched optimal size and the number of
     * elements of runs, which is close to the optimal size.
     *
     * @param head        the list to split
     * @param optimalSize the optimal size after the split
     *
     * @return the second part of the list
     */
    private ListItem<T> split(ListItem<T> head, int optimalSize) {
        throw new RuntimeException("H2.2 - not implemented"); // TODO: H2.2 - remove if implemented
    }

    /**
     * Merges the two given sub-sequences into one sorted sequence.
     *
     * @param left  the left sub-sequence
     * @param right the right sub-sequence
     *
     * @return the merged sorted sequence
     */
    private ListItem<T> merge(ListItem<T> left, ListItem<T> right) {
        throw new RuntimeException("H2.2 - not implemented"); // TODO: H2.2 - remove if implemented
    }

    /**
     * Sorts the list in place using the selection sort algorithm.
     *
     * @param head the list to sort
     *
     * @return the sorted list
     */
    private ListItem<T> selectionSortInPlace(ListItem<T> head) {
        throw new RuntimeException("H2.3 - not implemented"); // TODO: H2.3 - remove if implemented
    }

    /**
     * Swaps two elements in the list.
     *
     * @param head the list to swap
     * @param i    the index of the first element
     * @param j    the index of the second element
     *
     * @return the list with the swapped elements
     */
    private ListItem<T> swap(ListItem<T> head, int i, int j) {
        throw new RuntimeException("H2.3 - not implemented"); // TODO: H2.3 - remove if implemented
    }

    /**
     * Returns the index of the last maximum element in the list.
     *
     * @param head the list to search
     * @param low  the lower bound of the sublist
     * @param high the upper bound of the sublist
     *
     * @return the index of the last maximum element in the list
     */
    private int getMaximumIndex(ListItem<T> head, int low, int high) {
        throw new RuntimeException("H2.3 - not implemented"); // TODO: H2.3 - remove if implemented
    }
}
