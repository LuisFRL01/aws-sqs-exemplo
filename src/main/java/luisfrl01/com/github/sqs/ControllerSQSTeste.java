package luisfrl01.com.github.sqs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sqs")
public class ControllerSQSTeste {

    @Autowired
    private ProducerSQSChannel producerSQSChannel;

    @Autowired
    private ProducerSQSTemplate producerSQSTemplate;

    @GetMapping
    public void enviarMensagem() {
        producerSQSTemplate.send("meu teste");
        //messageSender.send("minha mensagem de teste");
    }
}
