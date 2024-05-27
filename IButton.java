public interface IButton {

    Button whenPressed(Boolean button);
    Button and(Boolean button);
    Button or(Boolean button);
    void then(Runnable runnable);

}
