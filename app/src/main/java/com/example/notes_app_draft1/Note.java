package com.example.notes_app_draft1;

public class Note {
    private String personName;
    private String drugName;
    private String drugDosage;
    private String drugFrequency;

    private String drugRoute;

    public Note(String personName, String drugName, String drugDosage, String drugFrequency, String drugRoute) {
        this.personName = personName;
        this.drugName = drugName;
        this.drugDosage = drugDosage;
        this.drugFrequency = drugFrequency;

        this.drugRoute = drugRoute;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugDosage() {
        return drugDosage;
    }

    public void setDrugDosage(String drugDosage) {
        this.drugDosage = drugDosage;
    }

    public String getDrugFrequency() {
        return drugFrequency;
    }

    public void setDrugFrequency(String drugFrequency) {
        this.drugFrequency = drugFrequency;
    }



    public String getDrugRoute() {
        return drugRoute;
    }

    public void setDrugRoute(String drugRoute) {
        this.drugRoute = drugRoute;
    }
}
