package com.Errortrece;

interface Playable {
    void play();
    void tune();
}

abstract class Instrument implements Playable {
    public void tune() {
        System.out.println("Tuning instrument");
    }

    abstract void play(int volume);
}

class Guitar extends Instrument {
    public void play() {
        System.out.println("Guitar playing");
    }

    void play(int vol) {
        System.out.println("Guitar volume: " + vol);
    }
}

public class Concert {
    public static void main(String[] args) {
        Playable p = new Guitar();
        p.play();
        ((Instrument)p).play(10);
       
        p.tune();
    }
}

