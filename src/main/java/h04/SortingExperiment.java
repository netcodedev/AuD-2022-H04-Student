package h04;

import h04.collection.MyCollections;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * A sorting experiment to determine the optimal thresholds for {@link MyCollections#sort(List)}.
 *
 * @author Kim Berninger, Nhan Huynh
 */
public final class SortingExperiment {

    /**
     * Don't let anyone instantiate this class.
     */
    private SortingExperiment() {
    }

    /**
     * Main entry point in executing the sorting experiment.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {
        throw new RuntimeException("H3.2 - not implemented"); // TODO: H3.2 - remove if implemented
    }


    /**
     * Computes the most optimal threshold for runs and inversions in consideration to the least CPU time.
     *
     * @param n     the length of the list to be sorted to measure the CPU time of the algorithm
     * @param swaps the maximum number of permutations to be performed in order to generate the random permutations
     * @param bins  the number of bins in which the key figures of runs and inversions are to be grouped respectively
     * @param gamma the minimum proportion of the threshold to be tried for a bin should be tried for a bin to determine a valid
     *              result
     *
     * @return the most optimal threshold for runs and inversions
     */
    public static @Nullable Integer[][] computeOptimalThresholds(int n, int swaps, int bins, double gamma) {
        throw new RuntimeException("H3.2 - not implemented"); // TODO: H3.2 - remove if implemented
    }

    /**
     * Returns {@code true} if the list is sorted, {@code false} otherwise.
     *
     * @param list the list to be checked
     * @param cmp  the comparator used to compare elements
     * @param <T>  the type of the elements
     *
     * @return {@code true} if the list is sorted, {@code false} otherwise
     */
    private static <T> boolean isSorted(List<T> list, Comparator<? super T> cmp) {
        Iterator<T> it = list.iterator();
        // Empty list
        if (!it.hasNext()) {
            return true;
        }

        T previous = it.next();
        while (it.hasNext()) {
            T current = it.next();
            if (cmp.compare(previous, current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }
}
