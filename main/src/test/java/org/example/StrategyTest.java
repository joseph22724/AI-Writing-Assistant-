package org.example;

import org.example.model.strategy.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StrategyFactoryTest {

    @Test
    void testGetProfessionalStrategy() {
        // testing instance
        WritingStrategy strategy = StrategyFactory.getStrategy("Professional");
        assertInstanceOf(ProfessionalStrategy.class, strategy);
    }

    @Test
    void testGetCreativeStrategyCaseInsensitive() {
        //  tests capitalization
        WritingStrategy strategy = StrategyFactory.getStrategy("creative");
        assertInstanceOf(CreativeStrategy.class, strategy);
    }

    @Test
    void testGetAcademicStrategy() {
        WritingStrategy strategy = StrategyFactory.getStrategy("Academic");
        assertInstanceOf(AcademicStrategy.class, strategy);
    }

    @Test
    void testUnknownStrategyThrowsException() {
        //testing unknown strategy
        assertThrows(IllegalArgumentException.class, () -> {StrategyFactory.getStrategy("UnknownStrategy");
        });
    }
}