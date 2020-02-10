package ua.com.javacore.jms;

import com.sun.messaging.ConnectionFactory;

import javax.jms.*;

import static com.sun.messaging.ConnectionConfiguration.imqAddressList;
import static java.lang.System.out;

public class MessageSender {
    private static final String QUEUE_NAME = "TestQueue";
    private static final String ADDRESS_LIST = "mq://127.0.0.1:7377,mq://127.0.0.1:7377";
    private static final String USER_NAME = "admin";
    private static final String PASSWORD = "admin";

    private static final String TEXT_MESSAGE = "Hello world!!!";
    private static final String MESSAGE_SUCCESSFULLY_SENT = "Message successfully sent!";

    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
        try {
            connectionFactory.setProperty(imqAddressList, ADDRESS_LIST);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

        try (QueueConnection queueConnection = connectionFactory.createQueueConnection(USER_NAME, PASSWORD)) {
            queueConnection.start();
            try (Session session = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE)) {
                Queue ioQueue = session.createQueue(QUEUE_NAME);
                MessageProducer queueSender = session.createProducer(ioQueue);

                TextMessage outMsg = session.createTextMessage(TEXT_MESSAGE);
                queueSender.send(outMsg);
                queueSender.close();
                out.println(MESSAGE_SUCCESSFULLY_SENT);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
