package lms.student;

import lms.course.*;
import java.util.List;

public class StudentPortalFacade {
    private Student student;

    public StudentPortalFacade(Student student) {
        this.student = student;
    }

    public void enrollInCourse(String courseType, List<String> decorators) {
        Course course;
        String courseName;

        if (courseType.equalsIgnoreCase("math")) {
            course = new MathCourse();
            courseName = "Math Course";
        } else if (courseType.equalsIgnoreCase("programming")) {
            course = new ProgrammingCourse();
            courseName = "Programming Course";
        } else {
            System.out.println("Unknown course type.");
            return;
        }

        for (String decorator : decorators) {
            switch (decorator.toLowerCase()) {
                case "certificate":
                    course = new CertificateDecorator(course);
                    break;
                case "mentor":
                    course = new MentorSupportDecorator(course);
                    break;
                case "gamification":
                    course = new GamificationDecorator(course);
                    break;
            }
        }

        student.enroll(courseName, course);
        System.out.println("\n✅ " + student.getName() + " enrolled in " + courseName +
                " with features: " + (decorators.isEmpty() ? "none" : String.join(", ", decorators)));
    }

    public void startLearning(String courseName) {
        Course course = student.getCourse(courseName);
        if (course != null) {
            System.out.println("\n🚀 " + student.getName() + " started learning " + courseName + "!");
            System.out.println(course.deliverContent());
        } else {
            System.out.println("Course not found!");
        }
    }

    public void completeCourse(String courseName) {
        if (student.getCourse(courseName) != null) {
            student.updateProgress(courseName, 100);
            System.out.println("\n🎓 " + student.getName() + " has completed " + courseName + "!");
            System.out.println("Completion Status: " + student.getProgress(courseName) + "%");
        } else {
            System.out.println("Course not found!");
        }
    }
}

