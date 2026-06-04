package it.alfresco.cmisbuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.alfresco.cmisbuilder.cmis.CMIS;
import it.alfresco.cmisbuilder.entity.CMISCondition;
import it.alfresco.cmisbuilder.entity.DBComp;
import it.alfresco.cmisbuilder.enums.Operator;
import it.alfresco.cmisbuilder.enums.Type;

/**
 * 
 * <h1>CMISBuilderTest.java</h1>
 *
 * <p>
 * Classe di test unitari (utilizzando JUnit) che verifica il corretto funzionamento 
 * della logica di costruzione delle query CMIS attraverso le varie API del Builder 
 * (SELECT, FROM, JOIN, WHERE, AND, OR) e i diversi tipi previsti.
 * </p>
 *
 * @since 1.0.0
 * @version 1.0.2
 * 
 * @author Daniele Del Vecchio
 * @lastUpdate 2026-06-03 - Daniele Del Vecchio
 */
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

	@Test
	public void t4_checkQueryMultipleSelect() {
		CMIS cmisQuery = CMIS.withType(Type.CMIS_ALFRESCO);

		String query = cmisQuery
				.SELECT(new DBComp("colonna1").aka("c1"), new DBComp("colonna2"))
				.FROM(new DBComp("table"))
				.WHERE(new CMISCondition("colonnaX", "213", Operator.EQUALS).fromTable("ll"))
				.buildQuery();

		assertEquals("SELECT colonna1 as c1, colonna2 FROM table WHERE ll.colonnaX = '213'", query);
	}

	@Test
	public void t5_checkQueryAndCondition() {
		CMIS cmisQuery = CMIS.withType(Type.CMIS_ALFRESCO);

		String query = cmisQuery
				.SELECT(new DBComp("colonna").aka("cl"))
				.FROM(new DBComp("table"))
				.WHERE(new CMISCondition("colonnaX", "213", Operator.EQUALS).fromTable("ll"))
				.AND(new CMISCondition("colonnaY", "test", Operator.EQUALS).fromTable("ll"))
				.buildQuery();

		assertEquals("SELECT colonna as cl FROM table WHERE ll.colonnaX = '213' AND ll.colonnaY = 'test'", query);
	}

	@Test
	public void t6_checkQueryOrCondition() {
		CMIS cmisQuery = CMIS.withType(Type.CMIS_ALFRESCO);

		String query = cmisQuery
				.SELECT(new DBComp("colonna").aka("cl"))
				.FROM(new DBComp("table"))
				.WHERE(new CMISCondition("colonnaX", "213", Operator.EQUALS).fromTable("ll"))
				.OR(new CMISCondition("colonnaY", "test", Operator.EQUALS).fromTable("ll"))
				.buildQuery();

		assertEquals("SELECT colonna as cl FROM table WHERE ll.colonnaX = '213' OR ll.colonnaY = 'test'", query);
	}

	@Test
	public void t7_checkQueryAndOrConditions() {
		CMIS cmisQuery = CMIS.withType(Type.CMIS_ALFRESCO);

		String query = cmisQuery
				.SELECT(new DBComp("colonna").aka("cl"))
				.FROM(new DBComp("table"))
				.WHERE(new CMISCondition("colonnaX", "213", Operator.EQUALS).fromTable("ll"))
				.AND(new CMISCondition("colonnaY", "test", Operator.EQUALS).fromTable("ll"))
				.OR(new CMISCondition("colonnaZ", "123", Operator.NOT_EQUALS).fromTable("ll"))
				.buildQuery();

		assertEquals("SELECT colonna as cl FROM table WHERE ll.colonnaX = '213' AND ll.colonnaY = 'test' OR ll.colonnaZ != '123'", query);
	}

	@Test
	public void t8_checkQueryStrictUnsupported() {
		CMIS cmisQuery = CMIS.withType(Type.CMIS_STRICT);

		try {
			cmisQuery.SELECT(new DBComp("colonna"));
		} catch (UnsupportedOperationException e) {
			assertEquals("Not implemented yet", e.getMessage());
		}
	}

}