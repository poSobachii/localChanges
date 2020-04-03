import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ExtractExample {
    public static void main(String[] args) throws IOException {
//        simple();
//        extended();
        moreExtended();

    }

    static void simple() throws IOException {
        Document doc = Jsoup.connect("http://example.com").get();
        doc.select("p").forEach(System.out::println);
    }

    static void extended() throws IOException {
        String blogUrl = "http://example.com";

        Connection connection = Jsoup.connect(blogUrl);
        connection.userAgent("Mozilla");
        connection.timeout(5000);
        connection.cookie("cookiename", "val234");
        connection.cookie("cookiename", "val234");
        connection.referrer("http://google.com");
        connection.header("headersecurity", "xyz123");

//        Document doc = Jsoup.connect(blogUrl)
//                .userAgent("Mozilla")
//                .timeout(5000)
//                .cookie("cookiename", "val234")
//                .cookie("anothercookie", "ilovejsoup")
//                .referrer("http://google.com")
//                .header("headersecurity", "xyz123")
//                .get();

        Document doc = connection.get();
        doc.select("p").forEach(System.out::println);

    }

    static void moreExtended() throws IOException {
        String blogUrl = "https://spring.io/blog";
        Document doc = Jsoup.connect(blogUrl).get();

        Elements links = doc.select("a");
        Elements sections = doc.select("section");
        Elements logo = doc.select(".spring-logo--container");
        Elements pagination = doc.select("#pagination_control");
        Elements divsDescendant = doc.select("header div");
        Elements divsDirect = doc.select("header > div");
        System.out.println(divsDescendant);

    }
}
