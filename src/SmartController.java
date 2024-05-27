public class SmartController {

    public Gamepad gamepad;

    public SmartController(Gamepad gamepad) {
        this.gamepad = gamepad;
    }

    public boolean getButtonA() {
        return gamepad.a;
    }

    public boolean getButtonB() {
        return gamepad.b;
    }

    public boolean getButtonX() {
        return gamepad.x;
    }
}
