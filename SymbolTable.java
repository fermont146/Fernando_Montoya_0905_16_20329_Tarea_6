/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizador_lexicofm;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author MONTOYA
 */
public class SymbolTable {
     private Map<String, String> symbols;

    public SymbolTable() {
        this.symbols = new HashMap<>();
    }

    public void addSymbol(String name, String type) {
        symbols.put(name, type);
    }

    public String getSymbolType(String name) {
        return symbols.get(name);
    }

    public Map<String, String> getAllSymbols() {
        return symbols;
    }
}
