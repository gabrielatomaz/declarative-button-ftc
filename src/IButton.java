public interface IButton {

    Button whenPressed(boolean button);
    Button and(boolean button);
    Button or(boolean button);
    void then(Runnable runnable);

}
