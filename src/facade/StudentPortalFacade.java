package facade;

import course.Course;
import course.MathCourse;
import course.ProgrammingCourse;
import decorators.*;

public class StudentPortalFacade {
    private Course course;

    public StudentPortalFacade(Course course) {
        this.course = course;
    }

    public void enrollInCourse() {
        System.out.println("Enrolling in the course.");
    }

    public void startLearning() {
        System.out.println("Starting the course.");
        course.deliverContent();
    }

    public void completeCourse() {
        System.out.println("Completing the course.");
    }
}
