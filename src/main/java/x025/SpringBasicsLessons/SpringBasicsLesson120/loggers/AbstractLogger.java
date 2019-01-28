package x025.SpringBasicsLessons.SpringBasicsLesson120.loggers;

public abstract class AbstractLogger implements EventLogger {
    
    private String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
