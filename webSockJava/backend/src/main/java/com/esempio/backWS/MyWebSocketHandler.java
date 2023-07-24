package com.esempio.backWS;

import com.fasterxml.jackson.databind.ObjectMapper;
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

        ObjectMapper objectMapper = new ObjectMapper();
        MessaggioComm msgComm = objectMapper.readValue(payload, MessaggioComm.class);

        System.out.println(msgComm.toString());

        MessaggioComm msgReply  = new MessaggioComm();
        msgReply.setID(12);
        msgReply.setProvenienza("JavaBack");
        msgReply.setContenuto("Ciao mondo!");

        session.sendMessage(new TextMessage(objectMapper.writeValueAsString(msgReply)));

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // Chiamato dopo che una connessione WebSocket è stata chiusa
        System.out.println("WebSocket connection closed: " + session.getId());
    }

}
