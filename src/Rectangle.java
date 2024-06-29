class Rectangle extends Shape {
    private Point topLeft;
    private int width;
    private int height;

    public Rectangle(Point topLeft, int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Ширина и высота прямоугольника должны быть положительными");
        }
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Ширина прямоугольника должна быть положительной");
        }
        this.width = width;
    }

    public void setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Высота прямоугольника должна быть положительной");
        }
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Прямоугольник в точке " + topLeft.toString() + " с шириной " + width + " и высотой " + height;
    }

    public Polyline toPolyline() {
        Point topRight = new Point(topLeft.getX() + width, topLeft.getY());
        Point bottomRight = new Point(topLeft.getX() + width, topLeft.getY() + height);
        Point bottomLeft = new Point(topLeft.getX(), topLeft.getY() + height);

        return new Polyline(topLeft, topRight, bottomRight, bottomLeft);
    }
}
