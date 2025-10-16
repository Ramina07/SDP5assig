package lms;

import lms.student.Student;
import lms.student.StudentPortalFacade;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to Online Education Platform ===");
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        Student student = new Student(name);
        StudentPortalFacade portal = new StudentPortalFacade(student);

        while (true) {
            System.out.println("\nChoose a course to enroll:");
            System.out.println("1. Math Course");
            System.out.println("2. Programming Course");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            String choice = sc.nextLine();

            if (choice.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }

            String courseType;
            if (choice.equals("1")) {
                courseType = "math";
            } else if (choice.equals("2")) {
                courseType = "programming";
            } else {
                System.out.println("Invalid option.");
                continue;
            }

            System.out.println("\nAvailable add-ons:");
            System.out.println("1. Certificate");
            System.out.println("2. Mentor Support");
            System.out.println("3. Gamification");
            System.out.println("Type numbers separated by commas (e.g. 1,3) or press Enter for none.");
            System.out.print("Add-ons: ");
            String addonsInput = sc.nextLine();

            Map<String, String> mapping = new HashMap<>();
            mapping.put("1", "certificate");
            mapping.put("2", "mentor");
            mapping.put("3", "gamification");

            List<String> decorators = new ArrayList<>();
            if (!addonsInput.trim().isEmpty()) {
                for (String s : addonsInput.split(",")) {
                    String trimmed = s.trim();
                    if (mapping.containsKey(trimmed)) {
                        decorators.add(mapping.get(trimmed));
                    }
                }
            }

            portal.enrollInCourse(courseType, decorators);

            String courseName = courseType.equals("math") ? "Math Course" : "Programming Course";
            portal.startLearning(courseName);

            System.out.print("\nPress Enter to complete the course...");
            sc.nextLine();

            portal.completeCourse(courseName);
        }

        sc.close();
    }
}
