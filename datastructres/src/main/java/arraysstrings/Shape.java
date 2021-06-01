package main.java.arraysstrings;

public class Shape implements Cloneable {
    String color;
    String type;

    Shape(String color, String type) {
        this.color = color;
        this.type = type;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Shape shape = new Shape("red", "Circle");


        shape.color = "yellow";
        Shape cloneShape = shape.cloneShape();
        if (shape == cloneShape) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        System.out.println(cloneShape.color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Shape clone() throws CloneNotSupportedException {
//        Shape cloned = null;
//        try {
//            cloned = (Shape) super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//
//        return cloned;


        return (Shape) super.clone();
    }

    public Shape cloneShape() throws CloneNotSupportedException {
        return this.clone();
    }
}
