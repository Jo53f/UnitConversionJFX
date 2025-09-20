package com.mycompany.unitconversionjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Set;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    public static Set<Unit> units;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 250, 250);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        createUnits();
        launch();
    }
    
    /**
     * Create a preset of Units with connections for conversion with their
     * respective conversion functions.
     */
    private static void createUnits(){
        // Metric Distance Unit Objects
        Unit nanometre = new Unit("nanometre");
        Unit micrometre = new Unit("micrometre");
        Unit millimetre = new Unit("millimetre");
        Unit centimetre = new Unit("centimetre");
        Unit metre = new Unit("metre");
        Unit decametre = new Unit("decametre");
        Unit hectometre = new Unit("hectometre");
        Unit kilometre = new Unit("kilometre");
        Unit megametre = new Unit("megametre");
        
        // Imperial Distance Unit Objects
        Unit inch = new Unit("inch");
        Unit foot = new Unit("foot");
        Unit yard = new Unit("yard");
        Unit mile = new Unit("mile");
        
        // Metric Conversion connections
        nanometre.addConversion(micrometre, input -> input/1000);
        micrometre.addConversion(nanometre, input -> input*1000);
        micrometre.addConversion(millimetre, input -> input/1000);
        millimetre.addConversion(micrometre, input -> input*1000);
        millimetre.addConversion(centimetre, input -> input/10);
        centimetre.addConversion(millimetre, input -> input*10);
        centimetre.addConversion(metre, input -> input/100);
        metre.addConversion(centimetre, input -> input*100);
        metre.addConversion(decametre, input -> input/10);
        decametre.addConversion(metre, input -> input*10);
        decametre.addConversion(hectometre, input -> input/10);
        hectometre.addConversion(decametre, input -> input*10);
        hectometre.addConversion(kilometre, input -> input/10);
        kilometre.addConversion(hectometre, input -> input*10);
        kilometre.addConversion(megametre, input -> input/10);
        megametre.addConversion(kilometre, input -> input*10);
        
        // Imperial Conversion connections
        inch.addConversion(foot, input -> input/12);
        foot.addConversion(inch, input -> input*12);
        foot.addConversion(yard, input -> input/3);
        yard.addConversion(foot, input -> input*3);
        yard.addConversion(mile, input -> input/1760);
        mile.addConversion(yard, input -> input*1760);
        
        // Metric and Imperial cross conversion connections
        inch.addConversion(centimetre, input -> input*2.54f);
        centimetre.addConversion(inch, input -> input/2.54f);
        
        units = Set.of(
                nanometre,
                micrometre,
                millimetre,
                centimetre,
                metre,
                decametre,
                hectometre,
                kilometre,
                megametre,
                inch,
                foot,
                yard,
                mile
        );
    }
}