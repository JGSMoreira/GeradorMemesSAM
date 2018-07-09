/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sam.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Joao
 */
public class ImagemController implements Initializable {

    @FXML
    private Label lblsuperior;
    @FXML
    private Label lblinferior;
    @FXML
    private ImageView imgfoto;
    @FXML
    private String tipo;
    @FXML
    private String textosup;
    @FXML
    private String textoinf;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public void receberDados(){
        lblsuperior.setText(textosup);
        lblinferior.setText(textoinf);
        verificaTipo();
    }
    
    public void verificaTipo(){
        if (tipo == "irineu"){
            imgfoto.setImage(new Image("/img/irineu.jpg"));
        }
        if (tipo == "capeto"){
            imgfoto.setImage(new Image("/img/capeto.png"));
        }
        if (tipo == "reflexao"){
            imgfoto.setImage(new Image("/img/reflexo.png"));
        }
        if (tipo == "vd1"){
            imgfoto.setImage(new Image("/img/vd1.png"));
        }
        if (tipo == "vd2"){
            imgfoto.setImage(new Image("/img/vd2.png"));
        }
        if (tipo == "vd3"){
            imgfoto.setImage(new Image("/img/vd3.png"));
        }
    }
    
    public ImagemController(String superior, String inferior, String tipo){
        this.textosup = superior;
        this.textoinf = inferior;
        this.tipo = tipo;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        receberDados();
        imgfoto.setPreserveRatio(false);
        imgfoto.setFitHeight(600);
        imgfoto.setFitWidth(600);
    }    
    
}
