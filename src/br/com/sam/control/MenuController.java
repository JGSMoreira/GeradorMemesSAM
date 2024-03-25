/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sam.control;

import br.com.sam.seila.TipoMeme;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Joao
 */
public class MenuController implements Initializable {

    @FXML
    private TextField txtsuperior;
    @FXML
    private TextField txtinferior;
    @FXML
    private ComboBox cbTipoMeme;
    
    @FXML
    public void gerarMeme(TipoMeme tipo){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/sam/view/Imagem.fxml"));
            loader.setControllerFactory(c -> {return new ImagemController(txtsuperior.getText(), txtinferior.getText(), tipo);});
            Parent root = loader.load();
            Scene scene = new Scene(root, 590, 633);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("SAM Mememaker - Visualizar Meme");
            stage.show();
            stage.setResizable(false);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void enviaDados(){  
        TipoMeme tipoMeme = TipoMeme.valueOfNome((String) cbTipoMeme.getValue());
        gerarMeme(tipoMeme);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<String> items = FXCollections.observableArrayList();
        
        for (TipoMeme item : TipoMeme.values()){
            items.add(item.getNome());
        }
        
        cbTipoMeme.setItems(items);
        cbTipoMeme.setValue(TipoMeme.IRINEU.getNome());
        
    }    
    
}
