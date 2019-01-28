package x025.SpringBasicsLessons.SpringBasicsLesson121.loggers;

public abstract class AbstractLogger implements EventLogger {
    
    protected String name;

    @Override
    public String getName() {
        return name;
    }

    protected abstract void setName(String name);
}
