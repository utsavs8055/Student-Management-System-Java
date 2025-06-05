import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Student by ID");
            System.out.println("3. Delete Student by ID");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    studentList.add(new Student(id, name, course));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter ID to view: ");
                    int viewId = sc.nextInt();
                    boolean found = false;
                    for (Student s : studentList) {
                        if (s.id == viewId) {
                            s.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Student not found!");
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    found = false;
                    for (Student s : studentList) {
                        if (s.id == deleteId) {
                            studentList.remove(s);
                            System.out.println("Student deleted.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Student not found!");
                    break;

                case 4:
                    System.out.println("--- All Students ---");
                    for (Student s : studentList) {
                        s.display();
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while(choice != 5);

        sc.close();
    }
}

