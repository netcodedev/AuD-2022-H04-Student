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
 *    x^bar = sum(x_i) / samples
 *    y^bar = sum(y_i) / samples
 *    beta_1 = sum_i^n [(x_i - x hat) * (y_i - y hat)] / sum_i^n [(x_i - x hat)^2]
 *    beta_2 = y^bar - beta_1 * x^bar
 *
 *    Fitter(x, y) = beta_1 * x + beta_2
 * }</pre>
 *
 * @author Nhan Huynh
 */
public class LinearRegression implements DoubleToIntFunctionFitter {

    @Override
    public DoubleToIntFunction fitFunction(@Nullable Integer[] y) {
        int n = y.length;
        int samples = 0;
        for(int i = 0; i<y.length; i++){
            if(y[i] != null) {
                samples++;
            }
        }
        double xSum = 0;
        double ySum = 0;
        for(int i = 0; i<y.length; i++){
            if(y[i] != null){
                xSum += (double)((int)(((double)i/((double)n-1.0))*10)/10.0);
                ySum += y[i];
            }
        }
        double xAvg = (double) xSum / (double) samples;
        double yAvg = (double) ySum / (double) samples;

        double sumUpper = 0;
        double sumLower = 0;
        for(int i = 0; i<n; i++){
            if(y[i] != null){
                double x_i = (double)((int)(((double)i/((double)n-1.0))*10)/10.0);
                double y_i = y[i];
                sumUpper += ((x_i - xAvg) * (y_i - yAvg));
                sumLower += ((x_i - xAvg) * (x_i - xAvg));
            }
        }
        double beta_1 = sumUpper / sumLower;
        double beta_2 = yAvg - (beta_1 * xAvg);
        return new LinearDoubleToIntFunction(beta_1, beta_2);
    }
}
