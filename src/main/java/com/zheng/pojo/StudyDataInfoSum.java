package com.zheng.pojo;

public class StudyDataInfoSum {
    int checkinSum;
    int studyTimesSum;
    int studyDurationSum;
    int studyWordSum;

    public int getCheckinSum() {
        return checkinSum;
    }

    public void setCheckinSum(int checkinSum) {
        this.checkinSum = checkinSum;
    }

    public int getStudyTimesSum() {
        return studyTimesSum;
    }

    public void setStudyTimesSum(int studyTimesSum) {
        this.studyTimesSum = studyTimesSum;
    }

    public int getStudyDurationSum() {
        return studyDurationSum;
    }

    public void setStudyDurationSum(int studyDurationSum) {
        this.studyDurationSum = studyDurationSum;
    }

    public int getStudyWordSum() {
        return studyWordSum;
    }

    public void setStudyWordSum(int studyWordSum) {
        this.studyWordSum = studyWordSum;
    }

    @Override
    public String toString() {
        return "StudyDataInfoSum{" +
                "checkinSum=" + checkinSum +
                ", studyTimesSum=" + studyTimesSum +
                ", studyDurationSum=" + studyDurationSum +
                ", studyWordSum=" + studyWordSum +
                '}';
    }
}
