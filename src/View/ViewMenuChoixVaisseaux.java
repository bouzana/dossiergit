package View;

import Controller.ControllerMenu;
import Model.Menu;
import Tools.Path;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class ViewMenuChoixVaisseaux {

    private Button btnMenuP;
    private Button V1;
    private Text titre;
    private ImageView imgBGChoixV;
    private Group root;
    private Menu model;


    public ViewMenuChoixVaisseaux(Menu model, Group root) {
        this.root = root;
        this.model = model;
        initTitre();
        initBackground();

        btnMenuP = initButton(100,100, "Menu principale");
        V1 = Vbutton(110, 200);
    }


    private void initTitre() {
        titre = new Text(15, 180, "Star CityFrag");
        Font policeTitre = Font.loadFont(getClass().getResourceAsStream(Path.fontHeadCase), 80);
        titre.setFont(policeTitre);
        titre.setLayoutX(60);
        titre.setLayoutY(-20);
        titre.setFill(Color.WHITE);
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

    /**
     * Mise en place de l'image de fond en fonction de la taille de l'écran de l'utilisateur
     */
    private void initBackground() {
        imgBGChoixV = new ImageView("Asset/Images/imgMenu.jpg");
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
        imgBGChoixV.setFitHeight((int) primaryScreenBounds.getHeight());
        imgBGChoixV.setFitWidth((int) primaryScreenBounds.getWidth());
    }

    public Button Vbutton(int longeur, int largeur ) {
        ImageView icon = new ImageView("Asset/Images/aegisGladius.png");
        // Création d'un bouton
        Button b = new Button();
        b.setGraphic(icon);
        b.setLayoutX(longeur);
        b.setLayoutY(largeur);
        //b.setText(texteB);
        /* b.setFont(buttonFont);*/

        return b;
    }

    void setImgBGChoixV() {
        root.getChildren().clear();
        root.getChildren().add(imgBGChoixV);
        root.getChildren().add(titre);
        root.getChildren().add(btnMenuP);
        root.getChildren().add(V1);
    }

    void setEvents(ControllerMenu mc) {
        btnMenuP.setOnMouseClicked(mc);
        V1.setOnMouseClicked(mc);
    }

    public Object getRetourMenuPrincipale(){
        return btnMenuP;
    }

}
