package dirapp.java_dasar_validation;

import org.junit.jupiter.api.Test;

import dirapp.java_dasar_validation.group.CreditCardPaymentGroup;

public class CustomConstraintTest extends AbstractValidatorTest {
  // untuk membuat Custom Constraint, harus membuat Constraint Annotation, dan membuat ConstraintValidator

  @Test
  void testCustomConstraint() {

    Payment payment = new Payment();
    payment.setOrderId("dira");
    
    validateWithGroups(payment, CreditCardPaymentGroup.class);
  }
}
