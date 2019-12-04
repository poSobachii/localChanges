package x031.changingCsvFiles;

public class ObjecWrapper {

    private int id;
    private String accountId;
    private String externalId;
    private String state;

    public ObjecWrapper(int id, String accountId, String externalId, String state) {
        this.id = id;
        this.accountId = accountId;
        this.externalId = externalId;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
