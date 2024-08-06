package dirapp.java_dasar_validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.metadata.ConstraintDescriptor;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstraintDescriptorTest extends AbstractValidatorTest {
    // ConstraintDescriptor merupakan interface yang berisi informasi tentang Constraint
    // bisa mendapatkan informasi seperti Annotation, Group, ValidatorClass, Message Template, Annotation Method

    @Test
    void testConstraintDescriptor() {
        Person person = new Person();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        for (ConstraintViolation<Person> violation : violations) {
            ConstraintDescriptor<?> descriptor = violation.getConstraintDescriptor();
            System.out.println(descriptor.getAnnotation());
            System.out.println(descriptor.getAttributes());
            System.out.println(descriptor.getPayload());
            System.out.println(descriptor.getGroups());
            System.out.println("===========================================================");
        }
    }
}
