package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static ru.netology.entity.Country.*;

public class MessageSenderImplTest {
    @Test
    void russianMessageByIp() {
        String expected = "Это сообщение на русском";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "any russian IP");
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("any russian IP"))
                .thenReturn(new Location("Test", RUSSIA, "Testovaya", 1));
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(RUSSIA))
                .thenReturn("Это сообщение на русском");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        String actual = messageSender.send(headers);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void englishMessageByIp() {
        String expected = "This is English message";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "any american IP");
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("any american IP"))
                .thenReturn(new Location("Test", USA, "Test street", 2));
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(USA))
                .thenReturn("This is English message");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        String actual = messageSender.send(headers);
        Assertions.assertEquals(expected, actual);
    }
}