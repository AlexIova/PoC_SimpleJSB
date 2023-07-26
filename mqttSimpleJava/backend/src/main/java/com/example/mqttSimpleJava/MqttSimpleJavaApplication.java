package com.example.mqttSimpleJava;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;

public class MqttSimpleJavaApplication {

	public static void main(String[] args) {

		String topicSend    = "/topic/penna";
		String topicRecv    = "/topic/quaderno";
		String content      = "Messaggio da Java";
		int qos             = 1;
		String broker       = "ws://localhost:15675/ws";
		String clientId     = "JavaSample";
		MqttDefaultFilePersistence persistence = new MqttDefaultFilePersistence();

		try {
			MqttClient sampleClient = new MqttClient(broker, clientId, persistence);

			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(false);

			System.out.println("Connecting to broker: "+broker);

			sampleClient.connect(connOpts);

			System.out.println("Connected");

			/* Subscribing with lambda */
			sampleClient.subscribe(topicRecv, (topic, msg) -> {
				byte[] payload = msg.getPayload();
				System.out.println(new String(payload));
			});

			System.out.println("Publishing message: "+content);

			MqttMessage message = new MqttMessage(content.getBytes());
			message.setQos(qos);

			for(int i=0; i < 10; i++){
				sampleClient.publish(topicSend, message);
				Thread.sleep(10);
			}

			/*
			System.out.println("Message published");
			sampleClient.disconnect();
			System.out.println("Disconnected");
			System.exit(0);
			 */
		} catch(MqttException me) {
			System.out.println("reason "+me.getReasonCode());
			System.out.println("msg "+me.getMessage());
			System.out.println("loc "+me.getLocalizedMessage());
			System.out.println("cause "+me.getCause());
			System.out.println("excep "+me);
			me.printStackTrace();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

}
