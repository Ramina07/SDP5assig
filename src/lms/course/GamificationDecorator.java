package lms.course;

public class GamificationDecorator extends CourseDecorator {

    public GamificationDecorator(Course course) {
        super(course);
    }

    @Override
    public String deliverContent() {
        return course.deliverContent() + " + Earn points and compete on the leaderboard!";
    }
}
