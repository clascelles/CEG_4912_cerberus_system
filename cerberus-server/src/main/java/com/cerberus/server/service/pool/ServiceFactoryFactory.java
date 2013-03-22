package com.cerberus.server.service.pool;

import org.apache.commons.pool.BasePoolableObjectFactory;

public class ServiceFactoryFactory extends BasePoolableObjectFactory<ServiceFactory> {

	@Override
	public ServiceFactory makeObject() throws Exception {
		return new ServiceFactory();
	}

}
