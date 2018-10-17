package seedu.address.model.person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.address.testutil.Assert;

public class PayDeductiblesTest {
  @Test
  public void constructor_null_throwsNullPointerException() {
    Assert.assertThrows(NullPointerException.class, () -> new PayDeductibles(null));
  }

  @Test
  public void constructor_invalidPayDeductibles_throwsIllegalArgumentException() {
    String invalidDeductibles = "";
    Assert.assertThrows(IllegalArgumentException.class, () -> new PayDeductibles(invalidDeductibles));
  }

  @Test
  public void isValidDeductibles() {
    // null deductibles
    Assert.assertThrows(NullPointerException.class, () -> PayDeductibles.isValidTwoDecimalNumber(null));

    // invalid pay deductibles
    assertFalse(PayDeductibles.isValidTwoDecimalNumber("")); // empty string
    assertFalse(PayDeductibles.isValidTwoDecimalNumber(" ")); // spaces only
    assertFalse(PayDeductibles.isValidTwoDecimalNumber("deductibles")); // non-numeric
    assertFalse(PayDeductibles.isValidTwoDecimalNumber("49w0j4")); // alphabets within digits
    assertFalse(PayDeductibles.isValidTwoDecimalNumber("2500 938")); // spaces within digits

    // valid pay deductibles
    assertTrue(PayDeductibles.isValidTwoDecimalNumber("300")); // exactly 3 numbers
    assertTrue(PayDeductibles.isValidTwoDecimalNumber("534.00")); //with 2 decimal places
    assertTrue(PayDeductibles.isValidTwoDecimalNumber("124293812033123.00")); // long pay deductibles
  }
}
