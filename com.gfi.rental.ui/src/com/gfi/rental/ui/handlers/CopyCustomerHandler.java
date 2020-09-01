
package com.gfi.rental.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;

public class CopyCustomerHandler {

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) Customer c, Display display) {
		Clipboard clipboard = new Clipboard(display);
		String textData = c.getDisplayName();
		String rtfData = "{\\rtf1\\b\\i " +textData+"}";
		TextTransfer textTransfer = TextTransfer.getInstance();
		RTFTransfer rtfTransfer = RTFTransfer.getInstance();
		Transfer[] transfers = new Transfer[] { textTransfer, rtfTransfer };
		Object[] data = new Object[] { textData, rtfData };
		clipboard.setContents(data, transfers);
		clipboard.dispose();

	}

	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) Object o) {

		return o instanceof Customer;
	}

}