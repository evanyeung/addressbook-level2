package seedu.addressbook.data.person;

/**
 * Represents a Person's unit in their address
 * Guarantees: immutable
 */
class AddressUnit {
    private final String value;

    public AddressUnit (String unit) {
        this.value = unit;
    }

    @Override
    public String toString() {
        return value;
    }
}
