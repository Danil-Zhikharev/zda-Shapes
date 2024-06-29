import java.math.BigDecimal;
import java.math.RoundingMode;

class ClosedPolyline extends Polyline {

    public ClosedPolyline() {
        super();
    }

    public ClosedPolyline(Point... points) {
        super(points);
    }

    @Override
    public double getLength() {
        double length = super.getLength();
        // Добавляем расстояние от последней точки к первой
        if (points.size() > 1) {
            length += points.get(points.size() - 1).distanceTo(points.get(0));
        }

        BigDecimal bd = new BigDecimal(length);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Замкнутая линия [");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i).toString());
            if (i < points.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] - длина : " + getLength());
        return sb.toString();
    }
}