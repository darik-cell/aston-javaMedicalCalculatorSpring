package example.medicalcalculations.models;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BMICalculator implements ICalc{

    @Override
    public String getName() {
        return "imt";
    }

    @Override
    public double calculate(Map<String, String> params) {
        double weight = Double.parseDouble(params.get("weight"));
        double height = Double.parseDouble(params.get("height")) / 100;
        return weight / (height * height);
    }
}
