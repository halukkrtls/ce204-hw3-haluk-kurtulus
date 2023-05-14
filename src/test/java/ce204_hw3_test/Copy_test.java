package ce204_hw3_test;

import org.junit.Test;
import ce204_hw3_lib_controller.Copy;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Copy_test {

    @Test
    public void testCopy() {
        String testString = "Hello, World!";
        Copy copy = new Copy();
        copy.copy(testString);

      
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            String clipboardContents = (String) clipboard.getData(DataFlavor.stringFlavor);
            assertEquals(testString, clipboardContents);
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
 
        @Test
        public void testCopy2() throws Exception {
            // Create an instance of the Copy class
            Copy copy = new Copy();

            // Define the string to be copied
            String inputString = "Hello, World!";

            // Call the copy method
            copy.copy(inputString);

            // Get the system clipboard
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            // Get the contents of the clipboard as a string
            String clipboardContents = (String) clipboard.getData(DataFlavor.stringFlavor);

            // Assert that the clipboard contents match the input string
            assertEquals(inputString, clipboardContents);
        }

        @Test
        public void testCopy3() throws Exception {
            // Create a test string to copy
            String testString = "Hello, world!";

            // Call the copy method of the Copy class
            Copy copyObject = new Copy();
            copyObject.copy(testString);

            // Get the contents of the system clipboard
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable clipboardContents = clipboard.getContents(null);

            // Assert that the clipboard contents match the test string
            assertTrue(clipboardContents.isDataFlavorSupported(DataFlavor.stringFlavor));
            String clipboardString = (String) clipboardContents.getTransferData(DataFlavor.stringFlavor);
            assertEquals(testString, clipboardString);
        }
        
}   


    