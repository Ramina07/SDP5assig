package lms.student;

import lms.course.Course;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private Map<String, Course> enrolledCourses;
    private Map<String, Integer> progress;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new HashMap<>();
        this.progress = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void enroll(String courseName, Course course) {
        enrolledCourses.put(courseName, course);
        progress.put(courseName, 0);
    }

    public Course getCourse(String courseName) {
        return enrolledCourses.get(courseName);
    }

    public void updateProgress(String courseName, int percent) {
        progress.put(courseName, percent);
    }

    public int getProgress(String courseName) {
        return progress.getOrDefault(courseName, 0);
    }

    public Map<String, Course> getCourses() {
        return enrolledCourses;
    }
}

