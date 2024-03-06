package com.zheng.pojo;

public class StudyWord {

    int userid;
    int wordid;

    Word word;


    int exapid;

    Example example;

    int q_0;
    int q_1;
    int q_2;
    int q_3;
    int studycount;
    double ef;
    int day_q_0;
    int day_q_1;
    int day_q_2;
    int day_studycount;
    int intervalday;
    String adddate;
    String laststudydate;
    String nextstudydate;
    int state;

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public Example getExample() {
        return example;
    }

    public void setExample(Example example) {
        this.example = example;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getWordid() {
        return wordid;
    }

    public void setWordid(int wordid) {
        this.wordid = wordid;
    }

    public int getExapid() {
        return exapid;
    }

    public void setExapid(int exapid) {
        this.exapid = exapid;
    }

    public int getQ_0() {
        return q_0;
    }

    public void setQ_0(int q_0) {
        this.q_0 = q_0;
    }

    public int getQ_1() {
        return q_1;
    }

    public void setQ_1(int q_1) {
        this.q_1 = q_1;
    }

    public int getQ_2() {
        return q_2;
    }

    public void setQ_2(int q_2) {
        this.q_2 = q_2;
    }

    public int getQ_3() {
        return q_3;
    }

    public void setQ_3(int q_3) {
        this.q_3 = q_3;
    }

    public int getStudycount() {
        return studycount;
    }

    public void setStudycount(int studycount) {
        this.studycount = studycount;
    }

    public double getEf() {
        return ef;
    }

    public void setEf(double ef) {
        this.ef = ef;
    }

    public int getDay_q_0() {
        return day_q_0;
    }

    public void setDay_q_0(int day_q_0) {
        this.day_q_0 = day_q_0;
    }

    public int getDay_q_1() {
        return day_q_1;
    }

    public void setDay_q_1(int day_q_1) {
        this.day_q_1 = day_q_1;
    }

    public int getDay_q_2() {
        return day_q_2;
    }

    public void setDay_q_2(int day_q_2) {
        this.day_q_2 = day_q_2;
    }

    public int getDay_studycount() {
        return day_studycount;
    }

    public void setDay_studycount(int day_studycount) {
        this.day_studycount = day_studycount;
    }

    public int getIntervalday() {
        return intervalday;
    }

    public void setIntervalday(int intervalday) {
        this.intervalday = intervalday;
    }

    public String getAdddate() {
        return adddate;
    }

    public void setAdddate(String adddate) {
        this.adddate = adddate;
    }

    public String getLaststudydate() {
        return laststudydate;
    }

    public void setLaststudydate(String laststudydate) {
        this.laststudydate = laststudydate;
    }

    public String getNextstudydate() {
        return nextstudydate;
    }

    public void setNextstudydate(String nextstudydate) {
        this.nextstudydate = nextstudydate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "StudyWord{" +
                "userid=" + userid +
                ", wordid=" + wordid +
                ", word=" + word +
                ", exapid=" + exapid +
                ", example=" + example +
                ", q_0=" + q_0 +
                ", q_1=" + q_1 +
                ", q_2=" + q_2 +
                ", q_3=" + q_3 +
                ", studycount=" + studycount +
                ", ef=" + ef +
                ", day_q_0=" + day_q_0 +
                ", day_q_1=" + day_q_1 +
                ", day_q_2=" + day_q_2 +
                ", day_studycount=" + day_studycount +
                ", intervalday=" + intervalday +
                ", adddate='" + adddate + '\'' +
                ", laststudydate='" + laststudydate + '\'' +
                ", nextstudydate='" + nextstudydate + '\'' +
                ", state=" + state +
                '}';
    }
}
