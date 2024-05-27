import java.util.ArrayList;
import java.util.List;

public class ButtonUtils {

    private List<Boolean> buttonList;
    private boolean button;

    private ButtonUtils() {
        this.button = false;
        this.buttonList = new ArrayList<>();
    }

    public static ButtonBuilder whenPressed(boolean button) {
        return new ButtonBuilder().whenPressed(button);
    }

    public static class ButtonBuilder {
        private ButtonUtils buttonUtilsInstance;

        private ButtonBuilder() {
            buttonUtilsInstance = new ButtonUtils();
        }

        public ButtonBuilder whenPressed(boolean button) {
            buttonUtilsInstance.buttonList.add(button);
            buttonUtilsInstance.button = button;
            return this;
        }

        public ButtonBuilder and(boolean button) {
            buttonUtilsInstance.buttonList.add(button);
            buttonUtilsInstance.button = buttonUtilsInstance.buttonList.stream().allMatch(Boolean::booleanValue);
            return this;
        }

        public ButtonBuilder or(boolean button) {
            buttonUtilsInstance.buttonList.add(button);
            buttonUtilsInstance.button = buttonUtilsInstance.buttonList.stream().anyMatch(Boolean::booleanValue);
            return this;
        }

        public void then(Runnable runnable) {
            if (buttonUtilsInstance.button) {
                runnable.run();
            }

            buttonUtilsInstance.buttonList.clear();
            buttonUtilsInstance.button = false;
        }
    }
}
