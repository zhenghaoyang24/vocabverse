package com.zheng.pojo;

public class Daily {
    int userid;
    String time;
    int checkin;
    int searchedword;
    int studyword;
    int studytime;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCheckin() {
        return checkin;
    }

    public void setCheckin(int checkin) {
        this.checkin = checkin;
    }

    public int getSearchedword() {
        return searchedword;
    }

    public void setSearchedword(int searchedword) {
        this.searchedword = searchedword;
    }

    public int getStudyword() {
        return studyword;
    }

    public void setStudyword(int studyword) {
        this.studyword = studyword;
    }

    public int getStudytime() {
        return studytime;
    }

    public void setStudytime(int studytime) {
        this.studytime = studytime;
    }

    @Override
    public String toString() {
        return "Daily{" +
                "userid=" + userid +
                ", time='" + time + '\'' +
                ", checkin=" + checkin +
                ", searchedword=" + searchedword +
                ", studyword=" + studyword +
                ", studytime=" + studytime +
                '}';
    }
}
