package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlElement;

import seedu.address.commons.exceptions.IllegalValueException;
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

/**
 * JAXB-friendly version of the Person.
 */
public class XmlAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private String phone;
    @XmlElement(required = true)
    private String email;
    @XmlElement(required = true)
    private String address;
    @XmlElement(required = true)
    private String salary;
    @XmlElement(required = true)
    private String otHours;
    @XmlElement(required = true)
    private String otRate;
    @XmlElement(required = true)
    private String payDeductibles;


    @XmlElement
    private List<XmlAdaptedTag> tagged = new ArrayList<>();

    /**
     * Constructs an XmlAdaptedPerson.
     * This is the no-arg constructor that is required by JAXB.
     */
    public XmlAdaptedPerson() {}

    /**
     * Constructs an {@code XmlAdaptedPerson} with the given person details.
     */
    public XmlAdaptedPerson(String name, String phone, String email, String address, String salary, String otHours,
                            String otRate, String deductibles, List<XmlAdaptedTag> tagged) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.otHours = otHours;
        this.otRate = otRate;
        this.payDeductibles = deductibles;
        if (tagged != null) {
            this.tagged = new ArrayList<>(tagged);
        }
    }

    /**
     * Converts a given Person into this class for JAXB use.
     *
     * @param source future changes to this will not affect the created XmlAdaptedPerson
     */
    public XmlAdaptedPerson(Person source) {
        name = source.getName().fullName;
        phone = source.getPhone().value;
        email = source.getEmail().value;
        address = source.getAddress().value;
        salary = source.getSalary().salary;
        otHours = source.getOtHours().overTimeHour;
        otRate = source.getOtRate().overTimeRate;
        payDeductibles = source.getPayDeductions().payDeductibles;
        tagged = source.getTags().stream()
                .map(XmlAdaptedTag::new)
                .collect(Collectors.toList());
    }

    /**
     * Converts this jaxb-friendly adapted person object into the model's Person object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person
     */
    public Person toModelType() throws IllegalValueException {
        final List<Tag> personTags = new ArrayList<>();
        for (XmlAdaptedTag tag : tagged) {
            personTags.add(tag.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (address == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        }
        if (!Address.isValidAddress(address)) {
            throw new IllegalValueException(Address.MESSAGE_CONSTRAINTS);
        }
        final Address modelAddress = new Address(address);

        if (salary == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Salary.class.getSimpleName()));
        }
        if (!Salary.isValidSalary(salary)) {
            throw new IllegalValueException(Salary.MESSAGE_SALARY_CONSTRAINTS);
        }
        final Salary modelSalary = new Salary(salary);

        if (otHours == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, OtHour.class.getSimpleName()));
        }
        if (!OtHour.isValidTwoDecimalNumber(otHours)) {
            throw new IllegalValueException(OtHour.MESSAGE_OTHOUR_CONSTRAINTS);
        }
        final OtHour modelHours = new OtHour(otHours);

        if (otRate == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, OtRate.class.getSimpleName()));
        }
        if (!OtHour.isValidTwoDecimalNumber(otRate)) {
            throw new IllegalValueException(OtRate.MESSAGE_OTRATE_CONSTRAINTS);
        }
        final OtRate modelRate = new OtRate(otRate);

        if (payDeductibles == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
              PayDeductibles.class.getSimpleName()));
        }
        if (!PayDeductibles.isValidTwoDecimalNumber(payDeductibles)) {
            throw new IllegalValueException(PayDeductibles.MESSAGE_DEDUCTIONS_CONSTRAINTS);
        }
        final PayDeductibles modelDeductibles = new PayDeductibles(payDeductibles);

        final Set<Tag> modelTags = new HashSet<>(personTags);
        return new Person(modelName, modelPhone, modelEmail, modelAddress, modelSalary, modelHours,
          modelRate, modelDeductibles, modelTags);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof XmlAdaptedPerson)) {
            return false;
        }

        XmlAdaptedPerson otherPerson = (XmlAdaptedPerson) other;
        return Objects.equals(name, otherPerson.name)
                && Objects.equals(phone, otherPerson.phone)
                && Objects.equals(email, otherPerson.email)
                && Objects.equals(address, otherPerson.address)
                && Objects.equals(salary, otherPerson.salary)
                && Objects.equals(otHours, otherPerson.otHours)
                && Objects.equals(otRate, otherPerson.otRate)
                && Objects.equals(payDeductibles, otherPerson.payDeductibles)
                && tagged.equals(otherPerson.tagged);
    }
}
