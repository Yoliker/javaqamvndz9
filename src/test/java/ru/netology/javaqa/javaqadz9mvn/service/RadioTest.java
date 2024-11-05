package ru.netology.javaqa.javaqadz9mvn.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class RadioTest {

    @Test
    public void WasSetMaxParameterInConstr() {
        Radio radio = new Radio(); // конструктор с установл.макс знач-ем 9

        Assertions.assertEquals(0, radio.getMinNumber());
        Assertions.assertEquals(9, radio.getMaxNumber());
        Assertions.assertEquals(0, radio.getCurrentNumber());
        Assertions.assertEquals(0, radio.getMinVolume());
        Assertions.assertEquals(100, radio.getMaxVolume());
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void ConstrWithSetSize() {
        Radio radio = new Radio(20); // конструктор с установл.макс знач-ем

        Assertions.assertEquals(0, radio.getMinNumber());
        Assertions.assertEquals(19, radio.getMaxNumber());
        Assertions.assertEquals(0, radio.getCurrentNumber());
    }

    @Test
    public void shouldSetNumberInSetSize() {
        Radio radio = new Radio(20);
        radio.setCurrentNumber(radio.getMinNumber() + 15);  // установка номера радиостанции с установлен.размером кол-ва станций

        int expected = radio.getMinNumber() + 15;
        int actual = radio.getCurrentNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetNumberUnderMinStationWithSetSize() {
        Radio radio = new Radio(20);
        radio.setCurrentNumber(radio.getMinNumber() - 1);  // установка номера радиостанции ниже минимума установлен.размера кол-ва станций

        Assertions.assertEquals(radio.getMinNumber(), radio.getCurrentNumber());
    }

    @Test
    public void shouldSetMinNumberWithSetSize() {
        Radio radio = new Radio(20);
        radio.setCurrentNumber(radio.getMinNumber() + 1);  // установка минимального номера радиостанции в установлен.размере кол-ва станций
        radio.setCurrentNumber(radio.getMinNumber());

        Assertions.assertEquals(radio.getMinNumber(), radio.getCurrentNumber());
    }

    @Test
    public void shouldSetNumberAboveMinStationWithSetSize() {
        Radio radio = new Radio(20);
        radio.setCurrentNumber(radio.getMinNumber() + 1);  // установка номера радиостанции выше минимального номера установлен.размера кол-ва станций

        Assertions.assertEquals(radio.getMinNumber() + 1, radio.getCurrentNumber());
    }

    @Test
    public void shouldSetNumberUnderMaxStationWithSetSize() {
        Radio radio = new Radio(20);
        radio.setCurrentNumber(radio.getMaxNumber() - 1);  // установка предпоследнего номера радиостанции в установлен.размере кол-ва станций

        Assertions.assertEquals(radio.getMaxNumber() - 1, radio.getCurrentNumber());
    }

    @Test
    public void shouldSetMaxNumberWithSetSize() {
        Radio radio = new Radio(20);
        radio.setCurrentNumber(radio.getMaxNumber() - 2);  // установка макс номера радиостанции в установлен.размере кол-ва станций
        radio.setCurrentNumber(radio.getMaxNumber());

        Assertions.assertEquals(radio.getMaxNumber(), radio.getCurrentNumber());
    }

    @Test
    public void shouldNotSetNumberAboveSetSize() {
        Radio radio = new Radio(20);
        radio.setCurrentNumber(radio.getMaxNumber() + 1);  // установка номера радиостанции выше максимального номера в установлен.размере кол-ва станций

        Assertions.assertEquals(radio.getMinNumber(), radio.getCurrentNumber());
    }

    @Test
    public void shouldIncreaseMinNumberWithSetSize() {
        Radio radio = new Radio(15);
        radio.setCurrentNumber(radio.getMinNumber());
        radio.next();               // следующий номер радиостанции выше минимального

        int expected = radio.getMinNumber() + 1;
        int actual = radio.getCurrentNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseAfterMinNumberWithSize() {
        Radio radio = new Radio(15);
        radio.setCurrentNumber(radio.getMinNumber() + 1); // следующий номер радиостанции
        radio.next();

        Assertions.assertEquals(radio.getMinNumber() + 2, radio.getCurrentNumber());
    }

    @Test
    public void shouldIncreaseUnderMaxNumberWithSize() {
        Radio radio = new Radio(15);
        radio.setCurrentNumber(radio.getMaxNumber() - 1);
        radio.next();               // следующий номер радиостанции ниже максимального

        Assertions.assertEquals(radio.getMaxNumber(), radio.getCurrentNumber());
    }

    @Test
    public void shouldIncreaseAfterMaxNumberWithSize() {
        Radio radio = new Radio(15);
        radio.setCurrentNumber(radio.getMaxNumber());
        radio.next();              // следующий номер радиостанции после максимального

        Assertions.assertEquals(radio.getMinNumber(), radio.getCurrentNumber());
    }

    @Test
    public void shouldDecreaseMinNumberWithSize() {
        Radio radio = new Radio(28);
        radio.setCurrentNumber(radio.getMinNumber() + 1);
        radio.setCurrentNumber(radio.getMinNumber());  // предыдущий номер радиостанции после минимального
        radio.prev();

        Assertions.assertEquals(radio.getMaxNumber(), radio.getCurrentNumber());
    }

    @Test
    public void shouldDecreaseUpperFirstBoundaryNumberWithSize() {
        Radio radio = new Radio(28);
        radio.setCurrentNumber(radio.getMinNumber() + 1); // предыдущий номер радиостанции
        radio.prev();

        Assertions.assertEquals(radio.getMinNumber(), radio.getCurrentNumber());
    }

    @Test
    public void shouldDecreaseUnderMaxNumberWithSize() {
        Radio radio = new Radio(28);
        radio.setCurrentNumber(radio.getMaxNumber() - 1); // предыдущий номер радиостанции ниже максимального
        radio.prev();

        Assertions.assertEquals(radio.getMaxNumber() - 2, radio.getCurrentNumber());
    }

    @Test
    public void shouldDecreaseMaxNumberWithSize() {
        Radio radio = new Radio(28);
        radio.setCurrentNumber(radio.getMaxNumber()); // предыдущий номер радиостанции от максимального
        radio.prev();

        Assertions.assertEquals(radio.getMaxNumber() - 1, radio.getCurrentNumber());
    }

    @Test
    public void shouldSetNumber() {
        Radio radio = new Radio();
        radio.setCurrentNumber(radio.getMaxNumber() - 4);  // установка номера радиостанции

        int expected = radio.getMaxNumber() - 4;
        int actual = radio.getCurrentNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetUnderMinNumber() {
        Radio radio = new Radio();

        radio.setCurrentNumber(radio.getMinNumber() - 1);  // установка номера радиостанции ниже минимального - не работает

        Assertions.assertEquals(radio.getMinNumber(), radio.getCurrentNumber());
    }

    @Test
    public void shouldSetMinNumber() {
        Radio radio = new Radio();
        radio.setCurrentNumber(radio.getMinNumber() + 2);
        radio.setCurrentNumber(radio.getMinNumber());  // установка минимального номера радиостанции

        Assertions.assertEquals(radio.getMinNumber(), radio.getCurrentNumber());
    }

    @Test
    public void shouldSetNextNumberAfterMinStation() {
        Radio radio = new Radio();
        radio.setCurrentNumber(radio.getMinNumber() + 1); // установка номера радиостанции выше минимального

        Assertions.assertEquals(radio.getMinNumber() + 1, radio.getCurrentNumber());
    }

    @Test
    public void shouldSetUnderLastNumber() {
        Radio radio = new Radio();
        radio.setCurrentNumber(radio.getMaxNumber() - 1);  // установка номера радиостанции ниже максимального

        Assertions.assertEquals(radio.getMaxNumber() - 1, radio.getCurrentNumber());
    }

    @Test
    public void shouldSetMaxNumber() {
        Radio radio = new Radio();
        radio.setCurrentNumber(radio.getMaxNumber() - 2);  // 7
        radio.setCurrentNumber(radio.getMaxNumber());  // установка максимального номера радиостанции

        Assertions.assertEquals(radio.getMaxNumber(), radio.getMaxNumber());
    }

    @Test
    public void shouldNotSetAfterMaxNumber() {
        Radio radio = new Radio();
        radio.setCurrentNumber(radio.getMaxNumber() + 1); // установка номера радиостанции после максимального  - не работает

        Assertions.assertEquals(radio.getMinNumber(), radio.getCurrentNumber());
    }

    @Test
    public void shouldIncreaseMinNumber() {
        Radio radio = new Radio();
        radio.setCurrentNumber(radio.getMinNumber());
        radio.next();               // следующий номер радиостанции выше минимального

        int expected = radio.getMinNumber() + 1;
        int actual = radio.getCurrentNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseAfterMinNumber() {
        Radio radio = new Radio();
        radio.setCurrentNumber(radio.getMinNumber() + 1); // следующий номер радиостанции
        radio.next();

        Assertions.assertEquals(radio.getMinNumber() + 2, radio.getCurrentNumber());
    }

    @Test
    public void shouldIncreaseUnderMaxNumber() {
        Radio radio = new Radio();
        radio.setCurrentNumber(radio.getMaxNumber() - 1);
        radio.next();               // следующий номер радиостанции ниже максимального

        Assertions.assertEquals(radio.getMaxNumber(), radio.getCurrentNumber());
    }

    @Test
    public void shouldIncreaseAfterMaxNumber() {
        Radio radio = new Radio();
        radio.setCurrentNumber(radio.getMaxNumber());
        radio.next();              // следующий номер радиостанции после максимального

        Assertions.assertEquals(radio.getMinNumber(), radio.getCurrentNumber());
    }

    @Test
    public void shouldDecreaseMinNumber() {
        Radio radio = new Radio();
        radio.setCurrentNumber(radio.getMinNumber() + 1);
        radio.setCurrentNumber(radio.getMinNumber());  // предыдущий номер радиостанции после минимального
        radio.prev();

        Assertions.assertEquals(radio.getMaxNumber(), radio.getCurrentNumber());
    }

    @Test
    public void shouldDecreaseUpperFirstBoundaryNumber() {
        Radio radio = new Radio();
        radio.setCurrentNumber(radio.getMinNumber() + 1); // предыдущий номер радиостанции
        radio.prev();

        Assertions.assertEquals(radio.getMinNumber(), radio.getCurrentNumber());
    }

    @Test
    public void shouldDecreaseUnderMaxNumber() {
        Radio radio = new Radio();
        radio.setCurrentNumber(radio.getMaxNumber() - 1); // предыдущий номер радиостанции ниже максимального
        radio.prev();

        Assertions.assertEquals(radio.getMaxNumber() - 2, radio.getCurrentNumber());
    }

    @Test
    public void shouldDecreaseMaxNumber() {
        Radio radio = new Radio();
        radio.setCurrentNumber(radio.getMaxNumber()); // предыдущий номер радиостанции от максимального
        radio.prev();

        Assertions.assertEquals(radio.getMaxNumber() - 1, radio.getCurrentNumber());
    }

/*
    @Test
    public void shouldSetvolumeWithSize() {
        Radio radio = new Radio(50);
        radio.setCurrentVolume(30);  // установка громкости с установлен.размером кол-в громкости
                                     // как вариант
        int expected = 30;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
     */

    @Test
    public void shouldSetVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMinVolume() + 20);  // установка громкости

        int expected = radio.getMinVolume() + 20;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetUnderMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMinVolume() - 1);  // установка громкости ниже минимального - не работает

        Assertions.assertEquals(radio.getMinVolume(), radio.getCurrentVolume());
    }

    @Test
    public void shouldSetMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMinVolume() + 2);
        radio.setCurrentVolume(radio.getMinVolume());  // установка минимальной громкости

        Assertions.assertEquals(radio.getMinVolume(), radio.getCurrentVolume());
    }

    @Test
    public void shouldSetUpperMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMinVolume() + 1);  // установка громкости выше минимальной

        Assertions.assertEquals(radio.getMinVolume() + 1, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetUnderMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMaxVolume() - 1);  // установка громкости ниже максимальной

        Assertions.assertEquals(radio.getMaxVolume() - 1, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMaxVolume() - 2);  // установка максимальной громкости
        radio.setCurrentVolume(radio.getMaxVolume());

        Assertions.assertEquals(radio.getMaxVolume(), radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetUpperMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMaxVolume() + 1);  // установка громкости выше максимальной - не работает

        Assertions.assertEquals(radio.getMinVolume(), radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMinVolume());
        radio.increaseVolume();    // увеличение минимальной громкости

        Assertions.assertEquals(radio.getMinVolume() + 1, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseFirstVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMinVolume() + 1);
        radio.increaseVolume();    // увеличение громкости выше минимальной

        Assertions.assertEquals(radio.getMinVolume() + 2, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseUnderMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMaxVolume() - 1);
        radio.increaseVolume();     // увеличение громкости ниже максимальной

        Assertions.assertEquals(radio.getMaxVolume(), radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();      // увеличение максимальной громкости

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotDecreaseMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMinVolume() + 2);
        radio.setCurrentVolume(radio.getMinVolume());
        radio.decreaseVolume();    // уменьшение громкости ниже минимальной

        Assertions.assertEquals(radio.getMinVolume(), radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseUpperMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMinVolume() + 1);
        radio.decreaseVolume();    // уменьшение громкости до минимальной

        Assertions.assertEquals(radio.getMinVolume(), radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseUnderMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMaxVolume() - 1);
        radio.decreaseVolume();     // уменьшение громкости ниже максимальной

        Assertions.assertEquals(radio.getMaxVolume() - 2, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMaxVolume());
        radio.decreaseVolume();      // уменьшение максимальной громкости

        Assertions.assertEquals(radio.getMaxVolume() - 1, radio.getCurrentVolume());
    }
}