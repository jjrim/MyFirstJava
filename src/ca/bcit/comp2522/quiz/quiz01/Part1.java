package ca.bcit.comp2522.quiz.quiz01;

import java.util.ArrayList;

public class Part1 {

    private ArrayList<Integer> hours;
    private ArrayList<Integer> minutes;
    private int answer = 0;

    public Part1() {
        this.hours = new ArrayList<>();
        this.minutes = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
            hours.add(i);
        }

        for (int i = 0; i < 60; i++) {
            minutes.add(i);
        }

        for (int hour : hours) {
            if (hour == 1) {
                answer += 2;
            } else if (hour == 2 || hour == 3 || hour == 5) {
                answer += 5;
            } else if (hour == 4) {
                answer += 4;
            } else if (hour == 6 || hour == 0 || hour == 9) {
                answer += 6;
            } else if (hour == 8)
                answer += 7;
        }


    }
}
