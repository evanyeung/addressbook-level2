package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public abstract class Contact {
    public final String value;
    private boolean isPrivate;

    /**
     * Validates given Contact info.
     *
     * @param value the information to be stored in the contact
     * @param isPrivate whether the information should be private or not
     * @param validationRegex a regex to check if the given value is valid
     * @param messageContraints the message to show if the given value was not valid
     * @throws IllegalValueException if given contact string is invalid.
     */
    public Contact(String value, boolean isPrivate,
            String validationRegex, String messageConstraints) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedValue = value.trim();
        if (!isValidContact(trimmedValue, validationRegex)) {
            throw new IllegalValueException(messageConstraints);
        }
        this.value = trimmedValue;
    }

    /**
     * Checks if a given string is a valid person contact info.
     */
    public static boolean isValidContact(String test, String validationRegex) {
        return test.matches(validationRegex);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
