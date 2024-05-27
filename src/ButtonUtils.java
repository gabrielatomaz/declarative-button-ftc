import java.util.ArrayList;
import java.util.List;

public class ButtonUtils {

    private static List<Boolean> buttonList = new ArrayList<>();
    private static boolean button = false;

    public static ButtonUtils whenPressed(boolean button) {
        buttonList.add(button);
        ButtonUtils.button = button;
        return new ButtonUtils();
    }

    public static ButtonUtils and(boolean button) {
        buttonList.add(button);
        ButtonUtils.button = buttonList.stream().allMatch(Boolean::booleanValue);
        return new ButtonUtils();
    }

    public static ButtonUtils or(boolean button) {
        buttonList.add(button);
        ButtonUtils.button = buttonList.stream().anyMatch(Boolean::booleanValue);
        return new ButtonUtils();
    }

    public static void then(Runnable runnable) {
        if (ButtonUtils.button) {
            runnable.run();
        }

        buttonList.clear();
        ButtonUtils.button = false;
    }
}