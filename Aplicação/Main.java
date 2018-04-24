import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    Mundo m = new Mundo();
   
    
    
    ArrayList <Carro> c = new ArrayList<>();///< vetor de carros
    ArrayList <Moto> b = new ArrayList<>();///< vetor de motos(bike)
    ArrayList <Caminhao> t = new ArrayList<>();///< vetor de caminhoes(truck)
    
    
    
    for(int i=0;i<10;i++){ ///< posiçoes aleatorias para 10 veiculos de cada tipo
    	int carroX = (int)(Math.random()*28)+1; ///< vai ate 30 por causa do eixo x
    	int carroY = (int)(Math.random()*58)+1; ///< vai ate 60 por causa do eixo y
    	int motoX = (int)(Math.random()*28)+1;
    	int motoY = (int)(Math.random()*58)+1;
    	int caminhaoX = (int)(Math.random()*28)+1;
    	int caminhaoY = (int)(Math.random()*58)+1;
    	c.add(i, new Carro( carroX,  carroY, 2));///< adiciona novo objeto carro ao vetor de carros
    	b.add(i, new Moto(motoX, motoY, 3));///< adiciona novo objeto moto ao vetor de motos
    	t.add(i, new Caminhao(caminhaoX, caminhaoY, 1));/** 
    																										* adiciona novo objeto caminhao
    																										* ao vetor de caminhoes
    																										*/

    }
    
    m.criaMundo(b, c, t);
    m.imprimeMundo(b, c, t);
    
     
   
    
    
    
    ///< implementaçao do metodo move
    
   while(true){
   	for(int i=0;i<c.size();i++){
    		c.get(i).move();
    	}
    	for(int i=0;i<b.size();i++){
    		b.get(i).move();
    	}
    	for(int i=0;i<t.size();i++){
    		t.get(i).move();
    	}
    	System.out.println("");
    	m.criaMundo(b, c, t);
    	m.imprimeMundo(b, c, t);
    	m.colisao(b, c, t);
    	m.checaFabrica(b, c, t);
    	
   }
    	
    	
    
    
    
    
  }
}