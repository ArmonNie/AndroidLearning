package com.example.armon.androidlearning.mybean;

/**
 * Created by Armon on 2018/11/6.
 */

public class ApplicationFunction {
    /*
    关于字符串的null与空的区别
     */
    private String functionName;
    private String functionDescription;
    private int functionIndex;

    public ApplicationFunction()
    {
        //this.functionName = null;
        //this.functionDescription = null;
        this.functionName = "null";
        this.functionDescription = "null";
        this.functionIndex = -1;
    }

    public ApplicationFunction(String functionName,String functionDescription,
                               int functionIndex)
    {
        //this.functionName = null;
        //this.functionDescription = null;
        this.functionName = functionName;
        this.functionDescription = functionDescription;
        this.functionIndex = functionIndex;
    }

    public String getFunctionName() {
        return functionName;
    }
    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionDescription() {
        return functionDescription;
    }
    public void setFunctionDescription(String functionDescription) {
        this.functionDescription = functionDescription;
    }

    public int getFunctionIndex() {
        return functionIndex;
    }
    public void setFunctionIndex(int functionIndex) {
        this.functionIndex = functionIndex;
    }
}
