package com.zheng.pojo;

public class Word {
    int wordid;
    String spelling;
    String UKphonetic;
    String USphonetic;
    String paraphrase;
    double frequency;
    int difficulty;

    int studytimes;
    int searchtimes;

    public int getSearchtimes() {
        return searchtimes;
    }

    public void setSearchtimes(int searchtimes) {
        this.searchtimes = searchtimes;
    }

    public int getStudytimes() {
        return studytimes;
    }

    public void setStudytimes(int studytimes) {
        this.studytimes = studytimes;
    }

    public int getWordid() {
        return wordid;
    }

    public void setWordid(int wordid) {
        this.wordid = wordid;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public String getUKphonetic() {
        return UKphonetic;
    }

    public void setUKphonetic(String UKphonetic) {
        this.UKphonetic = UKphonetic;
    }

    public String getUSphonetic() {
        return USphonetic;
    }

    public void setUSphonetic(String USphonetic) {
        this.USphonetic = USphonetic;
    }

    public String getParaphrase() {
        return paraphrase;
    }

    public void setParaphrase(String paraphrase) {
        this.paraphrase = paraphrase;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Word{" +
                "wordid=" + wordid +
                ", spelling='" + spelling + '\'' +
                ", UKphonetic='" + UKphonetic + '\'' +
                ", USphonetic='" + USphonetic + '\'' +
                ", paraphrase='" + paraphrase + '\'' +
                ", frequency=" + frequency +
                ", difficulty=" + difficulty +
                ", studytimes=" + studytimes +
                ", searchtimes=" + searchtimes +
                '}';
    }
}
