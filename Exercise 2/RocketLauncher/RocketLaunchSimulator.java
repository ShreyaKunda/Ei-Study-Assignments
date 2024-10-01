public class RocketLaunchSimulator {
    public static void main(String[] args) {
        MissionControl missionControl = new MissionControl("launch_log.txt");
        missionControl.run();
    }
}
