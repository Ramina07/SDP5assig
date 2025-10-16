package lms.course;

public class CertificateDecorator extends CourseDecorator {

    public CertificateDecorator(Course course) {
        super(course);
    }

    @Override
    public String deliverContent() {
        return course.deliverContent() + " + Certificate awarded upon completion.";
    }
}
