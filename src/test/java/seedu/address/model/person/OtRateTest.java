package seedu.address.model.person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.address.testutil.Assert;

public class OtRateTest {
  @Test
  public void constructor_null_throwsNullPointerException() {
    Assert.assertThrows(NullPointerException.class, () -> new OtRate(null));
  }

  @Test
  public void constructor_invalidOtRate_throwsIllegalArgumentException() {
    String invalidRate = "";
    Assert.assertThrows(IllegalArgumentException.class, () -> new OtRate(invalidRate));
  }

  @Test
  public void isValidRate() {
    // null OT rate
    Assert.assertThrows(NullPointerException.class, () -> OtRate.isValidTwoDecimalNumber(null));

    // invalid OT rate
    assertFalse(OtRate.isValidTwoDecimalNumber("")); // empty string
    assertFalse(OtRate.isValidTwoDecimalNumber(" ")); // spaces only
    assertFalse(OtRate.isValidTwoDecimalNumber("rate")); // non-numeric
    assertFalse(OtRate.isValidTwoDecimalNumber("49w0j4")); // alphabets within digits
    assertFalse(OtRate.isValidTwoDecimalNumber("2500 938")); // spaces within digits

    // valid OT rate
    assertTrue(OtRate.isValidTwoDecimalNumber("300")); // exactly 3 numbers
    assertTrue(OtRate.isValidTwoDecimalNumber("534.00")); //with 2 decimal places
    assertTrue(OtRate.isValidTwoDecimalNumber("124293812033123.00")); // long OT rate
  }
}
