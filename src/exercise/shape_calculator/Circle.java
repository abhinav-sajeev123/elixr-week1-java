package exercise.shape_calculator;

public class Circle implements Shape{


    private double radius;

    public Circle(double radius){
        setRadius(radius);
    }
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if(radius<=0){
            throw new IllegalArgumentException("Radius must be greater than 0");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI*radius*radius;
    }
}
