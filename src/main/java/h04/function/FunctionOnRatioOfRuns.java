package h04.function;

import java.util.Comparator;
import java.util.List;

/**
 * Represents a function that accepts a list-valued argument and produces an int-valued result.
 *
 * <p>The function values are calculated by the ratio of runs to the number of elements.
 *
 * @author Nhan Huynh
 */
public class FunctionOnRatioOfRuns<T> extends FunctionOnDegreeOfDisorder<T> {

    /**
     * The function to be applied to the ratio of runs.
     */
    private final DoubleToIntFunction function;

    /**
     * Constructs and initializes a {@code FunctionOnRatioOfRuns}.
     *
     * @param cmp      the comparator used to compare the elements of the list
     * @param function the function to be applied to the ratio of runs
     */
    public FunctionOnRatioOfRuns(Comparator<? super T> cmp, DoubleToIntFunction function) {
        super(cmp);
        this.function = function;
    }

    @Override
    public int apply(List<T> elements) {
        T last = null;
        int sequences = 1;
        for(T t : elements){
            if(last == null){
                last = t;
                continue;
            }
            if(cmp.compare(last, t) > 0){
                sequences++;
            }
            last = t;
        }
        return function.apply((double)sequences/(double)elements.size());
    }
}
