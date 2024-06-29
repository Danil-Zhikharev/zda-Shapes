import java.util.ArrayList;
import java.util.List;

class Square extends Shape {
    private Point topLeft;
    private int sideLength;

    // Конструктор, который принимает точку и длину стороны
    public Square(Point topLeft, int sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны квадрата должна быть положительной");
        }
        this.topLeft = topLeft;
        this.sideLength = sideLength;
    }

    // Метод для получения верхнего левого угла
    public Point getTopLeft() {
        return topLeft;
    }

    // Метод для получения длины стороны
    public int getSideLength() {
        return sideLength;
    }

    // Метод для обновления верхнего левого угла и длины стороны
    public void update(Point newTopLeft, int newSideLength) {
        if (newSideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны квадрата должна быть положительной");
        }
        this.topLeft = newTopLeft;
        this.sideLength = newSideLength;
    }

    public void setSideLength(int newSideLength) {
        if (newSideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны квадрата должна быть положительной");
        }
        this.sideLength = newSideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    // Переопределение метода toString для приведения объекта к строке
    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft.toString() + " со стороной " + sideLength;
    }

    // Метод для вычисления площади квадрата
    public int area() {
        return sideLength * sideLength;
    }

    // Метод для вычисления периметра квадрата
    public int perimeter() {
        return 4 * sideLength;
    }

    // Метод для получения ломаной из углов квадрата
    public Polyline toPolyline() {
        Point topRight = new Point(topLeft.getX() + sideLength, topLeft.getY());
        Point bottomRight = new Point(topLeft.getX() + sideLength, topLeft.getY() + sideLength);
        Point bottomLeft = new Point(topLeft.getX(), topLeft.getY() + sideLength);

        return new Polyline(topLeft, topRight, bottomRight, bottomLeft);
    }
}
