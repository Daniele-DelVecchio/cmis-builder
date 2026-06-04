package it.alfresco.cmisbuilder.cmis;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import it.alfresco.cmisbuilder.bean.util.CMISUtil;
import it.alfresco.cmisbuilder.constant.CMISConstant;
import it.alfresco.cmisbuilder.entity.CMISCondition;
import it.alfresco.cmisbuilder.entity.DBComp;
import it.alfresco.cmisbuilder.enums.CmisToken;
import it.alfresco.cmisbuilder.enums.Conditions;
import it.alfresco.cmisbuilder.enums.Operator;

/**
 * 
 * <h1>CMISAlfresco.java</h1>
 *
 * <p>
 * Implementazione della classe astratta CMIS, specializzata nella costruzione di query 
 * per Alfresco. Implementa tutti i metodi per formare i vari statement e assembla 
 * la stringa finale.
 * </p>
 *
 * @since 1.0.0
 * @version 1.0.2
 * 
 * @author Daniele Del Vecchio
 * @lastUpdate 2026-06-03 - Daniele Del Vecchio
 */
public class CMISAlfresco extends CMIS {

    private CMISQuery cmisQuery = new CMISQuery();
    private StringBuilder queryBuilder = new StringBuilder();

    @Override
    public String buildQuery() {
        this.cmisQuery.setStringValue(queryBuilder.toString().trim());
        return this.cmisQuery.getStringValue();
    }

    @Override
    public CMIS SELECT(DBComp... selectFields) {
        this.cmisQuery.setSelectStatement(Arrays.stream(selectFields)
                .collect(Collectors.toMap(DBComp::getEntity, DBComp::getAlias)));

        this.queryBuilder.append(CmisToken.SELECT).append(" ")
                .append(Arrays.stream(selectFields)
                        .map(field -> StringUtils.isBlank(field.getEntityAsAlias())
                                ? field.getEntity()
                                : field.getEntityAsAlias())
                        .collect(Collectors.joining(", ")));

        return this;
    }

    @Override
    public CMIS FROM(DBComp fromStatement) {
        this.cmisQuery.setFromStatement(CMISUtil.setPairObject(fromStatement));

        String entity = StringUtils.isBlank(fromStatement.getEntityAsAlias())
                ? fromStatement.getEntity()
                : fromStatement.getEntityAsAlias();

        this.queryBuilder.append(" ")
                .append(CmisToken.FROM).append(" ")
                .append(entity);

        return this;
    }

    @Override
    public CMIS JOIN(DBComp joinStatement, String columnToJoin) {
        this.cmisQuery.setJoinStatement(CMISUtil.composeJoinBean(joinStatement, columnToJoin));

        String entity = CMISUtil.getAlias(joinStatement);
        String entityAsAlias = CMISUtil.getEntityAsAlias(joinStatement);
        String fromStatement = CMISUtil.getSecondStatement(this.cmisQuery.getFromStatement());

        this.queryBuilder.append(" ")
                .append(CmisToken.JOIN).append(" ")
                .append(entity).append(" ")
                .append(CmisToken.ON).append(" ")
                .append(entityAsAlias).append(".")
                .append(columnToJoin).append(Operator.EQUALS.operatorValue)
                .append(fromStatement).append(".")
                .append(columnToJoin);

        return this;
    }

    @Override
    public CMIS JOIN_OBJECTID(DBComp joinStatement) {
        this.cmisQuery.setJoinObjectId(CMISUtil.setPairObject(joinStatement));

        String entity = CMISUtil.getAlias(joinStatement);
        String entityAsAlias = CMISUtil.getEntityAsAlias(joinStatement);
        String fromStatement = CMISUtil.getSecondStatement(this.cmisQuery.getFromStatement());

        this.queryBuilder.append(" ")
                .append(CmisToken.JOIN).append(" ")
                .append(entityAsAlias).append(" ")
                .append(CmisToken.ON).append(" ")
                .append(fromStatement).append(".")
                .append(CMISConstant.CMIS_OBJECT_ID).append(Operator.EQUALS.operatorValue)
                .append(entity).append(".")
                .append(CMISConstant.CMIS_OBJECT_ID);

        return this;
    }

    @Override
    public CMIS WHERE(CMISCondition condition) {
        this.cmisQuery.setWhereStatement(condition.getStringValue());

        this.queryBuilder.append(" ")
                .append(CmisToken.WHERE).append(" ")
                .append(this.cmisQuery.getWhereStatement());

        return this;
    }

    @Override
    public CMIS AND(CMISCondition andCondition) {
        this.queryBuilder.append(" ")
                .append(Conditions.AND).append(" ")
                .append(andCondition.getStringValue());

        return this;
    }

    @Override
    public CMIS OR(CMISCondition orCondition) {
        this.queryBuilder.append(" ")
                .append(Conditions.OR).append(" ")
                .append(orCondition.getStringValue());

        return this;
    }

}