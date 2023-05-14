package ce204_hw3_test;

import org.junit.Test;
import ce204_hw3_lib_controller.Cut;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class Cut_test {

    @Test
    public void testCut() {
        String testString = "Hello, World!";
        Cut cut = new Cut();
        cut.Cut(testString);

     
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            String clipboardContents = (String) clipboard.getData(DataFlavor.stringFlavor);
            assertEquals(testString, clipboardContents);
        } catch (Exception e) {
          
            e.printStackTrace();
        }
    }
    @Test
	public void testCut2() {
		// Create a test string
		String testString = "Hello, world!";
		
		// Call the Cut method with the test string
		Cut cut = new Cut();
		cut.Cut(testString);
		
		// Get the contents of the system clipboard
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String clipboardContent = null;
		try {
			clipboardContent = (String) clipboard.getData(DataFlavor.stringFlavor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Assert that the clipboard contains the expected string
		assertEquals(testString, clipboardContent);
	}
    @Test
    public void testCut3() {
        // Create a test string
        String testString = "Hello, world!";

        // Create an instance of the Cut class
        Cut cut = new Cut();

        

        // Get the contents of the system clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor flavor = DataFlavor.stringFlavor;
        String clipboardContent = null;

        try {
            clipboardContent = (String) clipboard.getData(flavor);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Check if the clipboard content matches the test string
        assertEquals(testString, clipboardContent);
    }
}


