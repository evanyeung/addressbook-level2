package seedu.addressbook.data.person;

/**
 * Represents a Person's street in their address
 * Guarantees: immutable
 */
class AddressStreet {
    private final String value;

    public AddressStreet (String street) {
        this.value = street;
    }

    @Override
    public String toString() {
        return value;
    }

}
