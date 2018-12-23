package com.ssh.entity;

import javax.persistence.*;

@Entity
@Table(name = "character_function_operation", schema = "mysys", catalog = "")
public class CharacterFunctionOperation {
    private int id;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterFunctionOperation that = (CharacterFunctionOperation) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
