package service;

import service.account.AccountService;
import service.account.IAccountService;
import service.brand.BrandService;
import service.brand.IBrandService;
import service.order.IOrderService;
import service.order.OrderService;
import service.product.IProductService;
import service.product.ProductService;
import service.statistics.IStatisticsService;
import service.statistics.StatisticsService;
import service.store.IStoreService;
import service.store.StoreService;

public class ServiceRepo {
	static private IAccountService m_accountService;
	static private IBrandService m_brandService;
	static private IOrderService m_orderService;
	static private IProductService m_productService;
	static private IStatisticsService m_statisticsService;
	static private IStoreService m_storeService;
	
	private ServiceRepo() {}
	
	static public IAccountService getAccountService()
	{
		if(m_accountService == null)
			m_accountService = new AccountService();
		return m_accountService;
	}
	
	static public IBrandService getBrandService()
	{
		if(m_brandService == null)
			m_brandService = new BrandService();
		return m_brandService;
	}
	
	static public IOrderService getOrderService()
	{
		if(m_orderService == null)
			m_orderService = new OrderService(getStoreService());
		return m_orderService;
	}
	
	static public IProductService getProductService()
	{
		if(m_productService == null)
			m_productService = new ProductService();
		return m_productService;
	}
	
	static public IStatisticsService getStatisticsService()
	{
		if(m_statisticsService == null)
			m_statisticsService = new StatisticsService();
		return m_statisticsService;
	}
	
	
	static public IStoreService getStoreService()
	{
		if(m_storeService == null)
			m_storeService = new StoreService();
		return m_storeService;
	}
}
