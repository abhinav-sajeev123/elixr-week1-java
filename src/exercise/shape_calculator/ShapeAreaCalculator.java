package exercise.shape_calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Shape>shapes=new ArrayList<>();
        try {
            System.out.println("Enter the no of shapes : ");
            int n=sc.nextInt();

            for(int i=1;i<=n;i++){
                System.out.println("Shape "+i);
                System.out.println("Enter the shape (Circle/Rectangle/Triangle :");
                String type=sc.next().toLowerCase();

                switch (type){
                    case "circle":
                        System.out.println("Enter the radius : ");
                        double radius= sc.nextDouble();
                        shapes.add(new Circle(radius));
                        break;

                    case "rectangle":
                        System.out.println("Enter the length of rectangle : ");
                        double length=sc.nextDouble();
                        System.out.println("Enter the width of rectangle : ");
                        double width=sc.nextDouble();
                        shapes.add(new Rectangle(length,width));
                        break;

                    case "triangle":
                        System.out.println("Enter the base for triangle : ");
                        double base=sc.nextDouble();
                        System.out.println("Enter the height for triangle : ");
                        double height=sc.nextDouble();
                        shapes.add(new Triangle(base,height));
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            }
            int count=1;
            for(Shape shape:shapes){
                String shapeName=shape.getClass().getSimpleName();
                System.out.println("Shape "+count+" : "+shapeName+" area = "+shape.calculateArea());
                count++;
            }

            double totalArea=shapes.stream()
                    .mapToDouble(Shape::calculateArea)
                    .sum();
            System.out.println("Total area = "+totalArea);
        }catch (InputMismatchException e){
            System.out.println("Error : Please enter numeric values only.");
        }
        catch (IllegalArgumentException e){
            System.out.println("Error : "+e.getMessage());
        }
        finally {
            sc.close();
        }

    }
}
