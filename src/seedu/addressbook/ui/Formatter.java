package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;

import java.util.ArrayList;
import java.util.List;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * A class for formatting text
 */
public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
    
    /** The prompt shown to the user */
    private static final String USER_PROMPT = LINE_PREFIX + "Enter command: ";

    /** Adds the line prefix to the message */
    public static String addLinePrefix(String message) {
        return LINE_PREFIX + message;
    }

    /** Formats a line for normal output */
    public static String formatSingleLine(String message) {
        return addLinePrefix(message.replace("\n", LS + LINE_PREFIX));
    }

    /** Returns the prompt to show to the user */
    public static String getUserPrompt() {
        return USER_PROMPT;
    }

    /** Formats the echo of the user's command */
    public static String formatEchoOfUserCommand(String command) {
        return "[Command entered:" + command + "]";
    }

    /**
     * Shows a list of persons to the user, formatted as an indexed list.
     * Private contact details are hidden.
     */
    public static String formatPersonListView(List<? extends ReadOnlyPerson> persons) {
        final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
        return getIndexedListForViewing(formattedPersons);
    }

    /** Formats a list of strings as a viewable indexed list. */
    private static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    public static String formatUsingStorageFileMessage(String filename) {
        return String.format(MESSAGE_USING_STORAGE_FILE, filename);
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
