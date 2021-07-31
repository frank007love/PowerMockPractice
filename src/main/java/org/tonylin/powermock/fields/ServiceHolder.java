package org.tonylin.powermock.fields;

import java.util.HashSet;
import java.util.Set;

public class ServiceHolder {

	private final Set<Object> services = new HashSet<Object>();

	public void addService(Object service) {
		services.add(service);
	}

	public void removeService(Object service) {
		services.remove(service);
	}
}