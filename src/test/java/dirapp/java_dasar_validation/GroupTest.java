package dirapp.java_dasar_validation;

import org.junit.jupiter.api.Test;

import dirapp.java_dasar_validation.group.CreditCardPaymentGroup;
import dirapp.java_dasar_validation.group.VirtualAccountPaymentGroup;

public class GroupTest extends AbstractValidatorTest {
  // Secara default, saat validator melakukan validasi, validator akan memvalidasi semua field yang memiliki Constraint
  // Dengan Group Constraint, Constraint bisa dikelompokkan
  // Saat melakukan validasi, bisa memilih group mana yang akan di validasi
  // Setiap Constraint bisa memiliki lebih dari satu group
  // Sebelum membuat group pada Constraint, harus membuat class atau interface sebagai flaging saja

  @Test
  void testCreditCardGroup() {
    Payment payment = new Payment();
    payment.setOrderId("0111");
    payment.setAmount(20_000L);
    payment.setCreditCard("123");

    validateWithGroups(payment, CreditCardPaymentGroup.class);
  }

  @Test
  void testVirtualAccount() {
    Payment payment = new Payment();
    payment.setOrderId("0111");
    payment.setAmount(20_000L);
    payment.setVirtualAccount("");

    validateWithGroups(payment, VirtualAccountPaymentGroup.class);
  }
}
