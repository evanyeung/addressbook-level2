package seedu.addressbook.data.person;

import java.util.ArrayList;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] addressParts = address.split(",");
        this.block = new Block(this.getElementElseDefault(addressParts, 0, "").trim());
        this.street = new Street(this.getElementElseDefault(addressParts, 1, "").trim());
        this.unit = new Unit(this.getElementElseDefault(addressParts, 2, "").trim());
        this.postalCode = new PostalCode(this.getElementElseDefault(addressParts, 3, "").trim());
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    /**
     * Returns the full address string
     */
    public String getAddress() {
        String[] addressParts = {
                this.block.toString(),
                this.street.toString(),
                this.unit.toString(),
                this.postalCode.toString()
        };

        ArrayList<String> address = new ArrayList<String>();
        for (int i = 0; i < addressParts.length; i++) {
            if (addressParts[i].trim() != "") {
                address.add(addressParts[i]);
            }
        }

        return String.join(", ", address);
    }

    @Override
    public String toString() {
        return this.getAddress();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.getAddress().equals(((Address) other).getAddress())); // state check
    }

    @Override
    public int hashCode() {
        return this.getAddress().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    /**
     * A utility function to get the element of an array if it exists. Otherwise, returns the default
     * @param arr the array that the element may be in
     * @param index the index of the element to return
     * @param defaultValue the value to return if the element does not exist
     * @return the element at the given index of the given array if it exists. Otherwise, the given default value
     */
    private String getElementElseDefault(String[] arr, int index, String defaultValue) {
        if (arr.length <= index) {
            return defaultValue;
        }
        return arr[index];
    }
}

class Block {
    private final String value;

    public Block (String block) {
        this.value = block;
    }

    @Override
    public String toString() {
        return value;
    }
}

class Street {
    private final String value;

    public Street (String street) {
        this.value = street;
    }

    @Override
    public String toString() {
        return value;
    }
}

class Unit {
    private final String value;

    public Unit (String unit) {
        this.value = unit;
    }

    @Override
    public String toString() {
        return value;
    }
}

class PostalCode {
    private final String value;

    public PostalCode (String postalCode) {
        this.value = postalCode;
    }

    @Override
    public String toString() {
        return value;
    }
}