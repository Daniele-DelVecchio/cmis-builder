package it.alfresco.cmisbuilder.bean;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.ObjectInputStream.GetField;

/**
 * 
 * <h1>Pair.java</h1>
 *
 * <p>
 * Classe generica e immutabile che modella una tupla (o coppia) di oggetti, 
 * offrendo funzionalità di serializzazione e deserializzazione (readObject).
 * Molto utile per raggruppare entità logicamente legate senza dover creare bean ad hoc.
 * </p>
 *
 * @since 1.0.0
 * @version 1.0.1
 * 
 * @author Daniele Del Vecchio
 * @lastUpdate 2026-06-03 - Daniele Del Vecchio
 */
public final class Pair<F, S> implements Serializable {

	private static final long serialVersionUID = -3107968557823829523L;

	private F first;
	private S second;

	public Pair(F first, S second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "(" + this.first + ", " + this.second + ")";
	}

	@SuppressWarnings("unchecked")
	private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
		GetField fields = objectInputStream.readFields();
		
		if (fields.defaulted("first")) {
			
			this.first = (F) fields.get("fFirst", null);
			this.second = (S) fields.get("fSecond", null);
			
		} else {
			
			this.first = (F) fields.get("first", null);
			this.second = (S) fields.get("second", null);
			
		}
	}

	public final F getFirst() {
		return first;
	}

	public final void setFirst(F first) {
		this.first = first;
	}

	public final S getSecond() {
		return second;
	}

	public final void setSecond(S second) {
		this.second = second;
	}

}