import java.util.ArrayList;
import java.util.List;

public class Button implements IButton {

    private List<Boolean> buttonList;
    private boolean button;

    public Button() {
        this.button = false;
        this.buttonList = new ArrayList<>();
    }

    @Override
    public Button whenPressed(boolean button) {
        this.buttonList.add(button);
        this.button = button;
        return this;
    }

    @Override
    public Button and(boolean button) {
        this.buttonList.add(button);
        this.button = buttonList.stream().allMatch(Boolean::booleanValue);
        return this;
    }

    @Override
    public Button or(boolean button) {
        this.buttonList.add(button);
        this.button = buttonList.stream().anyMatch(Boolean::booleanValue);
        return this;
    }

    @Override
    public void then(Runnable runnable) {
        if (this.button) {
            runnable.run();
        }

        this.buttonList.clear();
        this.button = false;
    }

}
