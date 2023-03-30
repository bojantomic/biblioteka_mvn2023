package rs.ac.bg.fon.ai.biblioteka_mvn.interfejs;

import java.util.List;

import rs.ac.bg.fon.ai.biblioteka_mvn.Autor;
import rs.ac.bg.fon.ai.biblioteka_mvn.Knjiga;


/**
 * Predstavlja biblioteku u koju mogu da se dodaju knjige, pretrazuju i brisu.
 * 
 * @author Bojan Tomic
 * @since 0.9.0
 */
public interface BibliotekaInterfejs {
	
	/**
	 * Dodaje knjigu u biblioteku.
	 * 
	 * Knjiga ne sme biti null, i ne sme biti duplikat.
	 * 
	 * @param knjiga knjiga koju treba dodati u biblioteku
	 * @throws NullPointerException ako je uneta knjiga null
	 * @throws IllegalArgumentException ako uneta knjiga vec postoji u biblioteci
	 */
	public void dodajKnjigu(Knjiga knjiga);
	
	/**
	 * Brise knjigu iz biblioteke.
	 * 
	 * Ako se unese null knjiga ili ako ne postoji u biblioteci,
	 * ne desava se nista.
	 * 
	 * @param knjiga knjiga koju treba obrisati
	 */
	public void obrisiKnjigu(Knjiga knjiga);
	
	/**
	 * Vraca sve knjige iz biblioteke
	 * 	
	 * @return Lista sa svim knjigama
	 * @see biblioteka.Knjiga
	 */
	public List<Knjiga> vratiSveKnjige();
	
	/**
	 * Pretrazuje biblioteku i pronalazi knjige koje odgovaraju
	 * kriterijumima pretrage.
	 * 
	 * Pretrazivanje se radi preko svih kriterijuma koji su uneti a nemaju
	 * null vrednost (-1 za isbn), inace te kriterijum ne uzima u razmatranje.
	 * 
	 * @param autor jedan od autora ili null ako se preskace u pretrazi
	 * @param isbn isbn broj knjige ili -1 ako se preskace u pretrazi
	 * @param naslov deo naslova knjige ili null ako se preskace u pretrazi
	 * @param izdavac deo naziva izdavaca knjige ili null ako se preskace u pretrazi
	 * 
	 * @return Lista sa svim knjigama iz biblioteke koje odgovaraju pretrazi.
	 * Ako nema nijedne knjige koja odgovara kriterijumima, vraca praznu listu.
	 * 
	 * @throws IllegalArgumentException ako su svi kriterijumi 
	 * pretrage izostavljeni (null ili -1)
	 */
	public List<Knjiga> pronadjiKnjigu(Autor autor, 
			long isbn, String naslov, String izdavac);

}
