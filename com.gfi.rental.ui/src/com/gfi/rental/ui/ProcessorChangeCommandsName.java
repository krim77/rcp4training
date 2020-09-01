package com.gfi.rental.ui;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MCommand;

public class ProcessorChangeCommandsName {

	
		
		@Execute
		public void changeNames(MApplication appli) {
			for (MCommand c : appli.getCommands()) {
				c.setCommandName("ZZZ - "+c.getCommandName());
			}
			
	
	}

}
