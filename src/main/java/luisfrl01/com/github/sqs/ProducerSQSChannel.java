package luisfrl01.com.github.sqs;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.awspring.cloud.messaging.core.QueueMessageChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProducerSQSChannel {

    @Value("${aws.fila}")
    private String queue;

    @Autowired
    private final AmazonSQSAsync amazonSqs;

    public ProducerSQSChannel(final AmazonSQSAsync amazonSQSAsync) {
        this.amazonSqs = amazonSQSAsync;
    }

    public boolean send(final String messagePayload) {
        var messageChannel = new QueueMessageChannel(amazonSqs, queue);

        var msg = MessageBuilder.withPayload(messagePayload)
                .setHeader("SenderId", "app1")
                .setHeaderIfAbsent("country", "AE")
                .build();

        long waitTimeoutMillis = 5000;
        return messageChannel.send(msg, waitTimeoutMillis);
    }
}
