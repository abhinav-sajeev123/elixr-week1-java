package exercise.shape_calculator;

public class Rectangle implements Shape{

    private double length;
    private double width;

    public Rectangle(double length,double width){
        setLength(length);
        setWidth(width);
    }
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if(length<=0){
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width<=0){
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length*width;
    }
}
