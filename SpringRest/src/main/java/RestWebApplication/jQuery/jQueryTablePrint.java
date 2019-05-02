package RestWebApplication.jQuery;

import RestWebApplication.Controller.AppController;

public class jQueryTablePrint {
    public static void printTable(){
        StringBuffer strbuffer = new StringBuffer();
        strbuffer.append("<table id=\"booksTable\"> " +
                "<thead>\n" +
                " <tr>\n" +
                "<th>Id</th>\n" +
                "<th>Name</th>\n" +
                "<th>Author</th>\n" +
                "<th>Publisher</th>\n" +
                "<th>Pub. Date</th>\n" +
                "</tr>\n" +
                "</thead> " +
                "</table>");

        AppController.changeLine(strbuffer);
    }
}
