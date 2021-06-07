package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Location;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

public class GeoServiceImplTest {
    @Test
    void getCountryByRuIp(){
        Location actual = new GeoServiceImpl().byIp("172.");
        Assertions.assertEquals(RUSSIA, actual.getCountry());
    }

    @Test
    void getCountryByEnIp(){
        Location actual = new GeoServiceImpl().byIp("96.");
        Assertions.assertEquals(USA, actual.getCountry());
    }
}