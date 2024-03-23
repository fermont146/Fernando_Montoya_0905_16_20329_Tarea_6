/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizador_lexicofm;

/**
 *
 * @author JUAN
 */
public class Error {
     private String type;
    private String message;
    private int lineNumber;

    public Error(String type, String message, int lineNumber) {
        this.type = type;
        this.message = message;
        this.lineNumber = lineNumber;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}
