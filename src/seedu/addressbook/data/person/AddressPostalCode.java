package seedu.addressbook.data.person;

/**
 * Represents a Person's postal code in their address
 * Guarantees: immutable
 */
class AddressPostalCode {
    private final String value;

    public AddressPostalCode(String postalCode) {
        this.value = postalCode;
    }

    @Override
    public String toString() {
        return value;
    }
}
