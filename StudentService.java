import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {

    private List<Student> students =
            new ArrayList<>();

    // CREATE
    public void addStudent(Student student) {

        students.add(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {

        return students;
    }

    // SEARCH
    public Student getStudentById(int id)
            throws StudentNotFoundException {

        return students.stream()
                .filter(s ->
                        s.getStudentId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student Not Found"));
    }

    // UPDATE EMAIL
    public void updateEmail(
            int id,
            String email)
            throws StudentNotFoundException {

        getStudentById(id)
                .setEmail(email);
    }

    // UPDATE CGPA
    public void updateCgpa(
            int id,
            double cgpa)
            throws StudentNotFoundException {

        getStudentById(id)
                .setCgpa(cgpa);
    }

    // UPDATE ATTENDANCE
    public void updateAttendance(
            int id,
            double attendance)
            throws StudentNotFoundException {

        getStudentById(id)
                .setAttendance(attendance);
    }

    // DELETE
    public void deleteStudent(int id)
            throws StudentNotFoundException {

        students.remove(
                getStudentById(id));
    }

    // FILTER BY DEPARTMENT
    public List<Student> filterByDepartment(
            String department) {

        return students.stream()
                .filter(s ->
                        s.getDepartment()
                                .equalsIgnoreCase(
                                        department))
                .collect(Collectors.toList());
    }

    // TOPPER
    public Student getTopper() {

        return students.stream()
                .max(Comparator.comparingDouble(
                        Student::getCgpa))
                .orElse(null);
    }

    // LOW ATTENDANCE
    public List<Student> lowAttendanceStudents() {

        return students.stream()
                .filter(s ->
                        s.getAttendance() < 75)
                .collect(Collectors.toList());
    }
}