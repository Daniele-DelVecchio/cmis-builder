package it.alfresco.cmisbuilder.enums;

/**
 * 
 * <h1>Operator.java</h1>
 *
 * <p>
 * Enumerazione degli operatori di confronto (come EQUALS, NOT_EQUALS) supportati
 * durante la generazione delle clausole di condizione (WHERE, AND, OR).
 * </p>
 *
 * @since 1.0.0
 * @version 1.0.1
 * 
 * @author Daniele Del Vecchio
 * @lastUpdate 2026-06-03 - Daniele Del Vecchio
 */
public enum Operator {

    EQUALS(" = "),
    NOT_EQUALS(" != ");
    
    public final String operatorValue;
    
    private Operator(String operatorValue) {
        this.operatorValue = operatorValue;
    }
    
}