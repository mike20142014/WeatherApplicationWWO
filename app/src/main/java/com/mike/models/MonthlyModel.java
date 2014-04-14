package com.mike.models;

/**
 * Created by MichaelHenry on 4/14/14.
 */
public class MonthlyModel {

    String monthName;
    String avgMaxTemp;
    String avgMinTemp;

    public MonthlyModel(){}

    public MonthlyModel(String monthName,String avgMaxTemp,String avgMinTemp){

        super();
        this.monthName = monthName;
        this.avgMaxTemp = avgMaxTemp;
        this.avgMinTemp = avgMinTemp;

    }

    public String getAvgMaxTemp() {
        return avgMaxTemp;
    }

    public void setAvgMaxTemp(String avgMaxTemp) {
        this.avgMaxTemp = avgMaxTemp;
    }

    public String getAvgMinTemp() {
        return avgMinTemp;
    }

    public void setAvgMinTemp(String avgMinTemp) {
        this.avgMinTemp = avgMinTemp;
    }


    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }


}
