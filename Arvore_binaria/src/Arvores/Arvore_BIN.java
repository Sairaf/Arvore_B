/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvores;

/**
 *
 * @author ELIETE
 */
public class Arvore_BIN {
    
    private int dado;
    
    //===========================
    
    protected Arvore_BIN pai;
    protected Arvore_BIN filho_esquerda;
    protected Arvore_BIN filho_direita;
    
    //====================================

    public Arvore_BIN(int dado) {
        this.dado = dado;
        this.pai = null;
        this.filho_esquerda = null;
        this.filho_direita = null;
    }

    public Arvore_BIN() {
        this.dado = 0;
        this.pai = null;
        this.filho_esquerda = null;
        this.filho_direita = null;
    }
    
    

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }
    
    //===========================================
    
       
    public Arvore_BIN inserir(int dado){
        if (this.dado > dado){
            if (this.filho_esquerda == null){
                this.filho_esquerda = new Arvore_BIN(dado);
                this.filho_esquerda.pai=this;
                return this.filho_esquerda;
            }else
                return this.filho_esquerda.inserir(dado);
        }else if (this.dado < dado){
            if (this.filho_direita == null){
                this.filho_direita = new Arvore_BIN(dado);
                this.filho_direita.pai=this;
                return this.filho_direita;
            }
            return this.filho_direita.inserir(dado);
    }else
            System.out.println("o Dado ja existe !!");
            return null;
    }
    
    
    private Arvore_BIN maior(){
        if (this.filho_direita != null)
            return this.filho_direita.maior();
        else
            return this;
    }
    
    private Arvore_BIN menor(){
        if (this.filho_esquerda != null)
            return this.filho_esquerda.menor();
        else
            return this;
    }
    
    public int getMaior(){
        return this.maior().dado;
    }
    
    public int getMenor(){
        return this.menor().dado;
    }
    
    public Arvore_BIN remover(int dado){
        if (this == null)
            return null;
        
        if (this.dado > dado){
            if (this.filho_esquerda == null){
                System.out.println("Dado nâo encontrado");
                return null;
            }else
                return this.filho_esquerda.remover(dado);
            
        }else if (this.dado < dado){
            if (this.filho_direita == null){
                System.out.println("Dado nâo encontrado");
                return null;
            }else
                return this.filho_direita.remover(dado);
            
        }else if (this.filho_direita == null && this.filho_direita == null){
            if (this.pai.filho_direita.equals(this))
                this.pai.filho_direita = null;
            else
                this.pai.filho_esquerda = null;
            return this;
            
        }else if (this.filho_esquerda == null){
            if (this.pai.filho_direita.equals(this)){
                this.pai.filho_direita=this.filho_direita;
                this.filho_direita.pai=this.pai;
            }else{
                this.pai.filho_esquerda=this.filho_direita;
                this.filho_direita.pai=this.pai;
            }
            return this;//retorna o no removido
            
        }else if (this.filho_direita == null){
            if (this.pai.filho_direita.equals(this)){
                this.pai.filho_direita=this.filho_esquerda;
                this.filho_esquerda.pai=this.pai;
            }else{
                this.pai.filho_esquerda=this.filho_esquerda;
                this.filho_esquerda.pai=this.pai;
            }
            return this;//retorna o no removido
            
        }else{
            Arvore_BIN maior = this.filho_esquerda.maior();
            this.remover(maior.dado);
            maior.filho_direita=this.filho_direita;
            maior.filho_esquerda=this.filho_esquerda;
            maior.pai=this.pai;
            if (this.pai.filho_direita.equals(this))
                this.pai.filho_direita= maior;
            else
                this.pai.filho_esquerda=maior;
            return this;// retorna o no removido
        }
        
    }
    
    public int nivel(){
        if (this == null)
            return 0;
        if (this.filho_direita == null && this.filho_esquerda == null)
            return 1;
        else if (this.filho_direita == null)
            return 1+this.filho_esquerda.nivel();
        else if (this.filho_esquerda == null)
            return 1+this.filho_direita.nivel();
        else if (this.filho_direita.nivel() > this.filho_esquerda.nivel())
                return 1+this.filho_direita.nivel();
        else
            return 1+this.filho_esquerda.nivel();
    }
    
    public void mostrarEm_Ordem(){
        if (this.filho_esquerda != null)
            this.filho_esquerda.mostrarEm_Ordem();
        if (this.pai == null)
            System.out.println("root = "+dado);
        System.out.println(dado);
        if (this.filho_direita != null)
            this.filho_direita.mostrarEm_Ordem();
    }
    
    public void mostrarEm_PosOrdem(){
        if (this==null)
            return;
        this.filho_esquerda.mostrarEm_PosOrdem();
        this.filho_direita.mostrarEm_PosOrdem();
        System.out.println(dado);
    }
    
    public void mostrarEm_PreOrdem(){
        if (this==null)
            return;
        System.out.println(dado);
        this.filho_esquerda.mostrarEm_PreOrdem();
        this.filho_direita.mostrarEm_PreOrdem();
    }
    
    protected void acharPivo(){}
    
    protected void rotacaoEsquerda(){}
    
    protected void rotacaoDireita(){}
    
    
    
}
