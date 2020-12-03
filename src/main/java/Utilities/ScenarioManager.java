package Utilities;

import io.cucumber.java.Scenario;

public class ScenarioManager {

    private static Scenario scenario;

    public ScenarioManager() {
        scenario = null;
    }

    public static Scenario getScenario() {
        return scenario;
    }

    public static void setScenario(Scenario CucumberScenario) {
       scenario = CucumberScenario;
    }

}
