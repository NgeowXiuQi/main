package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.OtHour;
import seedu.address.model.person.OtRate;
import seedu.address.model.person.PayDeductibles;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Salary;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "alice@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_SALARY = "0";
    public static final String DEFAULT_OTHOUR = "0";
    public static final String DEFAULT_OTRATE = "0";
    public static final String DEFAULT_DEDUCTIBLES = "0";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Salary salary;
    private OtHour otHour;
    private OtRate otRate;
    private PayDeductibles deductibles;
    private Set<Tag> tags;

    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        salary = new Salary(DEFAULT_SALARY);
        otHour = new OtHour(DEFAULT_OTHOUR);
        otRate = new OtRate(DEFAULT_OTRATE);
        deductibles = new PayDeductibles(DEFAULT_DEDUCTIBLES);
        tags = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        salary = personToCopy.getSalary();
        otHour = personToCopy.getOtHours();
        otRate = personToCopy.getOtRate();
        deductibles = personToCopy.getPayDeductions();
        tags = new HashSet<>(personToCopy.getTags());
    }

    /**
     * Sets the (@code deductibles) of the (@code Person) that we are building.
     */

    public PersonBuilder withPayDeductibles(String deductibles) {
        this.deductibles = new PayDeductibles(deductibles);
        return this;
    }

    /**
     * Sets the (@code otRate) of the (@code Person) that we are building.
     */

    public PersonBuilder withOtRate(String otRate) {
        this.otRate = new OtRate(otRate);
        return this;
    }

    /**
     * Sets the (@code otHour) of the (@code Person) that we are building.
     */

    public PersonBuilder withOtHour(String otHour) {
        this.otHour = new OtHour(otHour);
        return this;
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the (@code Salary) of the (@code Person) that we are building.
     * @param salary
     */
    public PersonBuilder withSalary(String salary) {
        this.salary = new Salary(salary);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Builds a new person based on the current one.
     */

    public Person build() {
        Person newPerson = new Person(name, phone, email, address,
          salary, otHour, otRate, deductibles,
          tags);
        return newPerson;
    }

}
