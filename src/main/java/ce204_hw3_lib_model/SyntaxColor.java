package ce204_hw3_lib_model;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

public class SyntaxColor {
	public void javaSyntax(RSyntaxTextArea text) {
        text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);

    }

    public void csSyntax(RSyntaxTextArea text) {
        text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CSHARP);

    }

    public void cppSyntax(RSyntaxTextArea text) {
        text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);

    }

}
