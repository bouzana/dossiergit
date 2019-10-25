package View;

import Controller.ControllerMenu;
import Model.Menu;
import Tools.Path;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;


public class ViewMenuOptions {

    private Text titre;
    private Menu model;
    private ImageView imgBg;
    private ImageView  imgbtn;
    private MediaView bgVideo;
    private Group root;
    private Button btnRetour;

    /**
     * Constructeur du menu principal
     *
     * @param model (Modèle correspondant au menu)
     * @param root  (Groupe principal de la vue)
     */
    ViewMenuOptions(Menu model, Group root) {
        this.root = root;
        this.model = model;
        initTitre();

        btnRetour = initButton(110, 400, "Retour ");
        initBackground();
        setVueCompleteOptions();
    }

    private void initTitre() {
        titre = new Text(15, 100, "Star CityFrag");
        Font policeTitre = Font.loadFont(getClass().getResourceAsStream(Path.fontHeadCase), 80);
        titre.setFont(policeTitre);
        titre.setLayoutX(60);
        titre.setLayoutY(-20);
        titre.setFill(Color.WHITE);
    }

    /**
     * Mise en place de l'image de fond en fonction de la taille de l'écran de l'utilisateur
     */
    private void initBackground() {
        imgBg = new ImageView("Asset/Images/menuOption.gif");
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
        imgBg.setFitHeight((int) primaryScreenBounds.getHeight());
        imgBg.setFitWidth((int) primaryScreenBounds.getWidth());
    }

    public Button initButton(int longeur, int largeur, String texteB) {
        ImageView icon = new ImageView("Asset/Images/btn1.png");
        // Création d'un bouton
        Button b = new Button();
        b.setGraphic(icon);
        b.setLayoutX(longeur);
        b.setLayoutY(largeur);
        b.setText(texteB);

        return b;
    }

    /*private void btnBackground() {
        imgbtn= new ImageView("Asset/Images/btn1.png");

    }*/

    void setVueCompleteOptions() {
        root.getChildren().clear();
        root.getChildren().add(imgBg);
        root.getChildren().add(titre);
        root.getChildren().add(btnRetour);
        /*root2.getChildren().add(imgbtn);*/
    }

    void setEvents(ControllerMenu mc) {
        btnRetour.setOnMouseClicked(mc);
    }

    public Object getRetour() {
        return btnRetour;
    }
    /**
     * Ajoute a la vue tous les éléments composant le menu
     */
}