package ru.netology.javaqa.javaqadz9mvn.service;

public class Radio {
    private int currentNumber;
    private int currentVolume;

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int newCurrentNumber) {
        if (newCurrentNumber < 0) {  // установка ограничения значений радиостанции
            return;
        }
        if (newCurrentNumber > 9) {
            return;
        }
        currentNumber = newCurrentNumber;
    }

    public void setMinNumber() {
        currentNumber = 0;
    }

    public void setMaxNumber() {
        currentNumber = 9;
    }

    public void next() {
        if (currentNumber != 9) {
            currentNumber++;  // переключение на следущую станцию
        } else {
            currentNumber = 0;
        }
    }

    public void prev() {
        if (currentNumber != 0) {
            currentNumber--; // переключение на предыдущую станцию
        } else {
            currentNumber = 9;
        }
    }


    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < 0) {  // установка ограничения громкости
            return;
        }
        if (newCurrentVolume > 100) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public void setMinVolume() {
        currentVolume = 0;
    }

    public void setMaxVolume() {
        currentVolume = 100;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++; // увеличение громкости на 1
        } else {
            currentVolume = 100;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--; // уменьшение громкости на 1
        } else {
            currentVolume = 0;
        }
    }
}

