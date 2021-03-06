package cn.catherine.data;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "FATHER".
 */
@Entity
public class Father {

    @Id
    private Long id;
    private String hobby;
    private Integer tall;

    @Generated
    public Father() {
    }

    public Father(Long id) {
        this.id = id;
    }

    @Generated
    public Father(Long id, String hobby, Integer tall) {
        this.id = id;
        this.hobby = hobby;
        this.tall = tall;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getTall() {
        return tall;
    }

    public void setTall(Integer tall) {
        this.tall = tall;
    }

    @Override
    public String toString() {
        return "Father{" +
                "id=" + id +
                ", hobby='" + hobby + '\'' +
                ", tall=" + tall +
                '}';
    }
}
