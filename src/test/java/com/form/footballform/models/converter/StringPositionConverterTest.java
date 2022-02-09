package com.form.footballform.models.converter;

import com.form.footballform.models.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringPositionConverterTest {

    StringPositionConverter converter;

    @BeforeEach
    void setUp() {
        converter = new StringPositionConverter();
    }

    @Test
    void convertToDatabaseColumn() {
        assertEquals("null-Striker", converter.convertToDatabaseColumn(List.of(new Position("Striker"))));
        assertEquals("null-Goal Keeper", converter.convertToDatabaseColumn(List.of(new Position("Goal Keeper"))));
        assertEquals("1-Striker", converter.convertToDatabaseColumn(List.of(new Position(1L, "Striker"))));
        assertEquals("1-Goal Keeper", converter.convertToDatabaseColumn(List.of(new Position(1L, "Goal Keeper"))));
        assertEquals("null-", converter.convertToDatabaseColumn(List.of(new Position(""))));
        assertEquals("null-123", converter.convertToDatabaseColumn(List.of(new Position("123"))));
        assertEquals("123-123", converter.convertToDatabaseColumn(List.of(new Position(123L, "123"))));
        assertEquals("1-Striker;1-Striker;1-Striker;1-Striker;1-Striker", converter.convertToDatabaseColumn(List.of(
                new Position(1L, "Striker"),
                new Position(1L, "Striker"),
                new Position(1L, "Striker"),
                new Position(1L, "Striker"),
                new Position(1L, "Striker")
        )));
    }
}