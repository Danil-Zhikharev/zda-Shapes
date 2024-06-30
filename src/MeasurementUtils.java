import java.util.List;

public class MeasurementUtils {
    public static double calculateTotalLength(List<Measurable> measurables) {
        double totalLength = 0;
        for (Measurable measurable : measurables) {
            totalLength += measurable.getLength();
        }
        return totalLength;
    }
}
