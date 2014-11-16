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
    private static int d = 20;


    protected ArrayList <Arvore_B> filhos= new ArrayList<>();
    protected ArrayList <Integer> chaves= new ArrayList<>();
    protected Arvore_B pai;
    
    public Arvore_B(){
       int contador;
       filhos = null;                              
       chaves = null;         
       pai = null;
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
        int cont, flag;
        
        if(Arvore_B.d*2 > pagina.chaves.size() && Busca(pagina, dado) == false){
            
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
      for(i = 0 ; i < pagina.chaves.size(); i++){
        if(dado == pagina.chaves.get(i)){
          aux = true;  
        }else if(pagina.filhos.get(i) != null && dado < pagina.chaves.get(i)){
         Busca(pagina.filhos.get(i), dado);
        }else{
          aux = false;
        }            
       }
       return aux;
      }
  
    
            
    public static void main(String[] args) {
        
    }

    
}
