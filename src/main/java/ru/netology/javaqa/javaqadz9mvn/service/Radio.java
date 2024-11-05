package ru.netology.javaqa.javaqadz9mvn.service;

public class Radio {

    private int maxNumber;
    private int minNumber;
    private int currentNumber;
    private int maxVolume;
    private int minVolume;
    private int currentVolume;

    public Radio() {
        this.maxNumber = 9;
        this.maxVolume = 100;
    }

    public Radio(int size) {
        this.maxNumber = size - 1;
        //      this.maxVolume = size - 1;   - как вариант установка кол-ва размеров громкости
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getMinNumber() {
        return minNumber;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int newCurrentNumber) {
        if (newCurrentNumber < minNumber) {  // установка ограничения значений радиостанции
            return;
        }
        if (newCurrentNumber > maxNumber) {
            return;
        }
        currentNumber = newCurrentNumber;
    }

    public void next() {
        if (currentNumber != maxNumber) {
            currentNumber++;  // переключение на следущую станцию
        } else {
            currentNumber = minNumber;
        }
    }

    public void prev() {
        if (currentNumber != minNumber) {
            currentNumber--; // переключение на предыдущую станцию
        } else {
            currentNumber = maxNumber;
        }
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < minVolume) {  // установка ограничения громкости
            return;
        }
        if (newCurrentVolume > maxVolume) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume++; // увеличение громкости на 1
        } else {
            currentVolume = maxVolume;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume--; // уменьшение громкости на 1
        } else {
            currentVolume = minVolume;
        }
    }
}

