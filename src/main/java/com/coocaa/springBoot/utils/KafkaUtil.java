package com.coocaa.springBoot.utils;

import com.coocaa.springBoot.domain.Result;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class KafkaUtil {

    private static Logger logger = LoggerFactory.getLogger(KafkaUtil.class);

    private final KafkaTemplate<String, String> template;

    @Autowired
    public KafkaUtil(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    @RequestMapping(value = "/sendMessage")
    @ResponseBody
    public Result sendMessage(String topic, String data) {
        template.send(topic, data);
        return ResultUtil.success();
    }

    @KafkaListener( topics = {"Hello-Kafka"})
    public void listenMessageU1(ConsumerRecord<?, ?> c) {
        logger.info("{}-{}", c.topic(), c.value());
    }

//    @KafkaListener(id = "U2", topics = "t2")
//    public void listenMessageU2(ConsumerRecord<?, ?> c) {
//        logger.info("{}-{}", c.topic(), c.value());
//    }

}
