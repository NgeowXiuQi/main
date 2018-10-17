package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Salary class to store the necessary information about a salary.
 */

public class Salary {


    public static final String MESSAGE_SALARY_CONSTRAINTS =
            "Salary should only contain integers with no spaces or commas";

    public static final String SALARY_VALIDATION_REGEX = "^([0-9]+.[0-9]{1,2})|0$";

    public final String salary;

    public Salary(String value) {
        requireNonNull(value);
        checkArgument(isValidSalary(value), MESSAGE_SALARY_CONSTRAINTS);
        salary = value;
    }

    public static boolean isValidSalary(String test) {
        return test.matches(SALARY_VALIDATION_REGEX);
    }

    public String getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof Salary) {
            Salary s = (Salary) o;

            if (this.getSalary().equals(s.getSalary())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return salary;
    }

}
