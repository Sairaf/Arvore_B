/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore_b;

import java.util.ArrayList;

/**
 *
 * @author ABGerson
 */
public class Arvore_B {
    private static int d = 5;
    ArrayList <Arvore_B> filhos = new ArrayList<>();
    ArrayList <Integer> chaves = new ArrayList<>();
    Arvore_B pai = null;
    int index;
    /*
    private static final int FILHO_ESQ = 0;
    private static final int FILHO_DIR= 1;

   class Pagina{
       int numChaves;
       Pagina filhos [] = new Pagina[d+1];
       int chaves[] = new int[2*d];
       boolean folha;
   
   
   public int Busca_Binaria(int chave){
       int E_Index = 0;
       int D_Index = numChaves - 1;
       while(E_Index <= D_Index){
           final int M_Index = E_Index+((D_Index - E_Index))/2;
           if(chaves[M_Index] < chave){
            E_Index = M_Index +1;   
           }else if(chaves[M_Index] > chave){
            D_Index = M_Index - 1;  
           }else{
            return M_Index;   
           }
       }
       return -1;
   }
   
   boolean Contem(int chave){
       return Busca_Binaria(chave) != -1;
      }
*/

    
    public ArrayList<Arvore_B> getFilhos() {
        return filhos;
    }

    public void setFilhos(ArrayList<Arvore_B> filhos) {
        this.filhos = filhos;
    }

    public Arvore_B getPai() {
        return pai;
    }

    public void setPai(Arvore_B pai) {
        this.pai = pai;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<Integer> getChaves() {
        return chaves;
    }

    public void setChaves(ArrayList<Integer> chaves) {
        this.chaves = chaves;
    }

    public static int getD() {
        return d;
    }

    public static void setD(int d) {
        Arvore_B.d = d;
    }
        
    
    //========================================
    
    public void Adicionar(Arvore_B pagina,int dado){
        int cont, flag = 0;           
        if(pagina == null){
         pagina = new Arvore_B();
         pagina.chaves.add(dado);                 
         
        }else if(pagina.chaves.size()<Arvore_B.d*2  && Busca(pagina, dado) == false){
 
          for(cont = 0 ; cont < pagina.chaves.size(); cont++){
             if(filhos.get(cont) == null){
                flag = 0;  
                           
              }else{
              flag = 1;   
   
             }
                              
             if(flag == 0){
                          
              Add_Vetor(pagina.chaves, dado);
             }
             
             if(flag == 1){
              Adicionar(pagina.filhos.get(cont), dado);   
             }
          }
          
          
        }else if(Arvore_B.d*2 < pagina.chaves.size()){
          Cisao(pagina,dado);  
        }else if (Busca(pagina, dado) == true){
            System.out.println("Elemento ja existe na pagina\n");
        }
           
        }
       
    public void Add_Vetor(ArrayList <Integer> chaves, int dado){
       int j, aux;
       
        for(j = 0; j <= chaves.size(); j++){
          if(dado < chaves.get(j)){
            aux = chaves.get(j);  
            chaves.add(j, dado);
            dado = aux;
          }
       }
        chaves.add(dado);
    }
    
    public void Cisao(Arvore_B pagina, int dado){
      if(pagina.pai.filhos.size() < d+1)  
      {
       int aux, pos, i;
       Arvore_B filho = new Arvore_B();
       pos = (int) pagina.chaves.size()/2;
       aux = pagina.chaves.get(pos);      
      
       if(pagina.pai == null){
         pagina.pai = new Arvore_B();      
         pagina.pai.filhos.add(pagina);
        }
          
      
      
       for(i = pos+1; i <pagina.chaves.size(); i++){
        filho.chaves.add(i,pagina.chaves.get(i));
        pagina.chaves.remove(i);
       }
        
     
       Adicionar(pagina.pai, aux);
       pagina.chaves.remove(pos);
       pai.filhos.add(filho);
     }else{
       Cisao(pai, dado);   
      }           
    }
    
    public Boolean Busca(Arvore_B pagina, int dado){
      int i,j;
      boolean aux = false;
      if(pagina == null) return false;
          
        if(pagina.chaves.contains(dado) ){
          aux = true;  
        }else{
          for(i = 0; i < pagina.chaves.size();i++)  {
            if(dado < pagina.chaves.get(i)) Busca(pagina.filhos.get(i), dado);
            else Busca(pagina.filhos.get(i+1), dado);              
          }
        }      
       
       return aux;
      }
  
    
    public void F_Remocao(Arvore_B pagina, int dado)        {
        int i,pos,aux;
       if(Busca(pagina,dado) == false){           
           System.out.println("Elemento procurado nao existe"); 
       }else{
         pagina.chaves.remove(dado);
         if(pagina.chaves.size() <= d){             
             aux = pagina.chaves.get(pagina.chaves.size());
           for(i = 0; i < pagina.pai.filhos.size(); i++){
             if(aux<pagina.pai.chaves.get(i))  {
              if(i  == 0){ // se for o primeiro
               Redistribuicao(pagina, pagina.pai.filhos.get(i+1), pagina.pai.chaves.get(pagina.pai.chaves.size()));
              }else if (i == pagina.pai.chaves.size()){ //se for o ultimo
               Redistribuicao(pagina, pagina.pai.filhos.get(i-1), pagina.pai.chaves.get(pagina.pai.chaves.size()));   
              }else{
               Redistribuicao(pagina, pagina.pai.filhos.get(i), pagina.pai.chaves.get(pagina.pai.chaves.size()));      
              }              
             }              
             
           }
           
         }
         
       }
       
    }
    
    
    public void  Redistribuicao(Arvore_B pagina, Arvore_B irmao,int dado){
        int i;
        if(pagina.chaves.size() <= d && irmao.chaves.size() <= d){
        irmao.chaves.add(dado);
        irmao.pai.chaves.remove(irmao.chaves.get(irmao.chaves.size()));
        for(i = 0; i < pagina.chaves.size(); i++){
          irmao.chaves.add(pagina.chaves.get(pagina.chaves.size()));
          pagina.chaves.remove(pagina.chaves.size());          
        }       
    }else{
        while(pagina.chaves.size() <= d){
         pagina.chaves.add(irmao.chaves.get(irmao.chaves.size()));
         irmao.chaves.remove(irmao.chaves.get(irmao.chaves.size()));
        }    
     }
    }

    public static void Escrever(Arvore_B pagina){
        int i, j;
        if(pagina == null){
            System.out.println("Lista vazia\n");  
        }else{
            
        System.out.println("\n");
        System.out.println("[");
        for(i = 0; i < pagina.chaves.size(); i++){
          System.out.println(pagina.chaves.get(i) + " ");  
        }
        System.out.println("]");
        System.out.println("\n");        
        for(i = 0; i < pagina.filhos.size(); i++){
          Escrever(pagina.filhos.get(i));
        }
       } 
    }
    
    public static void main(String[] args) {
       Arvore_B root;
       Arvore_B teste = null;
        teste.Adicionar(teste, 2);
        teste.Adicionar(teste, 2);
        teste.Adicionar(teste, 2);
        Escrever(teste);
    }

    
  }
