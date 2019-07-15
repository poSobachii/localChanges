package JsonReader;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KeyValues {

    @JsonProperty("kty")
    private String keyType;
    @JsonProperty("e")
    private String keyExponent;
    @JsonProperty("n")
    private String keyModules;
    @JsonProperty("kid")
    private String keyId;

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getKeyExponent() {
        return keyExponent;
    }

    public void setKeyExponent(String keyExponent) {
        this.keyExponent = keyExponent;
    }

    public String getKeyModules() {
        return keyModules;
    }

    public void setKeyModules(String keyModules) {
        this.keyModules = keyModules;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }
}
