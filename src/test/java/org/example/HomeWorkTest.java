package org.example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeWorkTest {

    HomeWork homeWork = new HomeWork();

    @Test
    void check() {
        MorseTranslator morseTranslator = homeWork.morseTranslator();
        String input = "hello world";
        String encoded = ".... . .-.. .-.. --- / .-- --- .-. .-.. -..";
        assertEquals(encoded, morseTranslator.encode(input));
        assertEquals(input, morseTranslator.decode(encoded));

        String input1 = "a picture is worth a thousand words";
        assertEquals(input1.toLowerCase(),
                morseTranslator.decode(
                        morseTranslator.encode(input1)
                )
        );

        String input2 = "All good things must come to an end";
        assertEquals(input2.toLowerCase(),
                morseTranslator.decode(
                        morseTranslator.encode(input2)
                )
        );

        String input3 = "Keep your friends close 8905454 and your enemies closer 12 45 8 90";

        assertEquals(input3.toLowerCase(),
                morseTranslator.decode(
                        morseTranslator.encode(input3)
                )
        );
    }
}