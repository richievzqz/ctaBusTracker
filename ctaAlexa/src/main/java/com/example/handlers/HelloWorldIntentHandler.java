package com.example.handlers;

import java.util.Optional;
import com.example.handlers.BusTracker;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import static com.amazon.ask.request.Predicates.intentName;

public class HelloWorldIntentHandler implements RequestHandler {
 
 public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("HelloWorldIntent"));
    }
public Optional<Response> handle(HandlerInput input) {
		BusTracker b = new BusTracker("HebXkzmejBK7sbAJRXm8TYiBM");
		String speechText = b.demo();
       return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("HelloWorld", speechText)
                .build();
    }
}