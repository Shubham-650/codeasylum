package com.github.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@EnableBinding(SenderTest.Serder.class)
public class SenderTest {

    @Autowired
    private Serder sinder;

    @Test
    public void sinkSenderTester() {
        sinder.output().send(MessageBuilder.withPayload("produce a message ：http://blog.didispace.com").build());
    }


    public interface Serder {
        String OUTPUT = "input";

        @Output(Serder.OUTPUT)
        MessageChannel output();
    }
}
