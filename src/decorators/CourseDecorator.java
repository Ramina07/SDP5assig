package decorators;
import course.Course;

public abstract class CourseDecorator implements Course {
    protected Course course;

    public CourseDecorator(Course course) {
        this.course = course;
    }

    public void deliverContent() {
        course.deliverContent();
    }
}


