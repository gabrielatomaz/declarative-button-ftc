public class Subsystem implements ISubsystem {

    private String subsystemName;

    public Subsystem(String subsystemName) {
        this.subsystemName = subsystemName;
    }

    @Override
    public void init() {
        System.out.println(subsystemName + ": init");
    }

    @Override
    public void start() {
        System.out.println(subsystemName + ": start");
    }

    @Override
    public void execute() {
        System.out.println(subsystemName + ": execute");
    }

    @Override
    public void stop() {
        System.out.println(subsystemName + ": stop");
    }
}
