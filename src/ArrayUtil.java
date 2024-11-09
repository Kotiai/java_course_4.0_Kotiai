import java.util.ArrayList;
import java.util.List;

/**
 * ArrayUtil exercises.
 */
public class ArrayUtil {

    /**
     * Finds the common elements between two arrays (String values).
     *
     * @param array1 first array
     * @param array2 second array
     * @return String array with common elements
     */
    public static String[] findCommon(String[] array1, String[] array2) {
        // TODO fill in code here
        List<String> commonElements = new ArrayList<>();
        for (String i : array1){
            for (String j : array2){
                if (i.equals(j) && !commonElements.contains(i)){
                    commonElements.add(i);
                }
            }
        }
        return commonElements.toArray(new String[0]);
    }
}