package com.ssh.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Function {
    private int functionid;
    private String name;

    @Id
    @Column(name = "functionid")
    public int getFunctionid() {
        return functionid;
    }

    public void setFunctionid(int functionid) {
        this.functionid = functionid;
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

        Function function = (Function) o;

        if (functionid != function.functionid) return false;
        if (name != null ? !name.equals(function.name) : function.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = functionid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
