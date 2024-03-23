/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizador_lexicofm;
/**
 *
 * @author MONTOYA
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzer {
    private String sourceCode;
    private List<Token> tokens;
    private SymbolTable symbolTable;
private List<Error> errors;

    public LexicalAnalyzer(String sourceCode) {
        this.sourceCode = sourceCode;
        this.tokens = new ArrayList<>();
        this.symbolTable = new SymbolTable();
         this.errors = new ArrayList<>();
    }
    
public List<Error> getErrors() {
    return errors;
}
    

    public List<Token> analyze() {
        // Expresiones regulares para reconocer tokens
        Pattern identifierPattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9]{0,14}");
        Pattern integerConstantPattern = Pattern.compile("(?<!\\S)\\d{1,2}(?!\\S)");
        Pattern arithmeticOperatorPattern = Pattern.compile("[+\\-*/]");
        Pattern assignmentOperatorPattern = Pattern.compile(":=");
        Pattern relationalOperatorPattern = Pattern.compile("[>=<]=?|<>|\\{|\\}|\\[\\]|\\(|\\)|,|;");
        Pattern stringPattern = Pattern.compile("[bfhjk]+");
        
        Pattern badIdentifierPattern = Pattern.compile("[^a-zA-Z0-9]+");
        
        String[] lines = sourceCode.split("\n");
        
    int lineNumber = 0;  // Iniciar contador de líneas

        for (String line : lines) {
            Matcher matcher;
            lineNumber++;
            // Identificar y almacenar tokens en la línea
            matcher = identifierPattern.matcher(line);
            while (matcher.find()) {
                String identifier = matcher.group();
                tokens.add(new Token("IDENTIFIER", identifier));
                symbolTable.addSymbol(identifier, "IDENTIFIER");
            }

            matcher = integerConstantPattern.matcher(line);
            while (matcher.find()) {
                tokens.add(new Token("INTEGER_CONSTANT", matcher.group()));
            }

            matcher = arithmeticOperatorPattern.matcher(line);
            while (matcher.find()) {
                tokens.add(new Token("ARITHMETIC_OPERATOR", matcher.group()));
            }

            matcher = assignmentOperatorPattern.matcher(line);
            while (matcher.find()) {
                tokens.add(new Token("ASSIGNMENT_OPERATOR", matcher.group()));
            }

            matcher = relationalOperatorPattern.matcher(line);
            while (matcher.find()) {
                tokens.add(new Token("RELATIONAL_OPERATOR", matcher.group()));
            }

            matcher = stringPattern.matcher(line);
            while (matcher.find()) {
                tokens.add(new Token("STRING", matcher.group()));
            }
            

            Matcher badIdentifierMatcher = badIdentifierPattern.matcher(line);
             while (badIdentifierMatcher.find()) {
             errors.add(new Error("Invalid Identifier", "Identificador mal formado: " + badIdentifierMatcher.group(), lineNumber));
             }
        }

        return tokens;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }
}

