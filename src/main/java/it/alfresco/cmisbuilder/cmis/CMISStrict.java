package it.alfresco.cmisbuilder.cmis;

import org.apache.commons.lang3.StringUtils;

import it.alfresco.cmisbuilder.entity.CMISCondition;
import it.alfresco.cmisbuilder.entity.DBComp;

/**
 * 
 * <h1>CMISStrict.java</h1>
 *
 * <p>
 * Implementazione della classe CMIS che al momento non è supportata e 
 * solleva un'eccezione (UnsupportedOperationException) in fase di costruzione 
 * dei vari componenti della query.
 * </p>
 *
 * @since 1.0.0
 * @version 1.0.0
 * 
 * @author Daniele Del Vecchio
 * @lastUpdate 2026-06-03 - Daniele Del Vecchio
 */
public class CMISStrict extends CMIS {

	private String query = StringUtils.EMPTY;

	@Override
	public String buildQuery() {
		return null;
	}

	@Override
	public CMIS SELECT(DBComp... selectStatement) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public CMIS FROM(DBComp fromStatement) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public CMIS JOIN(DBComp joinStatement, String columnToJoin) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public CMIS JOIN_OBJECTID(DBComp joinStatement) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public CMIS WHERE(CMISCondition whereCondition) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public CMIS AND(CMISCondition andCondition) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public CMIS OR(CMISCondition orCondition) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

}