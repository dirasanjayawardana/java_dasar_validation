package dirapp.java_dasar_validation.group;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

// GroupSequence --> untuk menentukan grup mana terlebih dahulu yang akan divalidasi
// dengan menambahkan Annotasi @GroupSequence atau langsung di class nya
// jika terjadi error validasi sebuah group, maka otomatis tidak dilanjutkan ke group selanjutnya

@GroupSequence(
  value = {
    Default.class,
    CreditCardPaymentGroup.class,
    VirtualAccountPaymentGroup.class
  }
)
public interface PaymentGroup {
  
}
