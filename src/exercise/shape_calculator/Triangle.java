package exercise.shape_calculator;

public class Triangle implements Shape {

    private double base;
    private double height;

    public Triangle(double base,double height){
        setBase(base);
        setHeight(height);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        if(base<=0){
            throw new IllegalArgumentException("Base must be greater than 0");
        }
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height<=0){
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5*base*height;
    }
}
