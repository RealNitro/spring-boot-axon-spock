package com.example.axondemo;

import com.example.axondemo.command.Message;
import com.example.axondemo.dto.DemoDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author jens
 * @since 21/06/17, 10:43
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    private final CommandGateway commandGateway;
    private final DemoQueryService demoQueryService;

    public DemoController(CommandGateway commandGateway, DemoQueryService demoQueryService) {
        this.commandGateway = commandGateway;
        this.demoQueryService = demoQueryService;
    }

    @PostMapping
    public DemoDTO handleInput(
            @RequestBody() Map input
    ) {
        commandGateway.send(new Message((String) input.get("name"), (String) input.get("message")));
        return demoQueryService.getMessages();
    }
}
