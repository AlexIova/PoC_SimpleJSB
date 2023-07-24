package com.esempio.backWS;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Questo viene chiamato quando si ha una nuova connessione WebSocket
        System.out.println("WebSocket connection established: " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Chiamato quando c'è un nuovo messaggio ricevuto dal cliente
        String payload = message.getPayload();
        System.out.println("Received message from client: " + payload);
        session.sendMessage(new TextMessage("Ciao, ho ricevuto il tuo messaggio! " + payload));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // Chiamato dopo che una connessione WebSocket è stata chiusa
        System.out.println("WebSocket connection closed: " + session.getId());
    }

}
