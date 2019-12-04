package Uploading.dynamicJson;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class StripeMapper {

    private Map<String, CustomerMapper> details = new LinkedHashMap<>();

    public Map<String, CustomerMapper> getDetails() {
        return details;
    }

    @JsonAnySetter
    public void setDetail(String key, CustomerMapper value) {
        details.put(key, value);
    }

}
