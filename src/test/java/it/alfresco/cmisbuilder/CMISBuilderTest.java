package it.alfresco.cmisbuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.alfresco.cmisbuilder.cmis.CMIS;
import it.alfresco.cmisbuilder.entity.DBComp;
import it.alfresco.cmisbuilder.entity.CMISCondition;
import it.alfresco.cmisbuilder.enums.Operator;
import it.alfresco.cmisbuilder.enums.Type;

public class CMISBuilderTest {
 
	@Test
	public void t1_checkQuery() {
		CMIS cmisQuery = CMIS.withType(Type.CMIS_ALFRESCO);
                
        String query = cmisQuery
        		.SELECT(new DBComp("colonna").aka("cl"))
        		.FROM(new DBComp("table"))
        		.WHERE(new CMISCondition("colonnaX", "213", Operator.EQUALS).fromTable("ll"))
        		.buildQuery();

		assertEquals("SELECT colonna as cl FROM table WHERE ll.colonnaX = '213'", query);
	}

	@Test
	public void t2_checkQueryJoinObjectID() {
		CMIS cmisQuery = CMIS.withType(Type.CMIS_ALFRESCO);
                
        String query = cmisQuery
				.SELECT(new DBComp("colonna").aka("cl"))
				.FROM(new DBComp("table"))
				.JOIN_OBJECTID(new DBComp("j"))
				.WHERE(new CMISCondition("colonnaX", "213", Operator.EQUALS).fromTable("ll"))
				.buildQuery();

		assertEquals("SELECT colonna as cl FROM table JOIN j ON table.cmis:objectId = j.cmis:objectId WHERE ll.colonnaX = '213'", query);
	}

	@Test
	public void t3_checkQueryJoin() {
		CMIS cmisQuery = CMIS.withType(Type.CMIS_ALFRESCO);
                
        String query = cmisQuery
				.SELECT(new DBComp("colonna").aka("cl"))
				.FROM(new DBComp("table"))
				.JOIN(new DBComp("tJoin"), "j")
				.WHERE(new CMISCondition("colonnaX", "213", Operator.EQUALS).fromTable("ll"))
				.buildQuery();

		assertEquals("SELECT colonna as cl FROM table JOIN tJoin ON tJoin.j = table.j WHERE ll.colonnaX = '213'", query);
	}

}