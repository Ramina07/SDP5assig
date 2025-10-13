package demo;

import facade.StudentPortalFacade;
import java.util.List;
import course.MathCourse;
import course.ProgrammingCourse;
import course.Course;
import decorators.*;

public class Main {
    public static void main(String[] args) {
        Course mathCourse = new MathCourse();
        Course programmingCourse = new ProgrammingCourse();

        // Applying Decorators for MathCourse
        Course mathCourseWithSupportAndGamification = new GamificationDecorator(
                new MentorSupportDecorator(
                        new CertificateDecorator(mathCourse)
                )
        );

        // Applying Decorators for ProgrammingCourse
        Course programmingCourseWithSupportAndGamification = new GamificationDecorator(
                new MentorSupportDecorator(
                        new CertificateDecorator(programmingCourse)
                )
        );

        // Using Facade for MathCourse
        StudentPortalFacade studentPortalMath = new StudentPortalFacade(mathCourseWithSupportAndGamification);
        studentPortalMath.enrollInCourse();
        studentPortalMath.startLearning();
        studentPortalMath.completeCourse();

        System.out.println("~~~");

        // Using Facade for ProgrammingCourse
        StudentPortalFacade studentPortalProgramming = new StudentPortalFacade(programmingCourseWithSupportAndGamification);
        studentPortalProgramming.enrollInCourse();
        studentPortalProgramming.startLearning();
        studentPortalProgramming.completeCourse();
    }
}
