package ce204_hw3_lib_controller;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Cut {
	public void Cut(String string) {
		// Create a string from the input parameter
        String myString = string;
     // Create a StringSelection object with the string to be cut
        StringSelection selection = new StringSelection(myString);
        // Get the system clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // Set the contents of the clipboard to the StringSelection
        clipboard.setContents(selection, null);
    }

}
