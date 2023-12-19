package demo.application.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class Home {

    @GetMapping("/")
    public String home() {
        return "Is work" + LocalDateTime.now().toString();
    }
}
