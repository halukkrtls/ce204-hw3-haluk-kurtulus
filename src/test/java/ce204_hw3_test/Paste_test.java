package ce204_hw3_test;
import ce204_hw3_lib_controller.Paste;
import static org.junit.Assert.*;
import java.awt.*;
import org.junit.Test;


	import java.awt.datatransfer.*;
	import java.awt.event.KeyEvent;

	import static org.junit.Assert.assertEquals;

	public class Paste_test {

	    @Test
	    public void testPasteString() {
	        Paste paste = new Paste();
	        String originalString = "Hello, World!";

	        try {
	            paste.pasteString(originalString);

	           
	            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	            Transferable contents = clipboard.getContents(null);
	            String clipboardContent = (String) contents.getTransferData(DataFlavor.stringFlavor);

	        
	            Robot robot = new Robot();
	            robot.keyPress(KeyEvent.VK_CONTROL);
	            robot.keyPress(KeyEvent.VK_V);
	            robot.keyRelease(KeyEvent.VK_V);
	            robot.keyRelease(KeyEvent.VK_CONTROL);

	         
	            String updatedClipboardContent = (String) clipboard.getData(DataFlavor.stringFlavor);

	            assertEquals(originalString, clipboardContent);
	            assertEquals(originalString, updatedClipboardContent);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Test
	    public void testPasteString2() throws Exception {
	        // Create a test string
	        String testString = "Hello, world!";

	        // Create an instance of the Paste class
	        Paste paste = new Paste();

	        // Call the pasteString method with the test string
	        paste.pasteString(testString);

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

	    @Test
	    public void testPasteString3() throws Exception {
	        // Create a test string
	        String testString = "Hello, world!";

	        // Create an instance of the Paste class
	        Paste paste = new Paste();

	        // Call the pasteString method with the test string
	        paste.pasteString(testString);

	        // Simulate pressing and releasing the Control key and the V key to paste the text
	        Robot robot = new Robot();
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);

	        // Get the contents of the system clipboard
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        DataFlavor flavor = DataFlavor.stringFlavor;
	        String clipboardContent = (String) clipboard.getData(flavor);

	        // Check if the clipboard content matches the test string
	        assertEquals(testString, clipboardContent);
	    }
	}
	
	

