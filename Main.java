import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {

            System.out.println("\n====================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. View Academic Details");
            System.out.println("7. View Topper");
            System.out.println("8. Low Attendance Report");
            System.out.println("9. Filter By Department");
            System.out.println("10. Exit");

            System.out.print("\nEnter Your Choice: ");
            int choice = sc.nextInt();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Enter Student ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter Department: ");
                        String department = sc.nextLine();

                        System.out.print("Enter Semester: ");
                        int semester = sc.nextInt();

                        System.out.print("Enter CGPA: ");
                        double cgpa = sc.nextDouble();

                        System.out.print("Enter Attendance (%): ");
                        double attendance = sc.nextDouble();

                        Student student = new Student(
                                id,
                                name,
                                email,
                                department,
                                semester,
                                cgpa,
                                attendance);

                        service.addStudent(student);

                        System.out.println("Student Added Successfully.");
                        break;

                    case 2:

                        System.out.println("\n===== ALL STUDENTS =====");

                        if (service.getAllStudents().isEmpty()) {
                            System.out.println("No Students Available.");
                        } else {
                            service.getAllStudents()
                                    .forEach(System.out::println);
                        }

                        break;

                    case 3:

                        System.out.print("Enter Student ID: ");
                        int searchId = sc.nextInt();

                        Student found =
                                service.getStudentById(searchId);

                        System.out.println(found);

                        break;

                    case 4:

                        System.out.print("Enter Student ID: ");
                        int updateId = sc.nextInt();

                        System.out.println("\n1. Update Email");
                        System.out.println("2. Update CGPA");
                        System.out.println("3. Update Attendance");

                        System.out.print("Enter Choice: ");
                        int updateChoice = sc.nextInt();

                        switch (updateChoice) {

                            case 1:

                                sc.nextLine();

                                System.out.print(
                                        "Enter New Email: ");

                                String newEmail =
                                        sc.nextLine();

                                service.updateEmail(
                                        updateId,
                                        newEmail);

                                System.out.println(
                                        "Email Updated Successfully.");
                                break;

                            case 2:

                                System.out.print(
                                        "Enter New CGPA: ");

                                double newCgpa =
                                        sc.nextDouble();

                                service.updateCgpa(
                                        updateId,
                                        newCgpa);

                                System.out.println(
                                        "CGPA Updated Successfully.");
                                break;

                            case 3:

                                System.out.print(
                                        "Enter New Attendance: ");

                                double newAttendance =
                                        sc.nextDouble();

                                service.updateAttendance(
                                        updateId,
                                        newAttendance);

                                System.out.println(
                                        "Attendance Updated Successfully.");
                                break;

                            default:
                                System.out.println(
                                        "Invalid Update Choice");
                        }

                        break;

                    case 5:

                        System.out.print("Enter Student ID: ");
                        int deleteId = sc.nextInt();

                        service.deleteStudent(deleteId);

                        System.out.println(
                                "Student Deleted Successfully.");

                        break;

                    case 6:

                        System.out.print("Enter Student ID: ");
                        int academicId = sc.nextInt();

                        Student s =
                                service.getStudentById(academicId);

                        System.out.println(
                                "\n===== ACADEMIC DETAILS =====");

                        System.out.println(
                                "Name       : " + s.getName());

                        System.out.println(
                                "Department : " + s.getDepartment());

                        System.out.println(
                                "Semester   : " + s.getSemester());

                        System.out.println(
                                "CGPA       : " + s.getCgpa());

                        System.out.println(
                                "Attendance : "
                                        + s.getAttendance()
                                        + "%");

                        break;

                    case 7:

                        Student topper =
                                service.getTopper();

                        if (topper != null) {

                            System.out.println(
                                    "\n===== TOPPER =====");

                            System.out.println(topper);
                        } else {

                            System.out.println(
                                    "No Student Records Available.");
                        }

                        break;

                    case 8:

                        System.out.println(
                                "\n===== LOW ATTENDANCE STUDENTS =====");

                        service.lowAttendanceStudents()
                                .forEach(System.out::println);

                        break;

                    case 9:

                        sc.nextLine();

                        System.out.print(
                                "Enter Department: ");

                        String dept =
                                sc.nextLine();

                        service.filterByDepartment(dept)
                                .forEach(System.out::println);

                        break;

                    case 10:

                        System.out.println(
                                "Thank You!");

                        System.exit(0);

                    default:

                        System.out.println(
                                "Invalid Choice.");
                }

            } catch (StudentNotFoundException e) {

                System.out.println(
                        "Error: " + e.getMessage());
            }
        }
    }
}