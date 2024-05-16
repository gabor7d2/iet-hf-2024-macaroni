package macaroni.actions;

import macaroni.app.gameView.ViewRepository;
import macaroni.model.character.Character;
import macaroni.model.element.Pipe;
import macaroni.model.element.Pump;
import macaroni.views.PumpView;

/**
 * Pumpa kimeneti csőállítási interakciót kezelő osztály.
 */
public class SetPumpOutputAction extends Action {

    /**
     * A karakter, aki az akciót végzi
     */
    private final Character actor;
    /**
     * A pumpa, amin az akciót végzi
     */
    private final Pump pump;

    /**
     * Létrehoz egy SetPumpOutputAction példányt.
     *
     * @param actor A karakter, aki az akciót végzi
     * @param pump A pumpa, amin az akciót végzi
     */
    public SetPumpOutputAction(Character actor, Pump pump) {
        this.actor = actor;
        this.pump = pump;
    }

    /**
     * Ha tudja, elvégzi a paraméterként kapott cső kimeneti csőnek való beállítását.
     *
     * @param pipe a cső, amin action-t szeretnénk végezni.
     * @return Igazzal tér vissza ha sikeres.
     */
    @Override
    public boolean doAction(Pipe pipe) {
        var success = actor.setOutputPipe(pump, pipe);
        if (success) {
            var pumpView = (PumpView) ViewRepository.getViewOfObject(pump);
            pumpView.setOutputPipePos(ViewRepository.getViewOfObject(pipe).getPosition());
        }
        return success;
    }
}
