package Controller;
import Model.Menu;
import View.ViewHandler;
import View.ViewMenuOptions;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerMenu implements EventHandler<MouseEvent> {

    /**
     * Attributs du controleur du menu
     */
    private ViewHandler launcher;
    private Menu model;


    /**
     * Constructeur du controleur relatif au menu principal
     *
     * @param launcher (Gestionnaire de vue)
     * @param model    (Modèle correcpondant au menu principal)
     */
    public ControllerMenu(ViewHandler launcher, Menu model) {
        this.model = model;
        this.launcher = launcher;
        this.launcher.setEventHandlerMenu(this);
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getSource().equals(launcher.getMp().getOptions())) {
            launcher.setVueCompleteOptions();
        }
        if (mouseEvent.getSource().equals(launcher.getMo().getRetour())) {
            launcher.setVueCompleteMenu();

        }if (mouseEvent.getSource().equals(launcher.getMp().getQuitter())) {
            launcher.getPrimaryStage().close();

        }if (mouseEvent.getSource().equals(launcher.getMcv().getRetourMenuPrincipale())) {
            launcher.setVueCompleteMenu();

        }if (mouseEvent.getSource().equals(launcher.getMp().getBtnJouer())) {
            launcher.setVueCompleteChoixVaisseaux();
    }
}

}