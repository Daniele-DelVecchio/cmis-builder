package it.alfresco.cmisbuilder.bean.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import it.alfresco.cmisbuilder.bean.JoinStatementBean;
import it.alfresco.cmisbuilder.bean.Pair;
import it.alfresco.cmisbuilder.entity.DBComp;

/**
 * 
 * <h1>CMISUtil.java</h1>
 *
 * <p>
 * Classe di utilità che fornisce metodi helper per la manipolazione di oggetti 
 * e la costruzione di componenti per la query CMIS, come la creazione di bean 
 * per le JOIN o l'estrazione di elementi dalle Pair.
 * </p>
 *
 * @since 1.0.1
 * @version 1.0.1
 * 
 * @author Daniele Del Vecchio
 * @lastUpdate 2026-06-03 - Daniele Del Vecchio
 */
public class CMISUtil {

	/**
	 * 
	 * <h1>composeJoinBean</h1>
	 *
	 * <p>
	 * Compone e restituisce un oggetto JoinStatementBean contenente l'entità 
	 * che fa da join e il nome della colonna in comune su cui effettuare il join.
	 * </p>
	 *
	 * @param joinStatement
	 * @param column
	 * @return
	 *
     * @since 1.0.1
	 * @version 1.0.1
	 * 
	 * @author Daniele Del Vecchio
	 * @lastUpdate 2026-06-03 - Daniele Del Vecchio
	 */
	public static JoinStatementBean composeJoinBean(DBComp joinStatement, String column) {
    	Map<String, String> join = new HashMap<String, String>();
    	join.put(joinStatement.getEntity(), joinStatement.getAlias());
    	return new JoinStatementBean(join, column);
	}
	
	/**
	 * 
	 * <h1>getAlias</h1>
	 *
	 * <p>
	 * Restituisce l'alias associato all'oggetto DBComp. Se l'alias è vuoto o nullo, 
	 * restituisce il nome dell'entità originale.
	 * </p>
	 *
	 * @param dbComp
	 * @return
	 *
	 * @since 1.0.1
	 * @version 1.0.1
	 * 
	 * @author Daniele Del Vecchio
	 * @lastUpdate 2026-06-03 - Daniele Del Vecchio
	 */
	public static String getAlias(DBComp dbComp) {
		return StringUtils.isNotBlank(dbComp.getAlias()) ? dbComp.getAlias() : dbComp.getEntity();
	}
	
	/**
	 * 
	 * <h1>getEntityAsAlias</h1>
	 *
	 * <p>
	 * Restituisce l'entità formattata con il suo alias (ad esempio 'tabella as alias'). 
	 * Se l'alias non è presente, restituisce l'entità originale.
	 * </p>
	 *
	 * @param dbComp
	 * @return
	 *
	 * @since 1.0.1
	 * @version 1.0.1
	 * 
	 * @author Daniele Del Vecchio
	 * @lastUpdate 2026-06-03 - Daniele Del Vecchio
	 */
	public static String getEntityAsAlias(DBComp dbComp) {
		return StringUtils.isNotBlank(dbComp.getEntityAsAlias()) ? dbComp.getEntityAsAlias() : dbComp.getEntity();
	}
	
	/**
	 * 
	 * <h1>getSecondStatement</h1>
	 *
	 * <p>
	 * Restituisce il secondo elemento della tupla (Pair). Se questo risulta nullo o vuoto, 
	 * effettua un fallback restituendo il primo elemento della tupla.
	 * </p>
	 *
	 * @param statement
	 * @return
	 *
	 * @since 1.0.1
	 * @version 1.0.1
	 * 
	 * @author Daniele Del Vecchio
	 * @lastUpdate 2026-06-03 - Daniele Del Vecchio
	 */
	public static String getSecondStatement(Pair<String, String> statement) {
       return StringUtils.isNotBlank(getSecondPairObject(statement)) ? getSecondPairObject(statement) : getFirstPairObject(statement);
	}
	
	/**
	 * 
	 * <h1>getFirstPairObject</h1>
	 *
	 * <p>
	 * Metodo interno per ottenere il primo elemento contenuto all'interno dell'oggetto Pair fornito.
	 * </p>
	 *
	 * @param pair
	 * @return
	 *
	 * @since 1.0.1
	 * @version 1.0.1
	 * 
	 * @author Daniele Del Vecchio
	 * @lastUpdate 2026-06-03 - Daniele Del Vecchio
	 */
    private static String getFirstPairObject(Pair<String, String> pair) {
        return pair.getFirst();
    }

    /**
     * 
     * <h1>getSecondPairObject</h1>
     *
     * <p>
     * Metodo interno per ottenere il secondo elemento contenuto all'interno dell'oggetto Pair fornito.
     * </p>
     *
     * @param pair
     * @return
     *
     * @since 1.0.1
     * @version 1.0.1
     * 
     * @author Daniele Del Vecchio
     * @lastUpdate 2026-06-03 - Daniele Del Vecchio
     */
    private static String getSecondPairObject(Pair<String, String> pair) {
        return pair.getSecond();
    }

    /**
     * 
     * <h1>setPairObject</h1>
     *
     * <p>
     * Crea un oggetto Pair di tipo chiave-valore utilizzando l'entità (come primo elemento)
     * e il suo alias (come secondo elemento) presenti all'interno del DBComp passato in input.
     * </p>
     *
     * @param dbComp
     * @return
     *
     * @since 1.0.1
     * @version 1.0.1
     * 
     * @author Daniele Del Vecchio
     * @lastUpdate 2026-06-03 - Daniele Del Vecchio
     */
    public static Pair<String, String> setPairObject(DBComp dbComp) {
        return new Pair<String, String>(dbComp.getEntity(), dbComp.getAlias());
    }
	
}