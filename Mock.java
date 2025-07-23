package inheritance;

import java.util.Scanner;

public class Mock {
    private String subject;
    private String trainer;
    private String date;
    private String rating;
    private String batchCode;

    public Mock(String subject, String trainer, String date, String rating, String batchCode) {
        this.subject = subject;
        this.trainer = trainer;
        this.date = date;
        this.rating = rating;
        this.batchCode = batchCode;
    }

    public static Mock inputMock() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Subject: ");
        String subject = sc.nextLine();
        System.out.print("Trainer: ");
        String trainer = sc.nextLine();
        System.out.print("Date: ");
        String date = sc.nextLine();
        System.out.print("Rating: ");
        String rating = sc.nextLine();
        System.out.print("Batch Code: ");
        String batchCode = sc.nextLine();

        return new Mock(subject, trainer, date, rating, batchCode);
    }

    @Override
    public String toString() {
        return "Mock [subject=" + subject + ", trainer=" + trainer + ", date=" + date +
                ", rating=" + rating + ", batchCode=" + batchCode + "]";
    }
}
