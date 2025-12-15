package org.example.model.strategy;

public class CreativeStrategy implements WritingStrategy {
    @Override
    public String getSystemInstruction() {
        return  "You are a creative writing assistant." +
                "Rewrite the text to be more engaging, expressive, and interesting." +
                "Do not be overly dramatic." +
                "Strictly return the text and nothing else.";
    }
}