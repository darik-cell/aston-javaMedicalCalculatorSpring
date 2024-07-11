package example.medicalcalculations.models;

import java.util.Map;

public interface ICalc {
    String getName();
    double calculate(Map<String, String> params);
}
