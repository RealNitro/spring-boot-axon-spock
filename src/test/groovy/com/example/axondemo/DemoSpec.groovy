package com.example.axondemo

import com.example.axondemo.command.Create
import com.example.axondemo.command.Message
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@ActiveProfiles(value = "test")
class DemoSpec extends Specification {
    @Autowired
    CommandGateway commandGateway

    @Autowired
    DemoQueryService queryService

    def name = 'test'
    def content1 = 'content 1'
    def content2 = 'content 2'

    def setup() {
        commandGateway.sendAndWait(new Create(name))
    }

    def "test 1"() {
        when:
        commandGateway.sendAndWait(new Message(name, content1))

        then:
        queryService.messages.messages == [content1]
    }

    def "test 2"() {
        when:
        commandGateway.sendAndWait(new Message(name, content2))

        then:
        queryService.messages.messages == [content2]
    }
}
