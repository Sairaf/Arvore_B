/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvores;

import java.util.Scanner;

/**
 *
 * @author LAB1-PC18
 */
public class Arvore_AVL extends Arvore_BIN{

    public Arvore_AVL(int dado) {
        super(dado);
    }

    public Arvore_AVL() {
        super();
    }
    
    
    //+++++++++++++++++++++++++++++++++++++++++++
    
    @Override
    public void acharPivo(){
        if ((this == null) && (this.pai == null) && (this.pai.filho_direita == null) && (this.pai.filho_esquerda == null))
            return;
        
        if (this.pai.filho_direita.nivel() - this.pai.filho_esquerda.nivel() < 2)
            this.pai.acharPivo();
        else if (this.pai.filho_direita.nivel() - this.pai.filho_esquerda.nivel() >= 2){ //H(d):P > H(e):P
                //desbalanceada com a direita maior p
            
            if (this.getDado() > this.pai.getDado()){ // U é o filho da direita
                if ((this.pai.filho_direita != null) && this.pai.filho_direita.filho_direita.nivel() >= this.pai.filho_direita.filho_esquerda.nivel()){
                    //H(d):U >= H(e):U
                    // RE
                    this.rotacaoEsquerda();
                    
                }else if (this.filho_direita != null){
                    //H(d):U < H(e):U
                    //RDE this.pai.rde()
                    this.rotacaoDuplaEsquerda();
                }
                
            }else if (this.getDado() < this.pai.getDado()){ // U é o filho da esquerda
                if ((this.pai.filho_esquerda != null) && this.pai.filho_esquerda.filho_direita.nivel() >= this.pai.filho_esquerda.filho_esquerda.nivel()){
                    //H(d):U >= H(e):U
                    // RE  this.re()
                    this.rotacaoEsquerda();

                }else if (this.filho_esquerda != null){
                    //H(d):U < H(e):U
                    //RDE
                    this.rotacaoDuplaEsquerda();
                }
            }
        }else if (this.pai.filho_esquerda.nivel() - this.pai.filho_direita.nivel() >= 2){//H(d):P < H(e):P 
            //desbalanceada com a esquerda maior
            
            if (this.getDado() > this.pai.getDado()){ // U é o filho da direita
                if ((this.pai.filho_direita != null) && this.pai.filho_direita.filho_esquerda.nivel() >= this.pai.filho_direita.filho_direita.nivel()){
                    //H(d):U <= H(e):U
                    // RD
                    this.rotacaoDireita();

                }else if (this.filho_direita != null){
                    //H(d):U > H(e):U
                    //RDD
                    this.rotacaoDuplaDireita();
                }

            }else if (this.getDado() < this.pai.getDado()){ // U é o filho da esquerda
                if ((this.pai.filho_esquerda != null) && this.pai.filho_esquerda.filho_esquerda.nivel() >= this.pai.filho_esquerda.filho_direita.nivel()){
                    //H(d):U <= H(e):U
                    // RD
                    this.rotacaoDireita();

                }else if (this.filho_esquerda != null){
                    //H(d):U > H(e):U
                    //RDD
                    this.rotacaoDuplaDireita();
                }
            }               
        }
    }
    
    //===============================================================
    
    //rotações
    @Override
    protected void rotacaoEsquerda(){
        Arvore_AVL auxiliar = (Arvore_AVL) this.filho_esquerda;;
        this.filho_esquerda=this.pai;
        this.filho_esquerda.filho_direita = auxiliar;
        this.pai=this.pai.pai;
        this.filho_esquerda.pai=this;
        
    }
    
    @Override
    protected void rotacaoDireita(){
        Arvore_AVL auxiliar = (Arvore_AVL) this.filho_direita;
        this.filho_direita=this.pai;
        this.pai.filho_esquerda = auxiliar;
        this.pai=this.pai.pai;
        this.filho_direita.pai=this;
    }
    
    
    protected void rotacaoDuplaEsquerda(){
        Arvore_AVL u =(Arvore_AVL) this.filho_esquerda;
        this.filho_esquerda.rotacaoDireita();
        u.rotacaoEsquerda();
    }
    
    protected void rotacaoDuplaDireita(){
        Arvore_AVL u =(Arvore_AVL) this.filho_direita;
        this.filho_direita.rotacaoEsquerda();
        u.rotacaoDireita();
    }
    
    public static void menu(Arvore_AVL arvore){
        Scanner in = new Scanner(System.in);
        int escolha,dado;
        do{
            System.out.println("##############Arvore-AVL###############");
            System.out.println("1- inicializar \n2- inserir sem balancear \n3- inserir e balancear \n4-verificar altura \n5- exibir arvore \n6- remover \n7- sair");
            escolha = in.nextInt();
            switch (escolha){
                case 1:
                    System.out.println("digite o valor da raiz: ");
                    //dado = in.nextInt();
                    arvore = new Arvore_AVL(in.nextInt());
                    System.out.println("arvore inicializada");
                    break;
                case 2:
                    do{
                        System.out.println("Digite o valor do dado: ");
                        dado =in.nextInt();
                        arvore.inserir(dado);
                        System.out.println("Ddeseja continuar?? [1=sim/0=não]");
                        escolha = in.nextInt();
                    }while(escolha == 1);
                    break;
                case 3:
                    do{
                        System.out.println("Digite o valor do dado: ");
                        dado =in.nextInt();
                        arvore.inserir(dado).acharPivo();
                        System.out.println("Ddeseja continuar?? [1=sim/0=não]");
                        escolha = in.nextInt();
                    }while(escolha == 1);
                    break;
                case 4:
                    System.out.println("altura: "+arvore.nivel());
                    break;
                case 5:
                    System.out.println("Arvore:\n\n");
                    break;
                case 6:
                    System.out.println("digite o dado a ser removido: ");
                    dado = in.nextInt();
                    arvore.remover(dado).acharPivo();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("digite um valor valido!!!!!");
                    arvore.mostrarEm_Ordem();
            }
        }while(escolha != 7);
    }
    
    
    
    
}
