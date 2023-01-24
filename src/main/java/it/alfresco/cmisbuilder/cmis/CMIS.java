package it.alfresco.cmisbuilder.cmis;

import it.alfresco.cmisbuilder.entity.DBComp;
import it.alfresco.cmisbuilder.entity.CMISCondition;
import it.alfresco.cmisbuilder.enums.Type;

/**
 * 
 * <h1>CMIS.java</h1>
 *
 * <p>
 * </p>
 *
 * @version 1.0.1
 * @since 1.0.0
 * @author Daniele Del Vecchio
 * @lastUpdate 2022-12-21 - Daniele Del Vecchio
 */
public abstract class CMIS {
    
    public static CMIS withType(Type type) {
        switch(type) {
            case CMIS_STRICT:   return new CMISStrict();
            case CMIS_ALFRESCO: return new CMISAlfresco();
            default:            return new CMISAlfresco();
        }
    }
    
    public abstract CMIS SELECT(DBComp... selectStatement);
    public abstract CMIS FROM(DBComp fromStatement);
    public abstract CMIS JOIN(DBComp joinStatement, String columnToJoin);
    public abstract CMIS JOIN_OBJECTID(DBComp joinStatement);
	public abstract CMIS WHERE(CMISCondition condition);
	public abstract CMIS AND(CMISCondition andCondition);
	public abstract CMIS OR(CMISCondition orCondition);

    public String buildQuery() {
        return null;
    }

}