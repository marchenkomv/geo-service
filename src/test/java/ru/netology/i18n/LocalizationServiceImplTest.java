package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

public class LocalizationServiceImplTest {
    @Test
    void getRuMessage() {
        String expected = "Добро пожаловать";
        String actual = new LocalizationServiceImpl().locale(RUSSIA);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getEnMessage() {
        String expected = "Welcome";
        String actual = new LocalizationServiceImpl().locale(USA);
        Assertions.assertEquals(expected, actual);
    }
}