package com.paty.food.Util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Util {
    public static LocalDateTime dataAtual() {
        return LocalDateTime.now(ZoneId.of("America/São Paulo"));
    }
}
