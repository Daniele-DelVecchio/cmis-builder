package it.alfresco.cmisbuilder.enums;

/**
 * 
 * <h1>CmisToken.java</h1>
 *
 * <p>
 * Enumerazione dei token chiave riservati della sintassi CMIS (SELECT, FROM, JOIN, ON, WHERE).
 * Vengono utilizzati internamente dal costruttore per formare la struttura base della query.
 * </p>
 *
 * @since 1.0.0
 * @version 1.0.1
 * 
 * @author Daniele Del Vecchio
 * @lastUpdate 2026-06-03 - Daniele Del Vecchio
 */
public enum CmisToken {
    
    SELECT("SELECT"),
    FROM("FROM"),
    WHERE("WHERE"),
    JOIN("JOIN"),
    ON("ON"),
    CONTAINS("CONTAINS"),
    GROUP_BY("GROUP BY");
    
    public final String cmisToken;
    
    private CmisToken(String cmisToken) {
        this.cmisToken = cmisToken;
    }

}