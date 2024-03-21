package adaptateur;
import strategie.CanardInterface;
import strategie.comportementCancan.ComportementCancan;
import strategie.comportementVol.ComportementVol;

public class DindonAdapte implements CanardInterface{
    private Dindon dindon;

    public DindonAdapte(Dindon dindon) {
        this.dindon = dindon;
    }

    public void effectuerCancan() {
        dindon.glouglouter();
    }

    public void effectuerVol() {
        dindon.voler();
    }

    @Override
    public void afficher() {
        dindon.jeSuis();
    }

    @Override
    public void nager() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nager'");
    }

    @Override
    public void setComportementVol(ComportementVol cv) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setComportementVol'");
    }

    @Override
    public void setComportementCancan(ComportementCancan cc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setComportementCancan'");
    }
}
