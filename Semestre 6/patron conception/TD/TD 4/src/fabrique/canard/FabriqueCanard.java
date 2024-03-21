package fabrique.canard;
import strategie.*;

public abstract class FabriqueCanard {
    public abstract Canard creerCanard(String type);
}
