/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sam.control;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Joao
 */
public class ImagemController implements Initializable {

    private String tipo;
    private String textosup;
    private String textoinf;
    private Window janela;
    @FXML
    private Label lblsuperior;
    @FXML
    private Label lblinferior;
    @FXML
    private ImageView imgfoto;
    @FXML
    private Pane painelmeme;

    /**
     * Initializes the controller class.
     */
    
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
    
    @FXML
    public void alterarImagem(){
        FileChooser seletor = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Imagens (*.jpg, *.png)", "*.jpg", "*.jpeg", "*.png");
        seletor.getExtensionFilters().add(extFilter);
        seletor.setTitle("SAM Mememaker - Selecione uma imagem");
        File arquivo = seletor.showOpenDialog(janela);
        Image imagem = new Image(arquivo.toURI().toString());
        imgfoto.setImage(imagem);
        imgfoto.setPreserveRatio(false);
        imgfoto.setFitHeight(600);
        imgfoto.setFitWidth(600);
    }
    
    @FXML
    public void exportarMeme(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens PNG (*.PNG)", "*.png"));

        File file = fileChooser.showSaveDialog(null);

        if(file != null){
            try {
                WritableImage writableImage = new WritableImage((int)painelmeme.getWidth(), (int)painelmeme.getHeight());
                painelmeme.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException ex) { 
                ex.printStackTrace(); 
            }
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
