 
package com.gfi.rental.ui;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.osgi.service.event.Event;

public class RentalAddon {

	@Inject
	@Optional
	public void applicationStarted(
			@EventTopic(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE) Event event) {
		System.out.println("Demarrage de l'application");
	}
	
	@PostConstruct
	public void initialiseContext()
	
	{
		System.out.println("On passe dans l'Addon");
	}
}
