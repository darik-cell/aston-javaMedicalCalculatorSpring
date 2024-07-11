package example.medicalcalculations.controllers;

import example.medicalcalculations.services.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class WebController {

    private final CalculatorService calculatorService;

    public WebController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/calculator1")
    public String calculator1() {
        return "calculator1";
    }

    @GetMapping("/calculator2")
    public String calculator2() {
        return "calculator2";
    }

    @PostMapping("/calculate")
    @ResponseBody
    public Map<String, Double> calculate(
            @RequestParam String calculatorName,
            @RequestParam Map<String, String> params
    ) {
        Map<String, String> result = calculatorService.calculate(calculatorName, params);
        String resultString = result.get("result").replace(',', '.');
        double res = Double.parseDouble(resultString);
        return Map.of("result", res);
    }

}
