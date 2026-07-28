package collections.list;
import java.util.LinkedList;
import java.util.Scanner;

public class Songs {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList<String> songs = new LinkedList<>();

        int choice;

        do {

            System.out.println("SONGS songs");
            System.out.println("1. Enter Song");
            System.out.println("2. View Songs");
            System.out.println("3. Remove Oldest Song");
            System.out.println("4. Remove Latest Song");
            System.out.println("5. Show First Song");
            System.out.println("6. Show Latest Song");
            System.out.println("7. Remove all songs");
            System.out.println("8. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Song: ");
                    String song = sc.nextLine();

                    songs.addLast(song);

                    System.out.println("Song added Successfully");
                    break;

                case 2:
                    if(!songs.isEmpty()) {

                        for (String s : songs) {
                            System.out.println(s);
                        }
                    }else {
                        System.out.println("Song list is empty");
                    }
                    break;

                case 3:

                    if (!songs.isEmpty()) {

                        System.out.println("Removed : "
                                + songs.removeFirst());
                    } else {
                        System.out.println("songs Empty");
                    }

                    break;

                case 4:

                    if (!songs.isEmpty()) {

                        System.out.println("Removed : "
                                + songs.removeLast());
                    } else {
                        System.out.println("songs Empty");
                    }

                    break;

                case 5:

                    if (!songs.isEmpty()) {
                        System.out.println("First Song : "
                                + songs.getFirst());
                    } else {
                        System.out.println("songs Empty");
                    }

                    break;

                case 6:

                    if (!songs.isEmpty()) {
                        System.out.println("Latest Song : "
                                + songs.getLast());
                    } else {
                        System.out.println("songs Empty");
                    }

                    break;

                case 7:
                    if(!songs.isEmpty()){
                        songs.clear();
                        System.out.println("All songs removed successfully");
                    }
                    else{
                        System.out.println("Songs list is empty, nothing to remove");
                    }

                case 8:

                    System.out.println("Exiting...");
                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while (choice != 8);

        sc.close();
    }
}
