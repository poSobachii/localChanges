package Uploading.dynamicJson;

public class AgreementObject {

    public String agreementId;
    public String externaldId;
    public String provider;
    public String panId;

    public AgreementObject(String agreementId, String externaldId, String provider, String panId) {
        this.agreementId = agreementId;
        this.externaldId = externaldId;
        this.provider = provider;
        this.panId = panId;
    }
}
