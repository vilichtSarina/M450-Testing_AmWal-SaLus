package com.tbz.m450.UnitTests;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public double add(@RequestParam double num1, @RequestParam double num2) {
        return num1 + num2;
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double num1, @RequestParam double num2) {
        return num1 - num2;
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double num1, @RequestParam double num2) {
        return num1 * num2;
    }

    @GetMapping("/divide")
    public double divide(@RequestParam double num1, @RequestParam double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return num1 / num2;
    }
}
