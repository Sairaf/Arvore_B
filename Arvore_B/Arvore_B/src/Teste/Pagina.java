/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import java.util.Vector;

/**
 *
 * @author PROPESPINFO
 */
public class Pagina {
    private int tam_Pagina;
    private Vector <Pagina> filhos= new Vector<>();
    private Vector <Integer> chaves = new Vector<>();
    private int tam_Filhos;
    private boolean e_Folha;
    
    public Pagina(int tam_Pagina){
      this.chaves = new Vector<Integer>(tam_Pagina- 1); 
       for(int i =0; i<tam_Pagina - 1; i++){
          this.chaves.add(null);
       }
        for(int i =0; i<tam_Pagina; i++){
          this.filhos.add(null);
       }
       this.e_Folha = true;
       this.tam_Pagina = 0;
    }


    public int getTam_Pagina() {
        return tam_Pagina;
    }

    public void setTam_Pagina(int tam_Pagina) {
        this.tam_Pagina = tam_Pagina;
    }

    public Vector <Pagina> getFilhos() {
        return filhos;
    }

    public void setFilhos(Vector <Pagina> filhos) {
        this.filhos = filhos;
    }

    public Vector <Integer> getChaves() {
        return chaves;
    }

    public void setChaves(Vector <Integer> chaves) {
        this.chaves = chaves;
    }

    public int getTam_Filhos() {
        return tam_Filhos;
    }

    public void setTam_Filhos(int tam_Filhos) {
        this.tam_Filhos = tam_Filhos;
    }

    public boolean isE_Folha() {
        return e_Folha;
    }

    public void setE_Folha(boolean e_Folha) {
        this.e_Folha = e_Folha;
    }
    
    
}
