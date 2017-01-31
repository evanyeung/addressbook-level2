package seedu.addressbook.data.person;

/**
 * Represents a Person's block in their address
 * Guarantees: immutable
 */
class AddressBlock {
    private final String value;

    public AddressBlock (String block) {
        this.value = block;
    }

    @Override
    public String toString() {
        return value;
    }
}
