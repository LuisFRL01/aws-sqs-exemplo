package luisfrl01.com.github.sqs;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerSQSTemplate {

    @Value("${aws.fila}")
    private String queue;

    @Autowired
    private QueueMessagingTemplate messagingTemplate;

    public void send(final String messagePayload) {

        var signupEvent = new SignupEvent("time", "userName", "email");

        messagingTemplate.convertAndSend(queue, signupEvent);
    }
}
