package requesthandler;

import java.io.IOException;
import java.util.HashMap;

import context.IContext;
import model.account.AccountType;
import service.IAggregate;

public class AddStatisticHandler extends RequestHandlerBase {
	HashMap<String, IAggregate> m_aggregateMap;
	public AddStatisticHandler(
			IAggregate accountService,
			IAggregate storeService,
			IAggregate productService,
			IAggregate orderService,
			IAggregate brandService) {
		
		m_aggregateMap = new HashMap<String, IAggregate>();
		m_aggregateMap.put("accounts", accountService);
		m_aggregateMap.put("stores", storeService);
		m_aggregateMap.put("products", productService);
		m_aggregateMap.put("orders", orderService);
		m_aggregateMap.put("brands", brandService);
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
