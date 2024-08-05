package dirapp.java_dasar_validation;

import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

import dirapp.java_dasar_validation.constraint.CheckCase;
import dirapp.java_dasar_validation.constraint.CheckOrderId;
import dirapp.java_dasar_validation.enums.CaseMode;
import dirapp.java_dasar_validation.group.CreditCardPaymentGroup;
import dirapp.java_dasar_validation.group.VirtualAccountPaymentGroup;
import dirapp.java_dasar_validation.payload.EmailErrorPayload;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;

public class Payment {
  // selain Annotation Constraint, terdapat juga Hibernate Validator yang juga menyediakan Constraint tambahan
  // cara penggunaannya sama dengan Annotation Constraint
  // Contohnya @Range, @CreditCardNumber, @LuhnCheck, dll

  // Secara default, saat validator melakukan validasi, validator akan memvalidasi semua field yang memiliki Constraint
  // Dengan Group Constraint, Constraint bisa dikelompokkan
  // Saat melakukan validasi, bisa memilih group mana yang akan di validasi
  // Setiap Constraint bisa memiliki lebih dari satu group
  // Sebelum membuat group pada Constraint, harus membuat class atau interface sebagai flaging saja
  

  @CheckOrderId(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
      message = "{order.id.invalid}")
  private String orderId;
  
  @Range(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
      min = 10_000L, max = 100_000_000L, message = "{order.amount.range}")
  @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
      message = "amount can not null")
  private Long amount;
  
  @NotBlank(groups = {CreditCardPaymentGroup.class}, message = "credit card can not blank")
  @LuhnCheck(groups = {CreditCardPaymentGroup.class}, message = "invalid credit card number",
      payload = {EmailErrorPayload.class})
  private String creditCard;

  @NotBlank(groups = {VirtualAccountPaymentGroup.class}, message = "virtual account can not blank")
  private String virtualAccount;

  // jika sebuah class sudah memiliki field group, namun class tersebut di embed di class lain dengan group yang berbeda
  // maka perlu dilakukan konversi group, agar class yg di embed bisa tetap divalidasi
  // dengan menggunakan Annotasi @ConvertGroup, lalu tentukan dari group apa ke group apa

  // Contohnya class Customer yang merupakan field dari class Payment
  // tetap ingin divalidasi ketika group "VirtualAccountPaymentGroup" dan "CreditCardPaymentGroup" divalidasi
  @Valid
  @NotNull(groups = {VirtualAccountPaymentGroup.class, CreditCardPaymentGroup.class},
      message = "customer can not null")
  @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
  @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
  private Customer customer;
  
  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public String getVirtualAccount() {
    return virtualAccount;
  }

  public void setVirtualAccount(String virtualAccount) {
    this.virtualAccount = virtualAccount;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public String getCreditCard() {
    return creditCard;
  }

  public void setCreditCard(String creditCard) {
    this.creditCard = creditCard;
  }
}
