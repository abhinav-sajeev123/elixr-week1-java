package oops.classes_and_objects;

public class Book {
    String name;
    String author;
    Double price;

    void display(){
        System.out.println("Book details : "+"\n"+"book name : "+name+"\n"+"author name : "
                +author+"\n"+"price : "+price+"\n");
    }
}

class Details {
    public static void main(String[] args) {

        Book book1=new Book();
        book1.name="Wings of fire";
        book1.author="APJ Abdul Kalaam";
        book1.price=100.00;

        book1.display();

        Book book2=new Book();
        book2.name="tales";
        book2.author="albert";
        book2.price=500.90;
        book2.display();
    }
}
