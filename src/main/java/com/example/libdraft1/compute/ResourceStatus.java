package com.example.libdraft1.compute;

public class ResourceStatus {
    String process;
    Boolean status;
    ValueItem valueItem;

    public ResourceStatus(String process, Boolean status, ValueItem valueItem) {
        this.process = process;
        this.status = status;
        this.valueItem = valueItem;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ValueItem getValueItem() {
        return valueItem;
    }

    public void setValueItem(ValueItem valueItem) {
        this.valueItem = valueItem;
    }
}
