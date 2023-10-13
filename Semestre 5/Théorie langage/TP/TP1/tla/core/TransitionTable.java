package tla.core;

import java.util.TreeMap;

public class TransitionTable extends TreeMap<State, TreeMap<Symbol, State>> {

    public State get(State q, Symbol a) {
        //Fais moi le code
        
        return null;
    }

    public void put(State q, Symbol a, State p) {
        // TODO
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (State q : this.keySet()) {
            TreeMap<Symbol, State> m = this.get(q);
            if (m == null) {
                continue;
            }
            for (Symbol a : m.keySet()) {
                State p = m.get(a);
                if (p == null) {
                    continue;
                }
                s.append(q).append(" --(").append(a).append(")--> ").append(p).append("\n");
            }
        }
        return s.toString();
    }
}
