package com.ssh.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_character", schema = "mysys", catalog = "")
public class UserCharacter {
    private int id;
    private String userid;
    private int characterid;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userid", nullable = false)
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "characterid", nullable = false)
    public int getCharacterid() {
        return characterid;
    }

    public void setCharacterid(int characterid) {
        this.characterid = characterid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCharacter that = (UserCharacter) o;
        return id == that.id &&
                userid == that.userid &&
                characterid == that.characterid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, characterid);
    }
}
