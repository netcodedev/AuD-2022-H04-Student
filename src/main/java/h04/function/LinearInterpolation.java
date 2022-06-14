package h04.function;

import org.jetbrains.annotations.Nullable;

/**
 * Fits a function to a set of data points.
 *
 * <p>The function has the following form:
 * <ol>
 *   <li>Create a double-array and copy all indices values of y to the new array which are not {@code null}.</li>
 *   <li>The indices containing {@code null} values are linearly interpolated using the next left and right known function
 *   values.</li>
 *   <li>Create an int-array and round all values.</li>
 *   <li>Create a {@code ArrayDoubleToIntFunction} containing the rounded values.</li>
 * </ol>
 *
 * @author Nhan Huynh
 */
public class LinearInterpolation implements DoubleToIntFunctionFitter {

    @Override
    public DoubleToIntFunction fitFunction(@Nullable Integer[] y) {
        int[] vars = new int[y.length];
        int firstNullIndex = -1;
        Integer lastNonNullValue = -1;
        for(int i = 0; i<y.length; i++){
            if(y[i] != null){
                vars[i] = (int) Math.round(y[i]);
                if(firstNullIndex != -1){
                    //fill values at index firstNullIndex until i-1
                    for(int j = firstNullIndex; j<i; j++){
                        double xlower = firstNullIndex-1;
                        double xupper = i;
                        double ylower = lastNonNullValue;
                        double yupper = y[i];
                        double slope = (yupper-ylower)/(xupper-xlower);
                        vars[j] = (int) Math.round(ylower + slope*(j-xlower));
                    }
                    firstNullIndex = -1;
                }
                lastNonNullValue = y[i];
            } else if(firstNullIndex == -1) {
                firstNullIndex = i;
            }
        }
        return new ArrayDoubleToIntFunction(vars);
    }
}
