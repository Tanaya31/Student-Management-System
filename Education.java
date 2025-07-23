package inheritance;

public class Education {
    private String course;
    private String university;
    private int yop;
    private double cgpa;

    public Education(String course, String university, int yop, double cgpa) {
        this.course = course;
        this.university = university;
        this.yop = yop;
        this.cgpa = cgpa;
    }

    public String getCourse() {
        return course;
    }

    public String getUniversity() {
        return university;
    }

    public int getYop() {
        return yop;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        return "Education [course=" + course + ", university=" + university +
                ", yop=" + yop + ", cgpa=" + cgpa + "]";
    }
}
