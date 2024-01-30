package nonDir;

import java.util.HashSet;
import java.util.Set;

public class GrapheImpl<T> implements Graphe<T> {

	Set<Noeud<T>> noeuds;

	public GrapheImpl() {
		noeuds = new HashSet<Noeud<T>>();
	}

	public GrapheImpl(Set<Noeud<T>> noeuds) {
		this.noeuds = noeuds;
	}

	public Set<Noeud<T>> getNoeuds() {
		return noeuds;
	}

	public Noeud<T> getNoeud(T label) {
		return noeuds.stream().filter(n -> n.getLabel().equals(label)).findFirst().orElse(null);
	}

	public int compterNoeuds() {
		return noeuds.size();
	}

	public boolean ajouterNoeud(Noeud<T> v) {
		if (!noeuds.contains(v)) {
			noeuds.add(v);
			return true;
		}
		return false;
	}

	public boolean supprimerNoeud(Noeud<T> v) {
		if (noeuds.contains(v)) {
			noeuds.remove(v);
			return true;
		}
		return false;
	}

	public int compterArcs() {
		int totalArcs = 0;

		for (Noeud<T> noeud : noeuds) {
			totalArcs += noeud.degre();
		}

		return totalArcs / 2;
	}

	public int degreMax() {
		return noeuds.stream().mapToInt(n -> n.degre()).max().orElse(0);
	}

	public boolean ajouterArc(Noeud<T> v, Noeud<T> w) {
		ajouterNoeud(v);
		ajouterNoeud(w);

		if (!v.getVoisins().contains(w)) {
			v.getVoisins().add(w);
			w.getVoisins().add(v);
			return true;
		}

		return false;
	}

	public boolean supprimerArc(Noeud<T> v, Noeud<T> w) {

		if (v.getVoisins().contains(w)) {
			v.getVoisins().remove(w);
			w.getVoisins().remove(v);
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return "GrapheImpl [noeuds=" + noeuds + "]";
	}

}
