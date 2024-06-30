import java.sql.SQLOutput;
import java.util.List;

public class Starter {
    // Задачи 3.2.4, 3.3.3, 3.3.5

    public static void main(String[] args) {
        try {
            // Квадрат в точке {5;3} со стороной 23
            Point point = new Point(5, 3);
            Square square = new Square(point, 23);
            System.out.println(square);
            System.out.println(square.toPolyline());

            // Присвойте в ссылку типа Ломаная результат вызова метода получения Ломаной у ранее созданного квадрата
            Polyline polyline = square.toPolyline();

            // Выведите на экран общую длину полученной Ломаной
            System.out.println("Длина ломаной: " + polyline.getLength());

            // Сдвиг последней точки ломаной в позицию {15, 25}
            polyline.updatePoint(polyline.getPoints().size() - 1, 15, 25);
            System.out.println("Длина ломаной после сдвига: " + polyline.getLength());

            // Пример с попыткой задать отрицательный размер стороны
            Square invalidSquare = new Square(point, -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            // Пример с попыткой изменить размер стороны на отрицательный
            Point point2 = new Point(1, 1);
            Square square2 = new Square(point2, 10);
            System.out.println(square2);
            square2.setSideLength(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            // Создание и вывод круга
            Circle circle = new Circle(new Point(0, 0), 5);
            System.out.println(circle);
            System.out.println("Площадь круга: " + circle.getArea());

            // Создание и вывод квадрата
            Square square = new Square(new Point(1, 1), 10);
            System.out.println(square);
            System.out.println("Площадь квадрата: " + square.getArea());

            // Создание и вывод прямоугольника
            Rectangle rectangle = new Rectangle(new Point(2, 2), 5, 10);
            System.out.println(rectangle);
            System.out.println("Площадь прямоугольника: " + rectangle.getArea());

            // Создание и вывод треугольника
            Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(3, 4));
            System.out.println(triangle);
            System.out.println("Площадь треугольника: " + triangle.getArea());

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Вычисление общей общей площади всех объектов
        List<Shape> shapes = List.of(
                new Circle(new Point(0, 0), 5),
                new Circle(new Point(2, 2), 3),
                new Square(new Point(1, 1), 10),
                new Square(new Point(3, 3), 7)
        );

        double totalArea = ShapeUtils.calculateTotalArea(shapes);
        System.out.println("Общая площадь фигур: " + totalArea);

        // Вычисление общей длины всех объектов
        Point p1 = new Point(0, 0);
        Point p2 = new Point(-3, 4);
        Point p3 = new Point(6, 8);

        Line line = new Line(p1, p2);
        Polyline polyline = new Polyline(p1, p2, p3);

        List<Measurable> measurables = List.of(line, polyline);

        double totalLength =  MeasurementUtils.calculateTotalLength(measurables);
        System.out.println("Общая длина измеряемых объектов: " + totalLength);
    }
}
