package ce204_hw3_lib_controller;
import ce204_hw3_lib_view.*;

public class Undo {
	GUI_Editor gui;
    public Undo(GUI_Editor gui) {
        // TODO Auto-generated constructor stub
        this.gui=gui;
    }
    public void undo() {
       gui.um.undo();
    }
}
