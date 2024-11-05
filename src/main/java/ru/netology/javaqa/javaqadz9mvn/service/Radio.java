package ru.netology.javaqa.javaqadz9mvn.service;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Radio {

    private int maxNumber = 9;
    private int minNumber;
    private int currentNumber;
    private int maxVolume = 100;
    private int minVolume;
    private int currentVolume;

    public Radio(int size) {
        this.maxNumber = size - 1;
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

