package x018.BootcampAplication;

public class Bootcamp {

    private String type; // Java, TestAutomation, DevOps, CRM

    private String startDate;

    private String endDate;

    private int participantCount = 25;

    private String participantName[] = new String[participantCount];

    public Bootcamp(String type, String startDate, String endDate) {
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(int participantCount) {
        this.participantCount = participantCount;
    }

    public String[] getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String[] participantName) {
        this.participantName = participantName;
    }

}
