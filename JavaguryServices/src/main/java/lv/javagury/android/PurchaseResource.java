package lv.javagury.android;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.common.base.Function;
import com.google.common.collect.Multimaps;

@Path("/purchases/{token}")
public class PurchaseResource {
	
	@GET
	@Produces(APPLICATION_JSON)
	public Map<String, Collection<Purchase>> getPurchaseLists(@PathParam("token") String token) {
		final List<Purchase> list = PurchaseDao.getPurchaseListByToken(token);
		
		return Multimaps.index(list, new Function<Purchase, String>() {
					@Override
					public String apply(Purchase purchase) {
						return purchase.getList();
					}
				}).asMap();
	}
	
	@POST
	@Consumes(APPLICATION_JSON)
	public void postPurchaseLists(@PathParam("token") String token, Map<String, List<Purchase>> map) {

	}
}