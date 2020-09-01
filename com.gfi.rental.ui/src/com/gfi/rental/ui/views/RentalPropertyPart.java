
package com.gfi.rental.ui.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;

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
	public void createContent(Composite parent, RentalAgency agency) {
		parent.setLayout(new GridLayout(1, false));
		Group infoGroup = new Group(parent, SWT.NONE);
		infoGroup.setLayout(new GridLayout(2, false));
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
		setRental(agency.getRentals().get(0));

	}

	public void setRental(Rental r) {
		if ( r != null && customer != null) {
		customer.setText(r.getCustomer().getDisplayName());
		rentedObject.setText(r.getRentedObject().getName());

		startDtae.setText(r.getStartDate().toString());
		endDate.setText(r.getEndDate().toString());
		}
	}

	@Inject
	@Optional
	public void receiveSelection(@Named(IServiceConstants.ACTIVE_SELECTION) Rental r) {
		setRental(r);
	}

	@Inject
	@Optional
	public void selectAll(@Named(IServiceConstants.ACTIVE_SELECTION) Object o) {
		if (o != null)
			System.out.println("j'ai recu un objet de type :  " + o.getClass().getName());

	}

	@Inject
	@Optional
	public void receiveE3select(@Named(IServiceConstants.ACTIVE_SELECTION) ITreeSelection iss) {
		if (iss == null || iss.isEmpty()) {
			return;
		}
		System.out.println("j'ai recu  en E3 un objet de type :  " + iss.getFirstElement().getClass().getName());
	}
}