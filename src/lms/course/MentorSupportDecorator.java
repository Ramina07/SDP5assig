package lms.course;

public class MentorSupportDecorator extends CourseDecorator {

    public MentorSupportDecorator(Course course) {
        super(course);
    }

    @Override
    public String deliverContent() {
        return course.deliverContent() + " + Personal mentor support included.";
    }
}

