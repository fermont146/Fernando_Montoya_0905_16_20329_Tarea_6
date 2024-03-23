/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.analizador_lexicofm;
import com.mycompany.analizador_lexicofm.*;

import java.util.Scanner;
import java.util.List;
import java.util.Map;
/**
 *
 * @author MONTOYA
 */
public class ANALIZADOR_LEXICOFM {
    
      public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el código fuente:");
        StringBuilder sourceCodeBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) { // Cambié la condición para verificar si la línea está vacía
                break; // Termina si se presiona Enter sin texto
            }
            sourceCodeBuilder.append(line).append("\n");
        }
        scanner.close();

        String sourceCode = sourceCodeBuilder.toString();

        LexicalAnalyzer analyzer = new LexicalAnalyzer(sourceCode);
        List<Token> tokens = analyzer.analyze();

        // Imprimir los tokens encontrados
          System.out.println("\n TOkens");
        for (Token token : tokens) {
            System.out.println(token.getType() + ": " + token.getValue());
        }

        // Imprimir la tabla de símbolos
        System.out.println("\nTabla de Símbolos:");
        SymbolTable symbolTable = analyzer.getSymbolTable();
        for (Map.Entry<String, String> entry : symbolTable.getAllSymbols().entrySet()) {
            System.out.println("Símbolo: " + entry.getKey() + ", Tipo: " + entry.getValue());
        }
        
        if (!analyzer.getErrors().isEmpty()) {
    System.out.println("\nErrores:");
    for (Error error : analyzer.getErrors()) {
        System.out.println("Error [" + error.getLineNumber() + "]: " + error.getMessage());
    }
}
    }
}
