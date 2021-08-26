package com.sampleproject.sampleproject.restfull;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaRest {

    @Autowired
    KafkaTemplate<String, Object> template;

    @PostMapping(path = "/send")
    public void kirimPesan() {
        JSONObject item = new JSONObject();
        item.put("action","fcm");
        item.put("regid","12345");
        item.put("title","abc");
        template.send("pesan-saya", item.toString());
    }
}
