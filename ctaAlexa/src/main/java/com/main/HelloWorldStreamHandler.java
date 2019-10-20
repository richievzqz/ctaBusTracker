package com.main;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.example.handlers.CancelandStopIntentHandler;
import com.example.handlers.HelloWorldIntentHandler;
import com.example.handlers.HelpIntentHandler;
import com.example.handlers.LaunchRequestHandler;
import com.example.handlers.SessionEndedRequestHandler;

public class HelloWorldStreamHandler extends SkillStreamHandler {
 
 private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new HelloWorldIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler())
                .withSkillId("amzn1.ask.skill.01d2b15b-66cb-4c42-97be-c7db005c3a24")
                .build();
    }
public HelloWorldStreamHandler() {
        super(getSkill());
    }
}