package com.gfi.rental.ui;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class RentalUIActivator implements BundleActivator {

	private static BundleContext context;
	
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		RentalUIActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		RentalUIActivator.context = null;
	}
	

}
