package requesthandler;

import context.IContext;
import model.Store.IStore;
import service.store.IStoreService;
import service.store.StoreService;

import java.io.IOException;
import java.util.ArrayList;

public class AllStoresHandler extends RequestHandlerBase {

    private IStoreService m_storeservice;
    ArrayList<IStore> stores;

    public AllStoresHandler(IStoreService storeService){
        this.m_storeservice = storeService;
    }

    @Override
    public void handle(IContext ctx) throws IOException {
        System.out.println("Started Handling all Stores");
        stores = m_storeservice.getAllStoresArrayList();
        String htmlPage = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>All Stores</title>\n" +
                "\t<style type=\"text/css\">\n" +
                "\t\t\n" +
                "\t\t.form-box{\n" +
                "            padding: 1rem;\n" +
                "            clear: both;\n" +
                "            width: 100%;\n" +
                "            position: relative;\n" +
                "        }\n" +
                "\n" +
                "        .form-box label{\n" +
                "            font-size: 1rem;\n" +
                "            float: left;\n" +
                "            width: 120px;\n" +
                "            margin-right: 20px;\n" +
                "            margin-top: 5px;\n" +
                "            font-size: 1.1rem;\n" +
                "        }\n" +
                "\n" +
                "        .form-box1{\n" +
                "            padding: 1rem;\n" +
                "            clear: both;\n" +
                "            width: 100%;\n" +
                "            position: relative;\n" +
                "        }\n" +
                "\n" +
                "        .form-box1 label{\n" +
                "            font-size: 0.8rem;\n" +
                "            float: left;\n" +
                "            width: 120px;\n" +
                "            margin-right: 20px;\n" +
                "            margin-top: 5px;\n" +
                "            font-size: 1.1rem;\n" +
                "        }\n" +
                "\n" +
                "\t</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<div class=\"form-box\">\n" +
                "\t\t<label>Store Name</label>\t\n" +
                "\t</div>\n" +
                "\t<div class=\"form-box1\">\n" +
                "\t\t<a href=\"/store/_STORE_NAME_\"><label>_STORE_NAME_</label></a>\n" +
                "\t</div>\n";
        for(int i = 0; i < stores.size(); i++) {
            htmlPage += "\t<div class=\"form-box1\">\n" +
            "\t\t<a href=\"/store/" + stores.get(i).getName() +"\"><label>" + stores.get(i).getName() + "</label>" +
            "</a>\n\t</div>\n";
        }


        htmlPage += "</body>\n" +
                    "</html>";

        ctx.write(htmlPage.getBytes());

    }
}
