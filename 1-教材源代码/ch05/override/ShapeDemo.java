package ch05.override;

public class ShapeDemo { // ≤‚ ‘¿‡
    public static void main(String[] args) {
        Square s = new Square();
        Triangle t = new Triangle();
        Circle c = new Circle();

        s.draw();
        t.draw();
        c.draw();
    }
}
