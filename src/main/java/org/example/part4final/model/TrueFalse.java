package org.example.part4final.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "trueFalse")
public class TrueFalse {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Not sure if isFalse is needed but will put it in and comment it out just so we have it
    @Column(name = "trueFalseQuestion")
    private String trueFalseQuestion;
    @Column(name = "true")
    private String isTrue;
    @Column(name = "false")
    private String isFalse;
    @Column(name = "correctAnswer")
    private String correctAnswer;

    public String getTrueFalseQuestion() {
        return trueFalseQuestion;
    }

    public void setTrueFalseQuestion(String trueFalseQuestion) {
        this.trueFalseQuestion = trueFalseQuestion;
    }

    public String getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(String isTrue) {
        this.isTrue = isTrue;
    }

    public String getIsFalse() {
        return isFalse;
    }

    public void setIsFalse(String isFalse) {
        this.isFalse = isFalse;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
