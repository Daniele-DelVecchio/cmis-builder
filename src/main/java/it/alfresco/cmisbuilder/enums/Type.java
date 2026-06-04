package it.alfresco.cmisbuilder.enums;

/**
 * 
 * <h1>Type.java</h1>
 *
 * <p>
 * Enumerazione che definisce le differenti tipologie di costruttori CMIS disponibili.
 * Può essere utilizzata per istanziare varianti specifiche del query builder (es. standard o specifico Alfresco).
 * </p>
 *
 * @since 1.0.0
 * @version 1.0.1
 * 
 * @author Daniele Del Vecchio
 * @lastUpdate 2026-06-03 - Daniele Del Vecchio
 */
public enum Type {
	
    CMIS_STRICT,
    CMIS_ALFRESCO;
	
}