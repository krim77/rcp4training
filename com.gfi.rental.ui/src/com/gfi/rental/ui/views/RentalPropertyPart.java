 
package com.gfi.rental.ui.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import com.gfi.rental.core.RentalCoreActivator;
import com.opcoach.training.rental.Rental;

public class RentalPropertyPart {
	private Label rentedObject;
	private Label customer;

	@Inject
	public RentalPropertyPart() {
		
	}
	
	@PostConstruct
	public void createContent(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		Group infoGroup = new Group(parent, SWT.NONE);
		infoGroup.setLayout(new GridLayout(2,false));
		infoGroup.setText("Informations");
		rentedObject = new Label(infoGroup, SWT.NONE);
		GridData gd = new GridData();
		gd.horizontalSpan = 2;
		rentedObject.setLayoutData(gd);
		Label louea = new Label(infoGroup, SWT.NONE);
		louea.setText("Loué à : ");
		customer = new Label(infoGroup, SWT.NONE);
		setRental(RentalCoreActivator.getAgency().getRentals().get(0));
	
	}
	
	public void setRental(Rental r) {
		customer.setText(r.getCustomer().getDisplayName());
		rentedObject.setText(r.getRentedObject().getName());
	}
	
	
}