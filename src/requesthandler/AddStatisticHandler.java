package requesthandler;

import java.io.IOException;
import java.util.HashMap;

import context.IContext;
import model.account.AccountType;
import service.IAggregate;
import service.ServiceRepo;

public class AddStatisticHandler extends RequestHandlerBase {
	HashMap<String, IAggregate> m_aggregateMap;
	public AddStatisticHandler() {
		
		m_aggregateMap = new HashMap<String, IAggregate>();
		m_aggregateMap.put("accounts", (IAggregate) ServiceRepo.getAccountService());
		m_aggregateMap.put("stores", (IAggregate) ServiceRepo.getStoreService());
		m_aggregateMap.put("products", (IAggregate) ServiceRepo.getProductService());
		m_aggregateMap.put("orders", (IAggregate) ServiceRepo.getOrderService());
		m_aggregateMap.put("brands", (IAggregate) ServiceRepo.getBrandService());
	}
	
	@Override
    public void handle(IContext ctx) throws IOException {
		ctx.parse();
		if(ctx.getUser() == null || ctx.getUser().getType() != AccountType.ADMIN) {
			ctx.redirect("/home");
		} else {
			String entityName = ctx.getParam("m_entity");
			String funcName = ctx.getParam("m_func");
			IAggregate aggregate = m_aggregateMap.get(entityName);
			if(aggregate == null) {
				ctx.write("invalid entity".getBytes());
			} else {
				if(funcName.equals("count")) {
					ctx.write(("count " + aggregate.count()).getBytes());
				} else {
					ctx.write("invalid function".getBytes());
				}
			}
		}
	}
}
