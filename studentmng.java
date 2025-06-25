import java.util.ArrayList;
import java.util.Scanner;

class student
{
    int id;
    String name;
    float marks;

    public student(int id, String name, float marks)
    {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    @Override
    public String toString()
    {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    } 
}

// Main class moved outside of 'student'
class Studentmngcli
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<student> students = new ArrayList<>();
        int choice;

        do { 
            System.out.println("\n======Student Management System======");
            System.out.println("!. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            

            switch(choice)

            {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    float marks = sc.nextFloat();
                    students.add(new student(id, name, marks));
                    System.out.println("Student added successfully!");
                    break;

                case 2:

                    System.out.println("\n=== Student List ===");
                    for (student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.print("Enter ID of student to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    for (student s : students) 
                    {
                        if (s.id == updateId) 
                            {         
                            System.out.print("Enter new Name: ");
                            s.name = sc.nextLine();
                            System.out.print("Enter new Marks: ");
                            s.marks = sc.nextFloat();
                            System.out.println("Student updated successfully!");
                            break;
                            }
                    }
                    break;

                case 4: // Delete
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();
                    boolean removed = students.removeIf(s -> s.id == deleteId);
                    if (removed)
                    {
                        System.out.println("Student deleted.");
                    } else
                    {
                        System.out.println(" Student not found.");
                    }
                    break;

                case 5:
                    System.out.println(" Exiting program. ");
                    break;

                default:
                    System.out.println(" Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
} 





