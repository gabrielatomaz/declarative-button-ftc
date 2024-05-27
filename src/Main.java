public class Main {
    public static void main(String[] args) {
        var gamePad = new Gamepad();
        var smartController = new SmartController(gamePad);
        var subsystemAnd = new Subsystem("AND SAMPLE");
        var subsystemOr = new Subsystem("OR SAMPLE");


        var lastUpdateTime = System.currentTimeMillis();
        var updateInterval = 5000;
        gamePad.a = true;
        gamePad.b = true;
        gamePad.x = true;

        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastUpdateTime >= updateInterval) {
                System.out.println("5s");
                gamePad.a = !gamePad.a;
                gamePad.b = !gamePad.b;

                lastUpdateTime = currentTime;
            }

            Button.whenPressed(smartController.getButtonA())
                    .and(smartController.getButtonB())
                    .then(subsystemAnd::execute);

            Button.whenPressed(smartController.getButtonA())
                    .or(smartController.getButtonX())
                    .then(subsystemOr::execute);
       }
    }
}
