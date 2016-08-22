/**
 * 
 */
package org.anveshgadde.sql;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * @author anveshg
 *
 */
public class ClipboardTextTransfer implements ClipboardOwner {

	public static void main(String... aArguments) {
		ClipboardTextTransfer textTransfer = new ClipboardTextTransfer();

		System.out.println("Clipboard contains: " + textTransfer.getClipboardContents());

		textTransfer.setClipboardContents("display, has, changed");
		System.out.println("Clipboard contains: " + textTransfer.getClipboardContents());

	}

	@Override
	public void lostOwnership(Clipboard aClipboard, Transferable aContents) {
		// TODO Auto-generated method stub

	}

	private void setClipboardContents(String astring) {
		// TODO Auto-generated method stub

		StringSelection stringSelection = new StringSelection(toString());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, this);

	}

	public String getClipboardContents() {
		// TODO Auto-generated method stub

		String result = "";

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		Transferable contents = clipboard.getContents(null);

		boolean hasTransferableText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);

		if (hasTransferableText) {
			try {
				result = (String) contents.getTransferData(DataFlavor.stringFlavor);
			} catch (UnsupportedFlavorException | IOException ex) {
				// TODO Auto-generated catch block
				System.out.println("IOException is: " + ex);
				System.out.println("--------");
				System.out.println("\n");
				ex.printStackTrace();
			}
		}

		return result;
	}

}
