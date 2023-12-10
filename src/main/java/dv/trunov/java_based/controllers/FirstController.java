package dv.trunov.java_based.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        String message = String.format("Hello, %s %s", name, surname);
        model.addAttribute("message", message);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") double a,
                             @RequestParam("b") double b,
                             @RequestParam("action") String action,
                             Model model) {
        double result = switch (action) {
            case "multiplication" -> a * b;
            case "subtraction" -> a - b;
            case "addition" -> a + b;
            case "division" -> a / b;
            default -> Double.NaN;
        };
        String message = String.format("Result of your %s is: %.2f", action, result);
        model.addAttribute("message", message);
        return "first/calculator";
    }
}
