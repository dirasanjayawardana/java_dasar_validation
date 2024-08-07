package dirapp.java_dasar_validation;

import jakarta.validation.metadata.BeanDescriptor;
import jakarta.validation.metadata.ConstraintDescriptor;
import jakarta.validation.metadata.PropertyDescriptor;
import org.junit.jupiter.api.Test;

public class MetaDataTest extends AbstractValidatorTest {
    // Metadata untuk constraint, disimpan dalam object BeanDescriptor
    // digunakan untuk melihat detail dari constraint

    @Test
    void testPerson() {
        BeanDescriptor beanDescriptor = validator.getConstraintsForClass(Person.class);

        for (PropertyDescriptor constrainedProperty : beanDescriptor.getConstrainedProperties()) {
            System.out.println(constrainedProperty.getPropertyName());

            for (ConstraintDescriptor<?> constraintDescriptor : constrainedProperty.getConstraintDescriptors()) {
                System.out.println(constraintDescriptor);
            }
        }
    }
}
