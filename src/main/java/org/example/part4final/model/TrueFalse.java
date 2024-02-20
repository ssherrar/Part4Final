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
    @Column(name = "true")
    private boolean isTrue;

    @Column(name = "false")
    private boolean isFalse;

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public boolean isFalse() {
        return isFalse;
    }

    public void setFalse(boolean aFalse) {
        isFalse = aFalse;
    }
}
