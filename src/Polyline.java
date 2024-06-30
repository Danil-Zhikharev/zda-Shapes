import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Polyline implements Measurable {
    protected List<Point> points;

    // Конструктор без параметров, который инициализирует пустой список точек
    public Polyline() {
        this.points = new ArrayList<>();
    }

    // Конструктор с параметрами, который принимает массив точек
    public Polyline(Point... points) {
        this.points = new ArrayList<>(Arrays.asList(points));
    }

    // Метод для добавления новой точки в ломаную линию
    public void addPoint(Point point) {
        this.points.add(point);
    }

    // Метод для добавления массива точек в ломаную линию
    public void addPoints(Point... newPoints) {
        this.points.addAll(Arrays.asList(newPoints));
    }

    // Метод для получения всех точек ломаной линии
    public List<Point> getPoints() {
        return points;
    }

    // Метод для вычисления общей длины ломаной линии
    public double getLength() {
        double length = 0.0;
        for (int i = 1; i < points.size(); i++) {
            length += points.get(i).distanceTo(points.get(i - 1));
        }
        // Округление до двух знаков после запятой
        BigDecimal bd = new BigDecimal(length);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void updatePoint(int index, int newX, int newY) {
        if (index < 0 || index >= points.size()) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        points.get(index).update(newX, newY);
    }

    // Метод для преобразования объекта Polyline в строку
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
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
