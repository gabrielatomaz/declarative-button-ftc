import java.util.ArrayList;
import java.util.List;

public class Button {

    private List<Boolean> buttonList;
    private boolean button;

    private Button() {
        this.button = false;
        this.buttonList = new ArrayList<>();
    }

    public static ButtonBuilder whenPressed(boolean button) {
        return new ButtonBuilder().whenPressed(button);
    }

    public static class ButtonBuilder {
        private Button buttonInstance;

        private ButtonBuilder() {
            buttonInstance = new Button();
        }

        public ButtonBuilder whenPressed(boolean button) {
            buttonInstance.buttonList.add(button);
            buttonInstance.button = button;
            return this;
        }

        public ButtonBuilder and(boolean button) {
            buttonInstance.buttonList.add(button);
            buttonInstance.button = buttonInstance.buttonList.stream().allMatch(Boolean::booleanValue);
            return this;
        }

        public ButtonBuilder or(boolean button) {
            buttonInstance.buttonList.add(button);
            buttonInstance.button = buttonInstance.buttonList.stream().anyMatch(Boolean::booleanValue);
            return this;
        }

        public void then(Runnable runnable) {
            if (buttonInstance.button) {
                runnable.run();
            }

            buttonInstance.buttonList.clear();
            buttonInstance.button = false;
        }
    }
}
