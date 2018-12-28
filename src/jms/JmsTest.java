package jms;

import javax.jms.JMSException;

public class JmsTest {
	public static void main(String[] args) throws JMSException {
		MyListener.produce("test");
	}
}
