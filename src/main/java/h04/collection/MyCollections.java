package h04.collection;

import h04.function.ListToIntFunction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A collection that allows to order (sort) the unordered sequence. The sorting algorithm is based on merge-sort, switching to
 * selection-sort when the sequence is small to increase performance.
 *
 * @param <T> the type of the elements in the list that can be sorted
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
        ListItem<T> head = listToListItem(list);
        head = adaptiveMergeSortInPlace(head, function.apply(list));
        listItemToList(head, list);
    }

    /**
     * Transfers all elements from a list to a list item sequence.
     *
     * @param list the list to transfer from
     * @return the list item sequence containing the element of the list
     */
    private ListItem<T> listToListItem(List<T> list) {
        ListItem<T> head = new ListItem<>();
        var iterator = head;
        for(T t : list){
            iterator = iterator.next = new ListItem<>();
            iterator.key = t;
        }
        head = head.next;
        return head;
    }

    /**
     * Transfers all elements from a ListItem sequence to a list.
     *
     * @param head the list item sequence
     * @param list the list to transfer to
     */
    private void listItemToList(ListItem<T> head, List<T> list) {
        int index = 0;
        var iterator = head;
        while(iterator != null){
            if(index >= list.size()){
                list.add(index,iterator.key);
            } else {
                list.set(index, iterator.key);
            }
            iterator = iterator.next;
            index++;
        }
    }

    /**
     * Sorts the list in place using the merge sort algorithm. If the (sub-)sequence is smaller than the specified threshold, the
     * selection sort algorithm  (in place) is used.
     *
     * @param head      the list to sort
     * @param threshold the threshold determining the toggle length
     * @return the sorted list
     */
    private ListItem<T> adaptiveMergeSortInPlace(ListItem<T> head, int threshold) {
        ArrayList<T> list = new ArrayList<>();
        listItemToList(head, list);
        if(list.size() > threshold){
            var second = split(head, threshold);
            return merge(adaptiveMergeSortInPlace(head, threshold),adaptiveMergeSortInPlace(second, threshold));
        } else {
            return selectionSortInPlace(head);
        }
    }

    /**
     * Splits the list into two subsequences.
     *
     * <p>The decomposition of the list into two subsequences is related to the searched optimal size and the number of
     * elements of runs, which is close to the optimal size.
     *
     * @param head        the list to split
     * @param optimalSize the optimal size after the split
     * @return the second part of the list
     */
    private ListItem<T> split(ListItem<T> head, int optimalSize) {
        var second = head;
        ArrayList<T> list = new ArrayList<>();
        listItemToList(second, list);
        while(list.size() > optimalSize){
            list = new ArrayList<>();
            if(second.next == null){
                break;
            }
            second = second.next;
            listItemToList(second, list);
        }
        // remove second sequence from first sequence
        var iterator = head;
        while(iterator.next != second){
            iterator = iterator.next;
            if(iterator == null){
                return second;
            }
        }
        iterator.next = null;
        return second;
    }

    /**
     * Merges the two given sub-sequences into one sorted sequence.
     *
     * @param left  the left sub-sequence
     * @param right the right sub-sequence
     * @return the merged sorted sequence
     */
    private ListItem<T> merge(ListItem<T> left, ListItem<T> right) {
        var head = (cmp.compare(left.key,right.key)<=0)?left:right;
        var iterator = head;
        var leftIterator = (head == left)?left.next:left;
        var rightIterator = (head == right)?right.next:right;
        while(leftIterator != null || rightIterator != null){
            if(leftIterator == null){
                iterator.next = rightIterator;
                rightIterator = rightIterator.next;
            } else if(rightIterator == null){
                iterator.next = leftIterator;
                leftIterator = leftIterator.next;
            } else if(cmp.compare(leftIterator.key, rightIterator.key)<=0){
                iterator.next = leftIterator;
                leftIterator = leftIterator.next;
            } else if(cmp.compare(leftIterator.key, rightIterator.key)>=0){
                iterator.next = rightIterator;
                rightIterator = rightIterator.next;
            }
            iterator = iterator.next;
        }
        return head;
    }

    /**
     * Sorts the list in place using the selection sort algorithm.
     *
     * @param head the list to sort
     * @return the sorted list
     */
    private ListItem<T> selectionSortInPlace(ListItem<T> head) {
        var iterator = head;
        ListItem<T> iteratorParent = null;
        while(iterator != null){
            var innerIterator = iterator.next;
            var previous = iterator;
            ListItem<T> smallestParent = null;
            ListItem<T> smallest = iterator;
            while(innerIterator != null){
                if(cmp.compare(innerIterator.key,smallest.key) < 0){
                    smallestParent = previous;
                    smallest = innerIterator;
                }
                innerIterator = innerIterator.next;
            }
            if(smallest != null && smallest != iterator){
                if(iteratorParent == null){
                    var temp = head;
                    head = smallest;
                    if(temp.next == smallest){
                        temp.next = temp.next.next;
                        head.next = temp;
                    } else {
                        head.next = temp.next;
                        smallestParent.next = smallestParent.next.next;
                    }
                    iterator = head;
                } else {
                    var temp = iterator;
                    iteratorParent.next = smallest;
                    if(temp.next == smallest){
                        temp.next = temp.next.next;
                        iteratorParent.next.next = temp;
                    } else {
                        iteratorParent.next.next = temp.next;
                        smallestParent.next = smallestParent.next.next;
                    }
                }
                smallest = null;
                smallestParent = null;
            }
            

            iteratorParent = iterator;
            iterator = iterator.next;
        }
        return head;
    }
}
