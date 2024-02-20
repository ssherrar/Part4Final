package org.example.part4final.model;

import jakarta.persistence.*;

@Entity
@Table(name = "multiChoice")
public class MultiChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "multiChoiceQuestion")
    private String multiChoiceQuestion;
    @Column(name = "a")
    private String a;
    @Column(name = "b")
    private String b;
    @Column(name = "c")
    private String c;
    @Column(name = "d")
    private String d;
    @Column(name = "correctAnswer")
    private String correctAnswer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMultiChoiceQuestion() {
        return multiChoiceQuestion;
    }

    public void setMultiChoiceQuestion(String multiChoiceQuestion) {
        this.multiChoiceQuestion = multiChoiceQuestion;
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

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
