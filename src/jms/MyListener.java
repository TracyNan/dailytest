package jms;

import java.net.URI;
import java.net.URISyntaxException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

public class MyListener {
	public static BrokerService broker;
	public static ConnectionFactory connectionFactory;
	public static Connection connection;
	public static Session session;
	public static Queue queue;

	static {
		try {
			broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
			broker.start();
			connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			connection = connectionFactory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			queue = session.createQueue("customerQueue");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws URISyntaxException, Exception {

		MessageConsumer consumer = session.createConsumer(queue);
		consumer.setMessageListener(new ConsumerMessageListener("Consumer"));
		connection.start();
	}

	public static void produce(String message) throws JMSException {
		System.out.println("session is " + session);
		MessageProducer producer = session.createProducer(queue);
		Message msg = session.createTextMessage(message);
		System.out.println("Sending text '" + message + "'");
		producer.send(msg);
	}
}
