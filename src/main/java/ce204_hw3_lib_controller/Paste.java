package ce204_hw3_lib_controller;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Paste {
    public void pasteString(String text) throws Exception {
        // Get the system clipboard
        Clipboard clp = Toolkit.getDefaultToolkit().getSystemClipboard();

        // Create a StringSelection object with the specified text to be pasted
        StringSelection sel = new StringSelection(text);

        // Set the contents of the clipboard to the StringSelection
        clp.setContents(sel, null);

        // Create a Robot object to simulate key events
        Robot robot = new Robot();

        // Simulate pressing and releasing the Control key
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
}
