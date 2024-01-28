package com.zheng.pojo;

public class VocBook {
    int id;
    int wordid;
    Word word;
    int bookid;

    public int getWordid() {
        return wordid;
    }

    public void setWordid(int wordid) {
        this.wordid = wordid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    @Override
    public String toString() {
        return "VocBook{" +
                "id=" + id +
                ", wordid=" + wordid +
                ", word=" + word +
                ", bookid=" + bookid +
                '}';
    }
}
