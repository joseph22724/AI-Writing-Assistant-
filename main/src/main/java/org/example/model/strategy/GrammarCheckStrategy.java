package org.example.model.strategy;

public class GrammarCheckStrategy implements WritingStrategy {
    @Override
    public String getSystemInstruction() {
        return "You are a strict copy editor. " +
                "Fix all grammar, spelling, and punctuation errors in the following text. " +
                "Do not change the style, tone, or vocabulary, only correct the grammar." +
                "If the text is perfect, return it exactly as is." +
                "Briefly include what you changed and why";
    }
}