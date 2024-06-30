import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ShapeUtils {
    public static double calculateTotalArea(List<Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        BigDecimal bd = new BigDecimal(totalArea);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
