package ce204_hw3_lib_controller;
import ce204_hw3_lib_view.*;

public class Redo {
	GUI_Editor gui;
    public Redo(GUI_Editor gui) {
        // TODO Auto-generated constructor stub
        this.gui=gui;
    }
    public void redo() {
       gui.um.redo();
    }
}
