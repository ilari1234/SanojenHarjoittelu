package sovellus;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



// END SOLUTION
public class SanaharjoitteluSovellus extends Application {

    private Sanakirja sanakirja;

    @Override
    public void init() throws Exception{
        this.sanakirja = new Sanakirja();
    }

    @Override
    public void start(Stage ikkuna) throws Exception{
        //luodaan näkymät
        Harjoittelunakyma harjoittelunakyma = new Harjoittelunakyma(sanakirja);
        Syottonakyma syottonakyma = new Syottonakyma(sanakirja);

        //luodaan päätason asettely
        BorderPane asettelu = new BorderPane();

        //luodaan valikko
        HBox valikko = new HBox();
        valikko.setPadding(new Insets(20,20,20,20));
        valikko.setSpacing(10);

        //luodaan ja lisätään napit valikkoon
        Button lisaanappi = new Button("Lisää sanoja");
        Button harjoittelenappi = new Button("Harjoittele");

        valikko.getChildren().addAll(lisaanappi, harjoittelenappi);
        asettelu.setTop(valikko);

        //liitetään alinäkymät nappeihin
        lisaanappi.setOnAction(event -> asettelu.setCenter(syottonakyma.getNakyma()));
        harjoittelenappi.setOnAction(event -> asettelu.setCenter(harjoittelunakyma.getNakyma()));

        //näytetään ensin syöttönäkymä
        asettelu.setCenter(syottonakyma.getNakyma());

        //luodaan päänäkymä ja asetetaan päätason asettelu näkymään
        Scene nakyma = new Scene(asettelu, 400, 300);

        //näytetään sovellus
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }


    public static void main(String[] args) {
        launch(SanaharjoitteluSovellus.class);
    }
}
