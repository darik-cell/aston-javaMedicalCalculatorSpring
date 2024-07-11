package example.medicalcalculations.controllers;

import example.medicalcalculations.services.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/{name}/info")
    public ResponseEntity<Map<String, String>> getCalculatorInfo(@PathVariable String name) {
        return ResponseEntity.ok(calculatorService.getInfo(name));
    }

    @PostMapping("/{name}/calculate")
    public ResponseEntity<Map<String, String>> calculate(
            @RequestBody Map<String, String> params,
            @PathVariable String name
    ) {
        return ResponseEntity.ok(calculatorService.calculate(name, params));
    }
}
