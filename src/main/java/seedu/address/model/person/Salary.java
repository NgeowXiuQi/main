package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Salary class to store the necessary information about a salary.
 */

public class Salary {


    public static final String MESSAGE_SALARY_CONSTRAINTS =
            "Salary should only contain integers with no spaces or commas";
    public static final String MESSAGE_OTHOUR_CONSTRAINTS =
        "Overtime hours should only contain numbers up to two decimal places "
            + "with no spaces or commas. Decimal places allowed";
    public static final String MESSAGE_OTRATE_CONSTRAINTS =
        "Overtime rate should only contain numbers up to two decimal places "
            + "with no spaces or commas. Decimal places allowed";
    public static final String MESSAGE_DEDUCTIONS_CONSTRAINTS =
        "Deductions should only contain numbers up to two decimal places "
            + "with no spaces or commas. Decimal places allowed";
    public static final String SALARY_VALIDATION_REGEX = "^[0-9]+$";
    public static final String TWO_DECIMAL_DIGITS_VALIDATION_REGEX = "^\\d+(\\.\\d{1,2})?$";

    public final double salary;
    private double overTimeHour;
    private double overTimeRate;
    private double payDeductions;

    public Salary(String value) {
        requireNonNull(value);
        checkArgument(isValidSalary(value), MESSAGE_SALARY_CONSTRAINTS);
        salary = Double.parseDouble(value);
        overTimeHour = 0;
        overTimeRate = 0;
        payDeductions = 0;
    }

    public Salary(String value, String otHours, String otRate, String deductions) {
        requireNonNull(value);
        requireNonNull(otHours);
        requireNonNull(otRate);
        requireNonNull(deductions);

        checkArgument(isValidSalary(value), MESSAGE_SALARY_CONSTRAINTS);
        checkArgument(isValidTwoDecimalNumber(value), MESSAGE_OTHOUR_CONSTRAINTS);
        checkArgument(isValidTwoDecimalNumber(value), MESSAGE_OTRATE_CONSTRAINTS);
        checkArgument(isValidTwoDecimalNumber(value), MESSAGE_DEDUCTIONS_CONSTRAINTS);

        salary = Double.parseDouble(value);
        overTimeHour = Double.parseDouble(otHours);
        overTimeRate = Double.parseDouble(otRate);
        payDeductions = Double.parseDouble(deductions);
    }

    public static boolean isValidSalary(String test) {
        return test.matches(SALARY_VALIDATION_REGEX);
    }

    public static boolean isValidTwoDecimalNumber(String test) {
        return test.matches(TWO_DECIMAL_DIGITS_VALIDATION_REGEX);
    }

    public void setOverTimeHour(double hours) {
        overTimeHour = hours;
    }

    public void setOverTimeRate(double rate) {
        overTimeRate = rate;
    }

    public void setPayDeductions(double deduction) {
        payDeductions = deduction;
    }

    public double getSalary() {
        return salary + (overTimeHour * overTimeRate) - payDeductions;
    }

    public double getOverTimeHour() {
        return overTimeHour;
    }

    public double getOverTimeRate() {
        return overTimeRate;
    }

    public double getPayDeductions() {
        return payDeductions;
    }

    @Override
    public boolean equals(Object o) {

        Salary s = (Salary) o;

        if (this.getSalary() == s.getSalary()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(salary) + " OT Hours: " + getOverTimeHour()
            + " OT Rate: " + getOverTimeRate() + " Pay Deductions: " + getPayDeductions();
    }

}
