package dirapp.java_dasar_validation;

import org.junit.jupiter.api.Test;

import dirapp.java_dasar_validation.group.CreditCardPaymentGroup;

public class GroupConvertTest extends AbstractValidatorTest {
  // jika sebuah class sudah memiliki field group, namun class tersebut di embed di class lain dengan group yang berbeda
  // maka perlu dilakukan konversi group, agar class yg di embed bisa tetap divalidasi
  // dengan menggunakan Annotasi @ConvertGroup, lalu tentukan dari group apa ke group apa

  // Contohnya class Customer yang merupakan field dari class Payment
  // tetap ingin divalidasi ketika group "VirtualAccountPaymentGroup" dan "CreditCardPaymentGroup" divalidasi


  @Test
  void testGroupConvert() {

    Payment payment = new Payment();
    payment.setOrderId("001");
    payment.setAmount(20_000L);
    payment.setCreditCard("4111111111111111");
    payment.setCustomer(new Customer());

    validateWithGroups(payment, CreditCardPaymentGroup.class);
  }
}
