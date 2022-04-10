package h04.function;

import java.util.Comparator;
import java.util.List;

/**
 * Represents a function that accepts a double-valued argument and produces an int-valued result.
 *
 * <p>The function values are calculated by the ratio of inversions and the maximum number of inversions.
 *
 * @author Nhan Huynh
 */
public class FunctionOnRatioOfInversions<T> extends FunctionOnDegreeOfDisorder<T> {

    /**
     * The function to be applied to the ratio of runs.
     */
    private final DoubleToIntFunction function;

    /**
     * Constructs and initializes a {@code FunctionOnRatioOfInversions}.
     *
     * @param cmp      the comparator used to compare the elements of the list
     * @param function the function to be applied to the ratio of runs
     */
    public FunctionOnRatioOfInversions(Comparator<? super T> cmp, DoubleToIntFunction function) {
        super(cmp);
        this.function = function;
    }

    @Override
    public int apply(List<T> elements) {
        throw new RuntimeException("H1.2 - not implemented"); // TODO: H1.2 - remove if implemented
    }
}
