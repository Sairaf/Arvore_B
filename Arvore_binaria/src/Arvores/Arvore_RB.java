/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvores;

/**
 *
 * @author LAB1-PC18
 */
public class Arvore_RB extends Arvore_AVL {
    public enum Cor{RED,BLACK};
    
    private Cor cor;

    public Arvore_RB(int dado) {
        super(dado);
        this.cor = Cor.BLACK ;
    }
    
    public Arvore_RB(){
        super();
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
    
    public void criar(){
        setCor(Cor.RED);
    }
    
    
    
}
