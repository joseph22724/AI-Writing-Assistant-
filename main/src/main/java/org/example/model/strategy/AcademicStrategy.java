package org.example.model.strategy;

public class AcademicStrategy implements WritingStrategy {
    @Override
    public String getSystemInstruction() {
        return  "You are an academic editor. " +
                "Rewrite the text to be formal, objective, and precise. " +
                "Focus on clarity, logical flow, and standard academic tone and avoid conversational language, contractions, and unsupported opinions. " +
                "Strictly return the text and nothing else.";
    }
}