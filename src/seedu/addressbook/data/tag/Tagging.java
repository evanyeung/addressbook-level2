package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * An association class that links a Person and Tag.
 * It is used to track the addition or deletion of a tag.
 */
public class Tagging {
    public static enum OPERATION_TYPE {ADD, DELETE};
    OPERATION_TYPE operation;
    Person person;
    Tag tag;

    public Tagging(OPERATION_TYPE operation, Person person, Tag tag) {
        this.operation = operation;
        this.person = person;
        this.tag = tag;
    }

    @Override
    public String toString() {
        String modifier = getOperationString(this.operation);
        return modifier + " " + this.person.getName() + " [" + this.tag + "]";
    }

    /**
     * Returns the string representation of an OPERATION_TYPE
     */
    private static String getOperationString(OPERATION_TYPE operation) {
        return operation == OPERATION_TYPE.ADD ? "+" : "-";
    }
}
