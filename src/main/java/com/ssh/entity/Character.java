package com.ssh.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Character {
    private int characterid;
    private String name;

    @Id
    @Column(name = "characterid")
    public int getCharacterid() {
        return characterid;
    }

    public void setCharacterid(int characterid) {
        this.characterid = characterid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character character = (Character) o;

        if (characterid != character.characterid) return false;
        if (name != null ? !name.equals(character.name) : character.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = characterid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
