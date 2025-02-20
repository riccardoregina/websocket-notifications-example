package it.unina.notification_example.adapter.in;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WebSocketController {

    @MessageMapping("/register")
    @SendToUser("/topic/registration")
    public String registerUser(@AuthenticationPrincipal Principal principal) {
        return "User registered with ID: " + principal.getName();
    }
}