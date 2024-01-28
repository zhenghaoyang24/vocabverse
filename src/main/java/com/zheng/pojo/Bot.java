package com.zheng.pojo;

public class Bot {

    String botid;
    String botname;
    int likecount;
    int dislikecount;
    float satisfaction;
    int usedcount;

    public String getBotid() {
        return botid;
    }

    public void setBotid(String botid) {
        this.botid = botid;
    }

    public String getBotname() {
        return botname;
    }

    public void setBotname(String botname) {
        this.botname = botname;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

    public int getDislikecount() {
        return dislikecount;
    }

    public void setDislikecount(int dislikecount) {
        this.dislikecount = dislikecount;
    }

    public float getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(float satisfaction) {
        this.satisfaction = satisfaction;
    }

    public int getUsedcount() {
        return usedcount;
    }

    public void setUsedcount(int usedcount) {
        this.usedcount = usedcount;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "botid='" + botid + '\'' +
                ", botname='" + botname + '\'' +
                ", likecount=" + likecount +
                ", dislikecount=" + dislikecount +
                ", satisfaction=" + satisfaction +
                ", usedcount=" + usedcount +
                '}';
    }
}
