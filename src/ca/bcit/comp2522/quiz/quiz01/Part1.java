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

        for (int hour = 0; hour < hours.size(); i++) {
            if (hours.get(hour) == 1) {
                answer += 2;
            } else if (hours.get(hour) == 2 || hours.get(hour) == 3 || hours.get(hour) == 5) {
                answer += 5;
            } else if (hours.get(hour) == 4) {
                answer += 4;
            } else if (hours.get(hour) == 6 || hours.get(hour) == 0 || hours.get(hour) == 9) {
                answer += 6;
            } else if (hours.get(hour) == 8)
                answer += 7;
        }


    }
}
