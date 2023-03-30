package rs.ac.bg.fon.ai.biblioteka_mvn;

import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.biblioteka_mvn.interfejs.BibliotekaInterfejs;

/**
 * Implementacija interfejsa BibliotekaInterfejs u kojoj
 * se koristi ArrayList lista za smestanje knjiga.
 * 
 * @author Bojan Tomic
 * @since 0.9.0
 */
public class Biblioteka implements BibliotekaInterfejs {
	
	/**
	 * ArrayList lista sa svim knjigama iz biblioteke.
	 */
	private List<Knjiga> knjige = new ArrayList<Knjiga>();
	
	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if (knjiga == null)
			throw new NullPointerException("Knjiga ne sme biti null");
		
		if (knjige.contains(knjiga))
			throw new IllegalArgumentException("Knjiga je duplikat");
		
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		knjige.remove(knjiga);
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac) {
		if (autor == null && isbn < 0 && naslov == null && izdavac == null)
			throw new IllegalArgumentException("Morate uneti bar jedan kriterijum");
		
		List<Knjiga> rezultati = new ArrayList<Knjiga>();
		
		if (naslov != null)
		  for(Knjiga k: knjige)
			if (k.getNaslov().toLowerCase().contains(naslov.toLowerCase().trim()))
				rezultati.add(k);		
		
		return rezultati;
	}

}
