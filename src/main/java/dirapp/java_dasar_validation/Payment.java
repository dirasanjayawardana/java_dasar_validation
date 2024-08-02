package dirapp.java_dasar_validation;

import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

import dirapp.java_dasar_validation.group.CreditCardPaymentGroup;
import dirapp.java_dasar_validation.group.VirtualAccountPaymentGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Payment {
  // selain Annotation Constraint, terdapat juga Hibernate Validator yang juga menyediakan Constraint tambahan
  // cara penggunaannya sama dengan Annotation Constraint
  // Contohnya @Range, @CreditCardNumber, @LuhnCheck, dll

  // Secara default, saat validator melakukan validasi, validator akan memvalidasi semua field yang memiliki Constraint
  // Dengan Group Constraint, Constraint bisa dikelompokkan
  // Saat melakukan validasi, bisa memilih group mana yang akan di validasi
  // Setiap Constraint bisa memiliki lebih dari satu group
  // Sebelum membuat group pada Constraint, harus membuat class atau interface sebagai flaging saja
  

  @NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "orderId can not blank")
  private String orderId;
  
  @Range(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, min = 10_000L, max = 100_000L, message = "amount must between 10.000 and 100.000")
  @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "amount can not blank")
  private Long amount;
  
  @NotBlank(groups = {CreditCardPaymentGroup.class}, message = "credit card can not blank")
  @LuhnCheck(groups = {CreditCardPaymentGroup.class}, message = "invalid credit card number")
  private String creditCard;

  @NotBlank(groups = {VirtualAccountPaymentGroup.class}, message = "virtual account can not blank")
  private String virtualAccount;
  
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