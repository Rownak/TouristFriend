package com.example.mainprojecttheraptest;

public class TypeBean {
    
    private Integer idType;
    
    private String name;
   
    private String description;

    public TypeBean() {
    }


    
    public TypeBean(Integer idType, String name, String description) {
        this.idType = idType;
        this.name = name;
        this.description = description;
    }

    
    
    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
   
    
   
    
}
