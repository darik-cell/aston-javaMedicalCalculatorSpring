package example.medicalcalculations.models;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DevineCalculator implements ICalc {

    @Override
    public String getName() {
        return "devine";
    }

    @Override
    public double calculate(Map<String, String> params) {
        double height = Double.parseDouble(params.get("height"));
        Gender gender = Gender.valueOf(params.get("gender"));

        return switch (gender) {
            case MALE -> 50 + 2.3 * (0.394 *  height - 60);
            case FEMALE -> 45.5 + 2.3 * (0.394 * height - 60);
        };
    }
}
