package JsonExample.Controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Key {

//    @JsonProperty("one")
    private String kty;

    private String e;

    private String n;

//    @JsonProperty("four")
    private String kid;

    public Key(String kty, String e, String n, String kid){
        this.kty = kty;
        this.e = e;
        this.n = n;
        this.kid = kid;
    }

    public String getKty() {
        return kty;
    }

    public void setKty(String kty) {
        this.kty = kty;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }
}
