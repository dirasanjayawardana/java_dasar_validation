package dirapp.java_dasar_validation;

import org.junit.jupiter.api.Test;

public class HibernateValidatorConstraintTest extends AbstractValidatorTest{
  // selain Annotation Constraint, terdapat juga Hibernate Validator yang juga menyediakan Constraint tambahan
  // cara penggunaannya sama dengan Annotation Constraint
  // Contohnya @Range, @CreditCardNumber, @LuhnCheck, dll

  @Test
  void testHibernateValidatorConstraintInvalid() {
    Payment payment = new Payment();
    payment.setAmount(1000L);
    payment.setOrderId("0001");
    payment.setCreditCard("433");

    validate(payment);
  }


  @Test
  void testHibernateValidatorConstraintValid() {
    Payment payment = new Payment();
    payment.setAmount(20_000L);
    payment.setOrderId("0001");
    payment.setCreditCard("4111111111111111");

    validate(payment);
  }
}