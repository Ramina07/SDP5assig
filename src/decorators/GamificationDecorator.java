package decorators;
import course.Course;

public class GamificationDecorator extends CourseDecorator {

    public GamificationDecorator(Course course) {
        super(course);
    }

    @Override
    public void deliverContent() {
        super.deliverContent();
        addGamification();
    }

    private void addGamification() {
        System.out.println("Adding points and leaderboard.");
    }
}


