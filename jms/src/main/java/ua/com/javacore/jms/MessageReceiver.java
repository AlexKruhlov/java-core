package ua.com.javacore.jms;

import com.sun.messaging.ConnectionFactory;

import javax.jms.*;

import static com.sun.messaging.ConnectionConfiguration.imqAddressList;
import static java.lang.System.out;

public class MessageReceiver implements MessageListener {

    public static final String ADDRESS_LIST = "mq://127.0.0.1:7377,mq://127.0.0.1:7377";
    public static final String QUEUE_NAME = "TestQueue";
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "admin";

    public static final String LISTENING_QUEUE = "Listening to the TestQueue...";
    public static final String CANNOT_GET_MESSAGES = "I cannot get any messages(((";

    public MessageReceiver() {
        ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
        try {
            connectionFactory.setProperty(imqAddressList, ADDRESS_LIST);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

        try (QueueConnection queueConnection = connectionFactory.createQueueConnection(USERNAME, PASSWORD)) {
            queueConnection.start();
            try (Session session = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE)) {
                Queue ioQueue = session.createQueue(QUEUE_NAME);

                MessageConsumer messageConsumer = session.createConsumer(ioQueue);
                messageConsumer.setMessageListener(this);
                out.println(LISTENING_QUEUE);
                Thread.sleep(300_000L);

            }
        } catch (JMSException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageReceiver();
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                out.println(((TextMessage) message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        } else {
            out.println(CANNOT_GET_MESSAGES);
        }
    }
}
