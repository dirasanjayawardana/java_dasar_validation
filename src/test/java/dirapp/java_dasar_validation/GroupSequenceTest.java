package dirapp.java_dasar_validation;

import org.junit.jupiter.api.Test;

import dirapp.java_dasar_validation.group.PaymentGroup;

public class GroupSequenceTest extends AbstractValidatorTest {
  // GroupSequence --> untuk menentukan grup mana terlebih dahulu yang akan divalidasi
  // dengan menambahkan Annotasi @GroupSequence atau langsung di class nya
  // jika terjadi error validasi sebuah group, maka otomatis tidak dilanjutkan ke group selanjutnya
  
   @Test
  void testGroupSequence() {

    Payment payment = new Payment();
    payment.setOrderId("0001");
    payment.setAmount(20_000L);
    // payment.setCreditCard("4111111111111111");
    payment.setVirtualAccount("dira");

    validateWithGroups(payment, PaymentGroup.class);
  }
}
