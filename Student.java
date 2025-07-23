package inheritance;

import java.util.Scanner;

public class Student {
    static int uniqid = 123;
    private String id;
    private String name;
    private String emailId;
    private long contact;
    private Address address;
    private Education[] education = new Education[5];
    private Mock[] mock = new Mock[5];
    private int eduIndx = 0;
    private int mockIndx = 0;
    static Scanner sc = new Scanner(System.in);

    {
        id = "QSP" + uniqid++;
    }

    public Student(String name, String emailId, long contact, Address address) {
        this.name = name;
        this.emailId = emailId;
        this.contact = contact;
        this.address = address;
        this.education = addEducation();
    }

    private Education[] addEducation() {
        Education[] arr = new Education[5];
        int i = 0;
        while (i < arr.length) {
            System.out.println("Enter your Education Detail:");
            System.out.print("Course: ");
            String course = sc.nextLine();
            System.out.print("University: ");
            String university = sc.nextLine();
            System.out.print("YOP: ");
            int yop = sc.nextInt();
            System.out.print("CGPA: ");
            double cgpa = sc.nextDouble();
            sc.nextLine(); // consume newline
            arr[i++] = new Education(course, university, yop, cgpa);
            System.out.print("Do you want to add more education details (YES/NO): ");
            String resp = sc.nextLine();
            if (resp.equalsIgnoreCase("NO")) break;
        }
        eduIndx = i - 1;
        return arr;
    }

    public void addMock(Mock m) {
        if (mockIndx < mock.length) {
            mock[mockIndx++] = m;
        } else {
            System.out.println("Maximum mocks reached.");
        }
    }

    public Mock[] getMocks() {
        return mock;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public Education[] getEducationDetails() {
        return education;
    }

    public int getEduIndx() {
        return eduIndx;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", emailId=" + emailId +
                ", contact=" + contact + ", address=" + address + "]";
    }
}
