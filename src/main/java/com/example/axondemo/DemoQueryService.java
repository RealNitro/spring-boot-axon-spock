package com.example.axondemo;

import com.example.axondemo.dto.DemoDTO;
import com.example.axondemo.event.MessageReceived;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jens
 * @since 21/06/17, 10:46
 */
@Service
public class DemoQueryService {
    private final JdbcTemplate jdbcTemplate;

    public DemoQueryService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventHandler
    @Transactional
    public void handle(MessageReceived evt) {
        jdbcTemplate.update("INSERT INTO messages(content) VALUES (?)", evt.getContent());
    }

    public DemoDTO getMessages() {
        List<String> contents = jdbcTemplate.queryForList("SELECT content FROM messages")
                .stream()
                .map(m -> (String) m.get("content"))
                .collect(Collectors.toList());
        return new DemoDTO(contents);
    }
}
