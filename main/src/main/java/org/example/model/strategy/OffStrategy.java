package org.example.model.strategy;

public class OffStrategy implements WritingStrategy {
    @Override
    public String getSystemInstruction() {

        return "Do nothing simply return the text as is.";
    }
}