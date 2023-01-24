package it.alfresco.cmisbuilder.cmis;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import it.alfresco.cmisbuilder.bean.JoinStatementBean;
import it.alfresco.cmisbuilder.bean.Pair;

/**
 * 
 * <h1>CMISQuery.java</h1>
 *
 * <p>
 * </p>
 *
 * @version 1.0.1
 * @since 1.0.0
 * @author Daniele Del Vecchio
 * @lastUpdate 2022-12-21 - Daniele Del Vecchio
 */
public class CMISQuery {

    private Map<String, String> selectStatement = new HashMap<String, String>();
    private Pair<String, String> fromStatement = new Pair<String, String>(StringUtils.EMPTY, StringUtils.EMPTY);
    private JoinStatementBean joinStatement = new JoinStatementBean();
    private Pair<String, String> joinObjectId = new Pair<String, String>(StringUtils.EMPTY, StringUtils.EMPTY);
    private String whereStatement = StringUtils.EMPTY;

    private String queryString = StringUtils.EMPTY;

    public CMISQuery() {
    }

    public Map<String, String> getSelectStatement() {
        return selectStatement;
    }

    public void setSelectStatement(Map<String, String> selectStatement) {
        this.selectStatement = selectStatement;
    }

    public Pair<String, String> getFromStatement() {
        return fromStatement;
    }

    public void setFromStatement(Pair<String, String> fromStatement) {
        this.fromStatement = fromStatement;
    }

    public JoinStatementBean getJoinStatement() {
        return joinStatement;
    }

    public void setJoinStatement(JoinStatementBean joinStatement) {
        this.joinStatement = joinStatement;
    }

    public Pair<String, String> getJoinObjectId() {
        return joinObjectId;
    }

    public void setJoinObjectId(Pair<String, String> joinObjectId) {
        this.joinObjectId = joinObjectId;
    }

    public String getWhereStatement() {
        return whereStatement;
    }

    public void setWhereStatement(String whereStatement) {
        this.whereStatement = whereStatement;
    }

    public String getStringValue() {
        return queryString;
    }

    public void setStringValue(String queryString) {
        this.queryString = queryString;
    }

}