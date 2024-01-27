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

	@Override
	public Set<Noeud<T>> getNoeuds() {
		return noeuds;
	}

	@Override
	public Noeud<T> getNoeud(T label) {
		return noeuds.stream().filter(n -> n.getLabel().equals(label)).findFirst().orElse(null);
	}

	@Override
	public int compterArcs() {
		int totalArcs = 0;

		for (Noeud<T> noeud : noeuds) {
			totalArcs += noeud.degre();
		}

		return totalArcs / 2;
	}

	@Override
	public int compterNoeuds() {
		return noeuds.size();
	}

	@Override
	public int degreMax() {
		return noeuds.stream().mapToInt(n -> n.degre()).max().orElse(0);
	}

	@Override
	public boolean ajouterNoeud(Noeud<T> v) {
		if (!noeuds.contains(v)) {
			noeuds.add(v);
			return true;
		}
		return false;
	}

	@Override
	public boolean supprimerNoeud(Noeud<T> v) {
		if (noeuds.contains(v)) {
			noeuds.remove(v);
			return true;
		}
		return false;
	}

	@Override
	public boolean ajouterArc(Noeud<T> v, Noeud<T> w) {

		return false;
	}

	@Override
	public boolean supprimerArc(Noeud<T> v, Noeud<T> w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ajouterNoeud(T label) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimerNoeud(T label) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ajouterArc(T vLabel, T wLabel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimerArc(T vLabel, T wLabel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
