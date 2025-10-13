package decorators;
import course.Course;

public class CertificateDecorator extends CourseDecorator {

    public CertificateDecorator(Course course) {
        super(course);
    }

    @Override
    public void deliverContent() {
        super.deliverContent();
        addCertificate();
    }

    private void addCertificate() {
        System.out.println("Certificate granted after completion.");
    }
}


