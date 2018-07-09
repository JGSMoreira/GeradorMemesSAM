/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sam.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
    private Button btnirineu;
    @FXML
    private RadioButton rdirineu;
    @FXML
    private ToggleGroup aaa;
    @FXML
    private RadioButton rdreflexao;
    @FXML
    private RadioButton rdvd1;
    @FXML
    private RadioButton rdvd2;
    @FXML
    private RadioButton rdvd3;
    @FXML
    private RadioButton rdcapeto;
    
    @FXML
    public void gerarMeme(String tipo){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/sam/view/Imagem.fxml"));
            loader.setControllerFactory(c -> {return new ImagemController(txtsuperior.getText(), txtinferior.getText(), tipo);});
            Parent root = loader.load();
            Scene scene = new Scene(root, 590, 590);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Visualizar Meme");
            stage.show();
            stage.setResizable(false);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void enviaDados(){
        if(rdcapeto.isSelected()){
            gerarMeme("capeto");
        }
        if(rdirineu.isSelected()){
            gerarMeme("irineu");
        }
        if(rdreflexao.isSelected()){
            gerarMeme("reflexao");
        }
        if(rdvd1.isSelected()){
            gerarMeme("vd1");
        }
        if(rdvd2.isSelected()){
            gerarMeme("vd2");
        }
        if(rdvd3.isSelected()){
            gerarMeme("vd3");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
