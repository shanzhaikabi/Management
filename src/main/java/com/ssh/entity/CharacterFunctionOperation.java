package com.ssh.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "character_function_operation", schema = "mysys", catalog = "")
public class CharacterFunctionOperation {
    private int id;
    private int characterid;
    private int functionid;
    private int operationid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "characterid", nullable = false)
    public int getCharacterid() {
        return characterid;
    }

    public void setCharacterid(int characterid) {
        this.characterid = characterid;
    }

    @Basic
    @Column(name = "functionid", nullable = false)
    public int getFunctionid() {
        return functionid;
    }

    public void setFunctionid(int functionid) {
        this.functionid = functionid;
    }

    @Basic
    @Column(name = "operationid", nullable = false)
    public int getOperationid() {
        return operationid;
    }

    public void setOperationid(int operationid) {
        this.operationid = operationid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterFunctionOperation that = (CharacterFunctionOperation) o;
        return id == that.id &&
                characterid == that.characterid &&
                functionid == that.functionid &&
                operationid == that.operationid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, characterid, functionid, operationid);
    }
}
