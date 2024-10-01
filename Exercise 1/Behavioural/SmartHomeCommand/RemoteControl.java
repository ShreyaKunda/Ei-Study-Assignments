// RemoteControl.java

public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();

        // Create the receivers
        Light livingRoomLight = new Light();
        Fan ceilingFan = new Fan();

        // Create commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command fanOn = new FanOnCommand(ceilingFan);
        Command fanOff = new FanOffCommand(ceilingFan);

        // Turn the light on
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn the fan on
        remote.setCommand(fanOn);
        remote.pressButton();

        // Turn the light off
        remote.setCommand(lightOff);
        remote.pressButton();

        // Turn the fan off
        remote.setCommand(fanOff);
        remote.pressButton();
    }
}
