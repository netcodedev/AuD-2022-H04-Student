package h04.function;

import org.jetbrains.annotations.Nullable;

/**
 * Fits a function to a set of data points.
 *
 * <p>The function has the following form:
 * <pre>{@code
 *    n = number of data points
 *    samples = number of non null data points
 *    x = i / (n - 1)
 *    y = f(x)
 *    x^hat = sum(x_i) / samples
 *    y^hat = sum(y_i) / samples
 *    beta_1 = sum_i^n [(x_i - x hat)^2 * (y_i - y hat)] / sum_i^n [(x_i - x hat)^2]
 *    beta_2 = y^hat - beta_1 * x^hat
 *
 *    Fitter(x, y) = beta_1 * x + beta_2
 * }</pre>
 *
 * @author Nhan Huynh
 */
public class LinearRegression implements DoubleToIntFunctionFitter {

    @Override
    public DoubleToIntFunction fitFunction(@Nullable Integer[] y) {
        throw new RuntimeException("H3.1 - not implemented"); // TODO: H3.1 - remove if implemented
    }
}
