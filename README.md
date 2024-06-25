# 🤖 Declarative Button Utils for FTC Teams

This project demonstrates a base implementation of declarative button utilities for FTC (First Tech Challenge) teams.

## 🌐 Overview 

- **Fluent Interface**: Chain method calls to define button conditions and actions.
- **Supports AND and OR Logic**: Combine button states using `and()` and `or()` methods.
- **Executable Actions**: Execute actions conditionally based on button states.

## 🛠️ Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/barber-shop-scheduler.git
   cd declarative-button-ftc
2. **Clone the repository:**
   ```bash
   javac Main.java
3. **Clone the repository:**
   ```bash
   java Main

 ## 📘 Usage

1. Initialize Gamepad and SmartController
   ```java
   var gamePad = new Gamepad();
   var smartController = new SmartController(gamePad);
2. Create Subsystems
   ```java
   var subsystemAnd = new Subsystem("AND SAMPLE");
   var subsystemOr = new Subsystem("OR SAMPLE");

3. Define Button Conditions and Actions
   ```java
   while (true) {
      // Executes subsystemAnd when both Button A and Button B are pressed simultaneously
      ButtonUtils.whenPressed(smartController.getButtonA())
              .and(smartController.getButtonB())
              .then(subsystemAnd::execute);
   
      // Executes subsystemOr when either Button A or Button X is pressed
      ButtonUtils.whenPressed(smartController.getButtonA())
              .or(smartController.getButtonX())
              .then(subsystemOr::execute);
   }

## 👤 Author
- Gabriela Ribeiro
