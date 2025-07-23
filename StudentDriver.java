package inheritance;

import java.util.Scanner;

public class StudentDriver {
    static int indx = 0;
    static Student[] arr = new Student[20];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWELCOME ");
            System.out.println("1. ADD STUDENT ");
            System.out.println("2. UPDATE STUDENT ");
            System.out.println("3. ALL STUDENTS");
            System.out.println("4. ADD MOCK");
            System.out.println("5. LOGOUT ");
            System.out.print("\nEnter your option: ");

            switch (sc.nextInt()) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    viewAllStudent();
                    break;
                case 4:
                    addMock();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    private static void addStudent() {
        sc.nextLine(); // clear buffer
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String emailId = sc.next();
        System.out.print("Contact: ");
        long contact = sc.nextLong();
        sc.nextLine(); // consume newline
        Address address = addAddress();

        Student student = new Student(name, emailId, contact, address);
        arr[indx++] = student;
        System.out.println("Student added successfully.");
    }

    private static Address addAddress() {
        System.out.print("Area: ");
        String area = sc.nextLine();
        System.out.print("City: ");
        String city = sc.nextLine();
        System.out.print("State: ");
        String state = sc.nextLine();
        System.out.print("Pincode: ");
        int pincode = sc.nextInt();
        sc.nextLine(); // consume newline
        return new Address(area, city, state, pincode);
    }

    private static void updateStudent() {
        System.out.print("Enter student email to update: ");
        String email = sc.next();
        for (int i = 0; i < indx; i++) {
            if (arr[i].getEmailId().equalsIgnoreCase(email)) {
                System.out.println("Student found: " + arr[i]);
                System.out.print("Enter new contact number: ");
                long contact = sc.nextLong();
                arr[i].setContact(contact);
                System.out.println("Contact updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void viewAllStudent() {
        if (arr[0] == null) {
            System.out.println("NO DATA FOUND");
            return;
        }

        System.out.println("\n1. Mock Based Subjects");
        System.out.println("2. YOP");
        System.out.println("3. Criteria");
        System.out.print("Enter an option: ");
        switch (sc.nextInt()) {
            case 1:
                displayStudentMock();
                break;
            case 2:
                displayStudentYop();
                break;
            case 3:
                displayStudentCriteria();
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private static void displayStudentMock() {
        for (Student ele : arr) {
            if (ele == null)
                break;
            System.out.println(ele);
            for (Mock m : ele.getMocks()) {
                if (m == null) break;
                System.out.println("\t" + m);
            }
        }
    }

    private static void displayStudentYop() {
        sc.nextLine(); // clear buffer
        System.out.print("Enter the course: ");
        String course = sc.nextLine();

        Student[] dup = new Student[indx];
        int dupIndx = 0;

        for (Student s : arr) {
            if (s == null) break;
            Education[] edu = s.getEducationDetails();
            int i = s.getEduIndx();
            if (edu[i].getCourse().equalsIgnoreCase(course)) {
                dup[dupIndx++] = s;
            }
        }

        // Sort by YOP descending
        for (int i = 0; i < dupIndx - 1; i++) {
            for (int j = i + 1; j < dupIndx; j++) {
                int yop1 = dup[i].getEducationDetails()[dup[i].getEduIndx()].getYop();
                int yop2 = dup[j].getEducationDetails()[dup[j].getEduIndx()].getYop();
                if (yop1 < yop2) {
                    Student temp = dup[i];
                    dup[i] = dup[j];
                    dup[j] = temp;
                }
            }
        }

        for (Student s : dup) {
            if (s == null) break;
            System.out.println(s);
        }
    }

    private static void displayStudentCriteria() {
        System.out.print("Enter minimum CGPA: ");
        double cgpaLimit = sc.nextDouble();
        System.out.println("Students with CGPA >= " + cgpaLimit + ":");

        for (Student s : arr) {
            if (s == null) break;
            Education[] edu = s.getEducationDetails();
            int i = s.getEduIndx();
            if (edu[i].getCgpa() >= cgpaLimit) {
                System.out.println(s);
            }
        }
    }

    private static void addMock() {
        System.out.print("Enter student email to add mock: ");
        String email = sc.next();
        sc.nextLine(); // clear buffer

        for (Student s : arr) {
            if (s == null) break;
            if (s.getEmailId().equalsIgnoreCase(email)) {
                Mock m = Mock.inputMock();
                s.addMock(m);
                System.out.println("Mock added.");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
