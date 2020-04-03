import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class SomeRealShit {


    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.olybet.lv/sports?competition=1732&game=15952519&region=50002&type=0&sport=2&").get();
//        doc.select(".aic-hdp-row").forEach(System.out::println);
        System.out.println(doc);
    }
}
