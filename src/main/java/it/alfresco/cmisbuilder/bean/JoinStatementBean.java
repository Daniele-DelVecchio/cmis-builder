package it.alfresco.cmisbuilder.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * <h1>JoinStatementBean.java</h1>
 *
 * <p>
 * Bean che modella i parametri necessari per definire una clausola di JOIN.
 * Mantiene la mappa della tabella su cui effettuare il join (comprensiva di alias) 
 * e la colonna che viene utilizzata per l'incrocio dei dati.
 * </p>
 *
 * @since 1.0.0
 * @version 1.0.2
 * 
 * @author Daniele Del Vecchio
 * @lastUpdate 2026-06-03 - Daniele Del Vecchio
 */
public class JoinStatementBean {

	public Map<String, String> join = new HashMap<String, String>();
	public String columnJoin = StringUtils.EMPTY;

	public JoinStatementBean() {
	}
	
	public JoinStatementBean(Map<String, String> join, String columnJoin) {
		this.join = join;
		this.columnJoin = columnJoin;
	}

	public Map<String, String> getJoin() {
		return join;
	}

	public void setJoin(Map<String, String> join) {
		this.join = join;
	}

	public String getColumnJoin() {
		return columnJoin;
	}

	public void setColumnJoin(String columnJoin) {
		this.columnJoin = columnJoin;
	}

	@Override
	public String toString() {
		return "JoinStatementBean [join=" + this.join + ", columnJoin=" + this.columnJoin + "]";
	}

}