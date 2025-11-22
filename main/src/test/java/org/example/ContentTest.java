package org.example;

import org.example.model.strategy.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StrategyContentTest {
    // Checking if the prompt contains keywords from strategies
    @Test
    void testProfessionalPrompt() {
        WritingStrategy strategy = new ProfessionalStrategy();
        String instruction = strategy.getSystemInstruction();
        assertTrue(instruction.contains("professional"));
    }

    @Test
    void testCreativePrompt() {
        WritingStrategy strategy = new CreativeStrategy();
        String instruction = strategy.getSystemInstruction();
        assertTrue(instruction.contains("creative"));
    }

    @Test
    void testAcademicPrompt() {
        WritingStrategy strategy = new AcademicStrategy();
        String instruction = strategy.getSystemInstruction();
        assertTrue(instruction.contains("academic"));
    }

}