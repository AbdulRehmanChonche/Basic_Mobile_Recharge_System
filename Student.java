public class Student {

    private int studentId;
    private String name;
    private String email;
    private String department;
    private int semester;
    private double cgpa;
    private double attendance;

    public Student(int studentId,
                   String name,
                   String email,
                   String department,
                   int semester,
                   double cgpa,
                   double attendance) {

        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.department = department;
        this.semester = semester;
        this.cgpa = cgpa;
        this.attendance = attendance;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public int getSemester() {
        return semester;
    }

    public double getCgpa() {
        return cgpa;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }

    @Override
    public String toString() {

        return "ID=" + studentId +
                ", Name=" + name +
                ", Email=" + email +
                ", Department=" + department +
                ", Semester=" + semester +
                ", CGPA=" + cgpa +
                ", Attendance=" + attendance + "%";
    }
}