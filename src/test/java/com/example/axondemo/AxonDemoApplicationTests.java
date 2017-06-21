package com.example.axondemo;

import com.example.axondemo.command.Create;
import com.example.axondemo.command.Message;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
public class AxonDemoApplicationTests {
	@Autowired
	CommandGateway commandGateway;

	@Autowired
	DemoQueryService queryService;

	String name = "test";
	String content1 = "content 1";
	String content2 = "content 2";

	@Before
	public void setUp() {
		commandGateway.sendAndWait(new Create(name));
	}

	@Test
	public void contextLoads1() {
		commandGateway.sendAndWait(new Message(name, content1));
		assertEquals (queryService.getMessages().getMessages(), Collections.singletonList(content1));
	}

	@Test
	public void contextLoads2() {
		commandGateway.sendAndWait(new Message(name, content2));
		assertEquals (queryService.getMessages().getMessages(), Collections.singletonList(content2));
	}
}
