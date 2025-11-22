package org.example.model.strategy;

public class StrategyFactory {

    public static WritingStrategy getStrategy(String modeType) {
        if (modeType == null) {
            return null;

        }

        return switch (modeType.toLowerCase()) {
            case "professional" -> new ProfessionalStrategy();
            case "creative" ->  new CreativeStrategy();
            case "academic" -> new AcademicStrategy();
            default -> throw new IllegalArgumentException("Unknown mode " + modeType);
        };
    }
}