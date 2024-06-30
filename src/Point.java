class Point {
    private int x;
    private int y;

    // Конструктор, который принимает значения для координат x и y
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int[] coordinates) {
        if (coordinates.length != 2) {
            throw new IllegalArgumentException("Точка принимает только два параметра: x, y");
        }
        this.x = coordinates[0];
        this.y = coordinates[1];
    }

    // Метод для получения значения x
    public int getX() {
        return x;
    }

    // Метод для получения значения y
    public int getY() {
        return y;
    }

    // Метод для обновления координат
    public void update(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    // Метод для вычисления расстояния до другой точки
    public double distanceTo(Point other) {
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    interface Measurable {
        double getLength();
    }
}