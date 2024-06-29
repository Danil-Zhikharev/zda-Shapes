class Triangle extends Shape {
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getPoint3() {
        return point3;
    }

    @Override
    public double getPerimeter() {
        double side1 = point1.distanceTo(point2);
        double side2 = point2.distanceTo(point3);
        double side3 = point3.distanceTo(point1);
        return side1 + side2 + side3;
    }

    @Override
    public double getArea() {
        double side1 = point1.distanceTo(point2);
        double side2 = point2.distanceTo(point3);
        double side3 = point3.distanceTo(point1);
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public String toString() {
        return "Треугольник с вершинами в точках " + point1.toString() + ", " + point2.toString() + ", " + point3.toString();
    }

    public Polyline toPolyline() {
        return new Polyline(point1, point2, point3, point1);
    }
}
