package com.cerberus.service.pool;

import org.apache.commons.pool.impl.StackObjectPool;

public class ServiceFactoryPool {

	private static StackObjectPool<ServiceFactory> serviceFactoryPool = 
			new StackObjectPool<ServiceFactory>(new ServiceFactoryFactory(), 100, 5);

	public static StackObjectPool<ServiceFactory> getServiceFactoryPool() {
		return serviceFactoryPool;
	}
	
	public static ServiceFactory borrowServiceFactory() throws Throwable{
		return serviceFactoryPool.borrowObject();
	}
	
	public static void returnServiceFactory(ServiceFactory serviceFactory) throws Throwable{
		serviceFactoryPool.returnObject(serviceFactory);
	}
	
}
