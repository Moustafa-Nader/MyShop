package requesthandler;

import context.IContext;
import model.Store.IStore;
import model.item.IItem;
import model.product.IProduct;
import service.product.IProductService;
import service.product.ProductService;
import service.store.IStoreService;

import java.io.IOException;
import java.util.ArrayList;

public class AddItemPageHandler extends RequestHandlerBase {

    private IProductService m_productservice;
    private IStoreService m_storeservice;
    private ArrayList<IProduct> m_products;

    public AddItemPageHandler(IProductService  productService, IStoreService storeService){
        this.m_productservice = productService;
        this.m_storeservice = storeService;
        this.m_products = productService.getAllProducts();
    }

    @Override
    public void handle(IContext ctx) throws IOException {
        System.out.println(ctx.getHttpExchange().getRequestMethod());
        System.out.println(ctx.getHttpExchange().getRequestURI());
        String[] uri = ctx.getHttpExchange().getRequestURI().toString().split("/");
        int storeID = -1;
        if(uri.length == 3)
            storeID = Integer.parseInt(uri[2]);
        IStore store = m_storeservice.getStoreByID(storeID);
        if (store == null)
            ctx.write("invalid Id".getBytes());
        else if(store.getOwnerid() != ctx.getUser().getID())
            ctx.write("Unauthorized".getBytes());
        else if(store.isPending())
            ctx.write("Still pending".getBytes());
        else {
            String htmlPage = "";
            htmlPage += "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "\t<title>Add Item</title>\n" +
                    "\t<style type=\"text/css\">\n" +
                    "\t\t.form-box{\n" +
                    "            padding: 1rem;\n" +
                    "            clear: both;\n" +
                    "            width: 100%;\n" +
                    "            position: relative;\n" +
                    "        }\n" +
                    "        .form-box label{\n" +
                    "            font-size: 1rem;\n" +
                    "            float: left;\n" +
                    "            width: 120px;\n" +
                    "            margin-right: 20px;\n" +
                    "            margin-top: 5px;\n" +
                    "            font-size: 1.1rem;\n" +
                    "        }\n" +
                    "        .form-box input{\n" +
                    "            font-size: 1rem;\n" +
                    "            width: 300px;\n" +
                    "            padding: 0.25rem 1rem;\n" +
                    "        }\n" +
                    "        .form-box select{\n" +
                    "        \tcursor: pointer;\n" +
                    "            font-size: 1rem;\n" +
                    "            width: 335px;\n" +
                    "            padding: 0.25rem 1rem;\n" +
                    "        }\n" +
                    "        .form-box option{\n" +
                    "        \tcursor: pointer;\n" +
                    "            font-size: 1rem;\n" +
                    "            width: 300px;\n" +
                    "            padding: 0.25rem 1rem;\n" +
                    "        }\n" +
                    "        .form-box input[type=\"checkbox\"]{\n" +
                    "            font-size: 1rem;\n" +
                    "        }\n" +
                    "        .form-box button{\n" +
                    "            font-size: 1rem;\n" +
                    "            border: none;\n" +
                    "            padding: 0.25rem 2rem;\n" +
                    "            float: center;\n" +
                    "            margin-left: 10%;\n" +
                    "            color: white;\n" +
                    "            background-color: cornflowerblue;\n" +
                    "            cursor: pointer;\n" +
                    "        }\n" +
                    "\t</style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\t<form id=\"item-form\" action=\"/additemq/" + storeID + "\" method=\"get\">" +
                    "\t\t<div class=\"form-box\">\n" +
                    "\t\t\t<label for=\"m_product\">Select Product:</label>" +
                    "\t\t\t<select name=\"m_product\" id=\"m_product\">";

            for (IProduct product : m_products) {
                htmlPage += "\t\t\t\t<option value=\"" + product.getID() + "\">" + product.getName() + "</option>";
            }

            htmlPage += "\t\t\t</select>" +
                    "\t\t</div>" +
                    "\t\t<div class=\"form-box\">\n" +
                    "\t\t\t<label for=\"m_price\">Item Price: </label>\n" +
                    "\t\t\t<input type=\"number\" step=\"0.01\" name=\"m_price\" id=\"m_price\">\n" +
                    "\t\t</div>\n" +
                    "\t\t<div class=\"form-box\">\n" +
                    "\t\t\t<button id=\"submititem\" type=\"submit\">Add Item</button>\n" +
                    "\t\t</div>" +
                    "\t</form>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>";

            ctx.write(htmlPage.getBytes());

        }
    }
}
