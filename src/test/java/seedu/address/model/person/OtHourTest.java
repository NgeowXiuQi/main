package seedu.address.model.person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.address.testutil.Assert;

public class OtHourTest {
  @Test
  public void constructor_null_throwsNullPointerException() {
    Assert.assertThrows(NullPointerException.class, () -> new OtHour(null));
  }

  @Test
  public void constructor_invalidOtHour_throwsIllegalArgumentException() {
    String invalidHours = "";
    Assert.assertThrows(IllegalArgumentException.class, () -> new OtHour(invalidHours));
  }

  @Test
  public void isValidHours() {
    // null OT hour
    Assert.assertThrows(NullPointerException.class, () -> OtHour.isValidTwoDecimalNumber(null));

    // invalid OT hours
    assertFalse(OtHour.isValidTwoDecimalNumber("")); // empty string
    assertFalse(OtHour.isValidTwoDecimalNumber(" ")); // spaces only
    assertFalse(OtHour.isValidTwoDecimalNumber("hours")); // non-numeric
    assertFalse(OtHour.isValidTwoDecimalNumber("49w0j4")); // alphabets within digits
    assertFalse(OtHour.isValidTwoDecimalNumber("2500 938")); // spaces within digits

    // valid OT hours
    assertTrue(OtHour.isValidTwoDecimalNumber("300")); // exactly 3 numbers
    assertTrue(OtHour.isValidTwoDecimalNumber("93121534.00")); //with 2 decimal places
    assertTrue(OtHour.isValidTwoDecimalNumber("124293842033123.00")); // long hours
  }
}
