## Java Message Service
### Algorithm
1. Install some message broker (e.g. OpenMQ).
2. Run message broker.
3. Customize message broker setting inside ua.com.javacore.jms.MessageSender and ua.com.javacore.jms.MessageReceiver.
3. Create and send message by running ua.com.javacore.jms.MessageSender.main().
4. Run ua.com.javacore.jms.MessageReceiver.main() to get message that was sent.