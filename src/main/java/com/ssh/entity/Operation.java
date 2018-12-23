package com.ssh.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Operation {
    private int operationid;
    private String name;

    @Id
    @Column(name = "operationid")
    public int getOperationid() {
        return operationid;
    }

    public void setOperationid(int operationid) {
        this.operationid = operationid;
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

        Operation operation = (Operation) o;

        if (operationid != operation.operationid) return false;
        if (name != null ? !name.equals(operation.name) : operation.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = operationid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
