package x030.EncodingHashing;

import org.glassfish.jersey.uri.UriComponent;

import javax.ws.rs.core.UriBuilder;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;

public class UriBuilderExample {

    public static URI actionLinkURL;
    public static void main(String[] args) throws UnsupportedEncodingException {
//        getUri();
        setUri();
        System.out.println("Uri is : " + actionLinkURL);
    }

    public static void getUri(){
        actionLinkURL = UriBuilder.fromUri("www.google.com")
                .queryParam("q", "dog")
                .queryParam("oq", "dog")
                .queryParam("aqs", "chrome..69i57j69i61j69i60l2j0j69i65.289j0j8")
                .queryParam("sourceid", "chrome")
                .queryParam("ie", "UTF-8")
                .build();
    }

    public static void setUri() throws UnsupportedEncodingException {
        HashMap<String, String> values = new HashMap<>();
        values.put("scope", "openid+ftn_hetu+ftn_satu+ftn_personidentifier");
        String scope = "openid+ftn_hetu+ftn_satu+ftn_personidentifier";
        actionLinkURL = UriBuilder.fromUri("https://localhost:8080")
                .queryParam("client_id", "NEIDDEMO")
//                .queryParam("response_type", "code")
//                .queryParam("scope1", "{value}")
                .queryParam("scope1", "%AD")
                .queryParam("scope2", UriComponent.encode("%AD", UriComponent.Type.QUERY_PARAM_SPACE_ENCODED))
//                .queryParam("scope2", UriComponent.encode("openid+ftn_hetu+ftn_satu+ftn_personidentifier", UriComponent.Type.QUERY_PARAM))
//                .fragment("&scope=" + scope)
//                .queryParam("redirect_uri", "https://localhost:8080")
//                .queryParam("state", "929317387231232931232982387q387433274")
//                .queryParam("ui_locales", "lv_LV")
//                .queryParam("nonce", "09b721d6ecf735431479b8179cf62260a02dc44bc2ae75671d504d6470e082b6")
//                .queryParam("acr_values", "http%3A%2F%2Fftn.ficora.fi%2F2017%2Floatest2")
//                .path("&scope=openid+ftn_hetu+ftn_satu+ftn_personidentifier")
//                .matrixParam("scope", scope)
//                .segment("&scope=openid+ftn_hetu+ftn_satu+ftn_personidentifier")
//                .host(scope)
//                .replaceQuery("&scope=openid+ftn_hetu+ftn_satu+ftn_personidentifier")
//                .schemeSpecificPart("&scope=openid+ftn_hetu+ftn_satu+ftn_personidentifier")
//                .resolveTemplateFromEncoded("scope", scope)
//                .userInfo("&scope=openid+ftn_hetu+ftn_satu+ftn_personidentifier")
//                .uri("&scope=openid+ftn_hetu+ftn_satu+ftn_personidentifier")
//                .buildFromEncodedMap(values);
                .build();
//                .buildFromEncoded("%20");
//        actionLinkURL.normalize();
    }
}

