/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sam.seila;

/**
 *
 * @author jgmor
 */
public enum TipoMeme {
    
    IRINEU("Irineu", "/img/irineu.jpg"),
    CAPETO("Capeto", "/img/capeto.png"),
    REFLEXAO("Reflexão", "/img/reflexo.png"),
    VD1("Vin Diesel 1", "/img/vd1.png"),
    VD2("Vin Diesel 2", "/img/vd2.png"),
    VD3("Vin Diesel 3", "/img/vd3.png"),
    CHURRAS("Churrasquinho", "/img/churras.jpg");
    
    String nome;
    String diretorio;
    
    TipoMeme(String nome, String diretorio){
        this.nome = nome;
        this.diretorio = diretorio;
    } 

    public String getNome(){
        return nome;
    }
    
    public String getDiretorio(){
        return diretorio;
    }
    
    public static TipoMeme valueOfNome(String nome) {
        for (TipoMeme tipo : values()) {
            if (tipo.nome.equals(nome)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nenhum enum com o nome " + nome);
    }
}
