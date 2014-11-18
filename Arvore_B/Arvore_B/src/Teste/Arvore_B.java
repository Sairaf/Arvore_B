/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

/**
 *
 * @author PROPESPINFO
 */
public class Arvore_B {
    private Pagina raiz;
    private int ordem;
    private int numero_Elementos;

    public Arvore_B(int n) {
        this.raiz = new Pagina(n);
        this.ordem = n;
        this.numero_Elementos = 0;
    }

    public Pagina getRaiz() {
        return raiz;
    }

    public void setRaiz(Pagina raiz) {
        this.raiz = raiz;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public int getNumero_Elementos() {
        return numero_Elementos;
    }

    public void setNumero_Elementos(int numero_Elementos) {
        this.numero_Elementos = numero_Elementos;
    }

    public void Insere(int dado){
      if(Busca(raiz, dado) == false)  {
          if(raiz.getTam_Pagina() == 0){
              raiz.getChaves().set(0, dado);
              raiz.setTam_Pagina(raiz.getTam_Pagina()+1);
          }else{
            Pagina aux = raiz;
            if(aux.getTam_Pagina() ==ordem -1){
               Pagina nova = new Pagina(ordem); 
               raiz = nova;
               nova.setE_Folha(false);
               nova.setTam_Pagina(0);
               nova.getFilhos().set(0,aux);
               Dividir_Pagina(nova,aux,0);
               Insere_Pag_NCheia(nova, dado);
            }else{
               Insere_Pag_NCheia(aux, dado); 
            }
          }
          numero_Elementos++;
      }
    }
    
    public void Dividir_Pagina(Pagina pai, Pagina filho, int pos){
     int aux_Div = (int)    Math.floor((ordem -1)/2);
     Pagina aux_Pag = new Pagina(ordem);
     aux_Pag.setE_Folha(filho.isE_Folha());
     aux_Pag.setTam_Pagina(aux_Div);
     
     for(int i = 0; i < aux_Div;i++)  {
         if((ordem -1)% 2 == 0){
             aux_Pag.getChaves().set(i, filho.getChaves().get(i + aux_Div));
         }else{
            aux_Pag.getChaves().set(i, filho.getChaves().get(i + aux_Div+1)); 
         }
         filho.setTam_Pagina(filho.getTam_Pagina()-1);
       }
     
     if(!aux_Pag.isE_Folha()){
         for(int i = 0; i < aux_Div;i++)  {
         if((ordem -1)% 2 == 0){
             aux_Pag.getFilhos().set(i, filho.getFilhos().get(i + aux_Div));
         }else{
            aux_Pag.getFilhos().set(i, filho.getFilhos().get(i + aux_Div+1)); 
         }
         
       }
     } 
     
     filho.setTam_Pagina(aux_Div);
     
     for(int i = pai.getTam_Pagina(); i> pos;i--){
         pai.getFilhos().set(i+1, pai.getFilhos().get(i));
     }
         pai.getFilhos().set(pos+1, aux_Pag);
       
     for(int i = pai.getTam_Pagina(); i> pos;i--){
         pai.getChaves().set(i+1, pai.getChaves().get(i-1));
     }
       
      if ((ordem - 1) % 2 == 0) {
            pai.getChaves().set(pos, filho.getChaves().get(aux_Div - 1));
            filho.setTam_Pagina(filho.getTam_Pagina()- 1);
            
        } else {
            pai.getChaves().set(pos,filho.getChaves().get(aux_Div));
        }

        
        pai.setTam_Pagina(pai.getTam_Pagina()+ 1);

    }
    

    
}
