package com.example.quizgitfinale;

public class ComicsModel
{
    private String question;
    private int answer;
    private String a;
    private String b;
    private String c;
    private String d;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public ComicsModel(String question, int answer, String a, String b, String c, String d)
    {
        this.question = question;
        this.answer = answer;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}
