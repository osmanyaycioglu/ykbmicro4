package com.ykb.cloud;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private String         description;
    private String         domain;
    private int            cause;
    private List<ErrorObj> errorObjs;

    public ErrorObj() {
    }

    public ErrorObj(final String descriptionParam,
                    final String domainParam,
                    final int causeParam) {
        super();
        this.description = descriptionParam;
        this.domain = domainParam;
        this.cause = causeParam;
    }

    public void addSubError(final ErrorObj objParam) {
        if (this.errorObjs == null) {
            this.errorObjs = new ArrayList<>();
        }
        this.errorObjs.add(objParam);
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String descriptionParam) {
        this.description = descriptionParam;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(final String domainParam) {
        this.domain = domainParam;
    }

    public int getCause() {
        return this.cause;
    }

    public void setCause(final int causeParam) {
        this.cause = causeParam;
    }

    public List<ErrorObj> getErrorObjs() {
        return this.errorObjs;
    }

    public void setErrorObjs(final List<ErrorObj> errorObjsParam) {
        this.errorObjs = errorObjsParam;
    }


}
