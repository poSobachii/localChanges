package RSAencryption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class tokenObjectFormat {

    @JsonProperty("urn:oid:2.5.4.42")
    private String name;
    @JsonProperty("urn:oid:2.5.4.4")
    private String surname;
    @JsonProperty("urn:oid:1.2.246.575.1.14")
    private String firstNames;
    @JsonProperty("urn:oid:1.2.246.575.1.15")
    private String gender;
    @JsonProperty("urn:oid:1.3.6.1.5.5.7.9.1")
    private String dateOfBirth;
    @JsonProperty("urn:oid:1.3.6.1.5.5.7.9.2")
    private String cityOfBirth;
    @JsonProperty("urn:oid:1.2.246.575.1.16")
    private Map<String, String> adress;
    @JsonProperty("http://eidas.europa.eu/attributes/naturalperson/PersonIdentifier")
    private String finnishIdentifier;
    @JsonProperty("urn:oid:2.5.4.10")
    private String associationName;
    @JsonProperty("urn:oid:1.2.246.22")
    private String finnishHetuCode;
    @JsonProperty("urn:oid:1.2.246.21")
    private String finnishSatuCode;

    @JsonProperty("sub")
    private String subject;
    @JsonProperty("amr")
    private String authenticationMethod;
    @JsonProperty("client_id")
    private String clientId;
    @JsonProperty("aud")
    private String audience;
    @JsonProperty("iss")
    private String tokenIssuer;

    @JsonProperty("jti")
    private String tokenIdentifier;
    @JsonProperty("nonce")
    private String nonce;
    @JsonProperty("auth_time")
    private Long authenticationTime;
    @JsonProperty("iat")
    private Long tokenReleaseTime;
    @JsonProperty("exp")
    private Long expirationTime;
    @JsonProperty("nbf")
    private Long bestBefore;

    public tokenObjectFormat(){

    }

    public tokenObjectFormat(String subject, String dateOfBirth, String cityOfBirth, String authenticationMethod,
                             String tokenIssuer, String clientId, Map<String, String> adress, String gender,
                             Long authenticationTime, String surname, Long expirationTime, String firstName,
                             Long tokenReleaseTime, String tokenIdentifier, String finnishHetuCode,
                             String finnishSatuCode, String name, String nonce, String finnishIdentifier,
                             String audience, Long bestBefore, String associationName) {
        this.subject = subject;
        this.dateOfBirth = dateOfBirth;
        this.cityOfBirth = cityOfBirth;
        this.authenticationMethod = authenticationMethod;
        this.tokenIssuer = tokenIssuer;
        this.clientId = clientId;
        this.adress = adress;
        this.gender = gender;
        this.authenticationTime = authenticationTime;
        this.surname = surname;
        this.expirationTime = expirationTime;
        this.firstNames = firstName;
        this.tokenReleaseTime = tokenReleaseTime;
        this.tokenIdentifier = tokenIdentifier;
        this.finnishHetuCode = finnishHetuCode;
        this.finnishSatuCode = finnishSatuCode;
        this.name = name;
        this.nonce = nonce;
        this.finnishIdentifier = finnishIdentifier;
        this.audience = audience;
        this.bestBefore = bestBefore;
        this.associationName = associationName;
    }

    public String getSubject() {
        return subject;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public String getAuthenticationMethod() {
        return authenticationMethod;
    }

    public String getTokenIssuer() {
        return tokenIssuer;
    }

    public String getClientId() {
        return clientId;
    }

    public Map<String, String> getAdress() {
        return adress;
    }

    public String getGender() {
        return gender;
    }

    public Long getAuthenticationTime() {
        return authenticationTime;
    }

    public String getSurname() {
        return surname;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public Long getTokenReleaseTime() {
        return tokenReleaseTime;
    }

    public String getTokenIdentifier() {
        return tokenIdentifier;
    }

    public String getFinnishHetuCode() {
        return finnishHetuCode;
    }

    public String getFinnishSatuCode() {
        return finnishSatuCode;
    }

    public String getName() {
        return name;
    }

    public String getNonce() {
        return nonce;
    }

    public String getFinnishIdentifier() {
        return finnishIdentifier;
    }

    public String getAudience() {
        return audience;
    }

    public Long getBestBefore() {
        return bestBefore;
    }

    public String getAssociationName() {
        return associationName;
    }
}





