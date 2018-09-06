package com.swt;

import org.eclipse.swt.*;
import org.eclipse.swt.browser.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet159 {
	public static void main(String[] args) {
		/* Relative links: use the HTML base tag */
		String html = "<html><head>" + "<base href=\"http://www.eclipse.org/swt/\" >" + "<title>HTML Test</title></head>"
				+ "<body><a href=\"faq.php\">local link</a></body></html>";

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		Browser browser;
		try {
			browser = new Browser(shell, SWT.NONE);
		} catch (SWTError e) {
			System.out.println("Could not instantiate Browser: " + e.getMessage());
			display.dispose();
			return;
		}
		browser.setText(html);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
