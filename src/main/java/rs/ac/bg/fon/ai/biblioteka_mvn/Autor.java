package rs.ac.bg.fon.ai.biblioteka_mvn;

import java.util.Objects;

/**
 * Predstavlja autora knjige.
 * 
 * Autor ima ime i prezime, ali nema identifikator.
 * 
 * @author Bojan Tomic
 * @since 0.1.0
 */
public class Autor {
	
	/**
	 * Ime autora kao String.
	 */
	private String ime;
	
	/**
	 * Prezime autora kao String.
	 */	
	private String prezime;

	/**
	 * Vraca ime autora.
	 * 
	 * @return ime autora kao String
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja ime autora.
	 * 
	 * Ime autora ne smi biti null niti prazan String.
	 * 
	 * @param ime novo ime autora
	 * 
	 * @throws NullPointerException ako je uneto ime null
	 * @throws IllegalArgumentException ako je uneto ime prazan String
	 */
	public void setIme(String ime) {
		if (ime == null)
			throw new NullPointerException("Ime ne sme biti null");
		
		if (ime.isEmpty())
			throw new IllegalArgumentException("Ime ne sme biti prazno");
		
		this.ime = ime;
	}

	/**
	 * Vraca prezime autora.
	 * 
	 * @return prezime autora kao String
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja prezime autora.
	 * 
	 * Prezime autora ne smi biti null niti prazan String.
	 * 
	 * @param prezime novo prezime autora
	 * 
	 * @throws NullPointerException ako je uneto preziime null
	 * @throws IllegalArgumentException ako je uneto prezime prazan String
	 */
	public void setPrezime(String prezime) {
		if (prezime == null)
			throw new NullPointerException("Prezime ne sme biti null");
		
		if (prezime.isEmpty())
			throw new IllegalArgumentException("Prezime ne sme biti prazno");

		this.prezime = prezime;
	}

	@Override
	public String toString() {
		return ime + ", " + prezime;
	}

	/**
	 * Izracunava hash code na osnovu imena i prezimena.
	 * 
	 * @return hash code izracunat na osnovu imena i prezimena
	 */
	@Override
	public int hashCode() {
		return Objects.hash(ime, prezime);
	}

	/**
	 * Poredi dva autora prema imenu i prezimenu.
	 * 
	 * @param obj drugi autor - sa kojim se poredi
	 * 
	 * @return
	 * <ul>
	 * <li>true - ako je unet isti objekat ili ako su ime i prezime isti</li>
	 * <li>false - ako je unet null objekat ili objekat nije klase Autor ili ime i/ili prezime nisu isti</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(ime, other.ime) && Objects.equals(prezime, other.prezime);
	}

}
