package sovellus;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Syottonakyma {

    private Sanakirja sanakirja;

    public Syottonakyma(Sanakirja sanakirja) {
        this.sanakirja = sanakirja;
    }

    public Parent getNakyma() {
        GridPane asettelu = new GridPane();

        Label sanaohje = new Label("Sana");
        TextField sanakentta = new TextField();
        Label kaannosohje = new Label("Käännös");
        TextField kaannoskentta = new TextField();

        asettelu.setAlignment(Pos.CENTER);
        asettelu.setVgap(10);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(10,10,10,10));

        Button lisaanappi = new Button("Lisaa sanapari");

        asettelu.add(sanaohje,0,0);
        asettelu.add(sanakentta, 0,1);
        asettelu.add(kaannosohje,0,2);
        asettelu.add(kaannoskentta, 0,3);
        asettelu.add(lisaanappi,0,4);

        lisaanappi.setOnMouseClicked(event -> {
            String sana = sanakentta.getText();
            String kaannos= kaannoskentta.getText();

            sanakirja.lisaa(sana, kaannos);

            sanakentta.clear();
            kaannoskentta.clear();
        });

        return asettelu;
    }
}
