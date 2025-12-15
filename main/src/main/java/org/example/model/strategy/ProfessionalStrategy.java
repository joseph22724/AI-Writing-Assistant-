package org.example.model.strategy;

public class ProfessionalStrategy implements WritingStrategy {
    @Override
    public String getSystemInstruction() {
        return  "You are a professional editor. " +
                "Rewrite the user's text to be concise, formal, and suitable for a business email or report. " +
                "Correct all grammar and ensure a polite, objective tone." +
                "Strictly return the text and nothing else.";
    }
}