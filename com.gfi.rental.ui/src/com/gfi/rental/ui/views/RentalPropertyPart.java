 
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
import org.eclipse.swt.widgets.Text;

public class RentalPropertyPart {
	private Label rentedObject;
	private Label customer;
	private Group grpDates;
	private Label startDtae;
	private Label endDate;

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
		
		grpDates = new Group(parent, SWT.NONE);
		grpDates.setText("Dates");
		grpDates.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel_1 = new Label(grpDates, SWT.NONE);
		lblNewLabel_1.setText("au : ");
		
		startDtae = new Label(grpDates, SWT.NONE);
		
		startDtae.setText("New Label");
		
		Label lblNewLabel = new Label(grpDates, SWT.NONE);
		
		lblNewLabel.setText("Du : ");
		
		endDate = new Label(grpDates, SWT.NONE);
		endDate.setText("New Label");
		setRental(RentalCoreActivator.getAgency().getRentals().get(0));
	
	}
	
	public void setRental(Rental r) {
		customer.setText(r.getCustomer().getDisplayName());
		rentedObject.setText(r.getRentedObject().getName());
	
		startDtae.setText(r.getStartDate().toString());
		endDate.setText(r.getEndDate().toString());
	}
}