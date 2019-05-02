package myOnlineShop;

public class StringWriter {
    public static StringBuffer writer() {

        StringBuffer strbuff = new StringBuffer();
        String hwstr = "Hello my WEB STORE";

         strbuff.append("<h1> 	Hello word h1 &#160&#160&#160&#160            1 </h1>")
                .append("	Hello word h2 &#160 &#160 &#160 &#160 &#160 &#160 &#160 2 </br>")
                .append("space ? " + hwstr + " h3  3 </br>")
                .append("	Hello word h4          4 </br>")
                .append(hwstr + "</br>")
                 .append("<h2> we are continuing !!!! </h2>");

        return strbuff;
    }

}
