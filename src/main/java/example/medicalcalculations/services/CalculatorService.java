package example.medicalcalculations.services;

import example.medicalcalculations.models.ICalc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalculatorService {

    private final Map<String, ICalc> calculators;

    @Autowired
    public CalculatorService(List<ICalc> calculatorList) {
        calculators = new HashMap<>();
        for (ICalc calc : calculatorList) {
            calculators.put(calc.getName().toLowerCase(), calc);
        }
    }

    public Map<String, String> getInfo(String name) {
        if ("imt".equalsIgnoreCase(name)) {
            return Map.of("info", "Этот калькулятор позволяет вычислить Индек Массы Тела (ИМТ)");
        }
        else if("devine".equalsIgnoreCase(name)) {
            return Map.of("info", "Этот калькулятор вычисляет вес по росту");
        }
        return Map.of("info", "Информация не найдена");
    }

    public Map<String, String> calculate(String name, Map<String, String> params) {
        ICalc calculator = calculators.get(name.toLowerCase());
        if (calculator != null) {
            double result = calculator.calculate(params);
            return Map.of("result", String.format("%.1f", result));
        }
        return Map.of("result", "Ошибка вычислений");
    }
}
