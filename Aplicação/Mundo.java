import java.util.ArrayList;

public class Mundo{
	private int mundo[][] = new int[30][60];
	
	
	public void criaMundo(ArrayList<Moto> b, ArrayList<Carro> c, ArrayList<Caminhao> t){
		for(int i=0;i<30;i++){///< i=linhas
			for(int j=0;j<60;j++){///< j=colunas
				mundo[i][j] = 0;///< todo mundo zero
				mundo[0][j] = 1;///< primeira linha de 1
				mundo[29][j] = 1;///< ultima linha de 1
				mundo[i][59] = 1;///< ultima coluna de 1
				mundo[i][0] = 1;///< primeira coluna de 1
				
				
		    if(i == 4 && (j>=6 && j<=10)){
					mundo[i][j] = 2;
				}
				if(i == 5 && (j>=6 && j<=10)){
					mundo[i][j] = 2;
				}
				if(i == 6 && (j>=6 && j<=10)){
					mundo[i][j] = 2;
				}
				
				if(i == 21 && (j>=6 && j<=10)){
					mundo[i][j] = 2;
				}
				if(i == 22 && (j>=6 && j<=10)){
					mundo[i][j] = 2;
				}
				if(i == 23 && (j>=6 && j<=10)){
					mundo[i][j] = 2;
				}
				
				if(i==4 && (j>=43 && j<=47)){
					mundo[i][j] = 2;
				}
				if(i==5 && (j>=43 && j<=47)){
					mundo[i][j] = 2;
				}
				if(i==6 && (j>=43 && j<=47)){
					mundo[i][j] = 2;
				}
				
				if(i == 21 && (j>=43 && j<=47)){
					mundo[i][j] = 2;
				}
				if(i == 22 && (j>=43 && j<=47)){
					mundo[i][j] = 2;
				}
				if(i == 23 && (j>=43 && j<=47)){
					mundo[i][j] = 2;
				}
				
				if(i==13 && (j>=26 && j<=32)){
					mundo[i][j] = 2;
				}
				if(i==14 && (j>=26 && j<=32)){
					mundo[i][j] = 2;
				}
				if(i==15 && (j>=26 && j<=32)){
					mundo[i][j] = 2;
				}///< fabricas
			}
		}
		
		for(int i=0; i<t.size();i++){
    	mundo[t.get(i).getX()][t.get(i).getY()] = 6; ///< joga caminhoes aleatoriamente no mundo
    }
    for(int i=0; i<b.size();i++){
    	mundo[b.get(i).getX()][b.get(i).getY()] = 7; ///< joga motos aleatoriamente no mundo
    }
    for(int i=0; i<c.size();i++){
    	mundo[c.get(i).getX()][c.get(i).getY()] = 8; ///< joga carros aleatoriamente no mundo
    }
    
    
		
	}
	
	public void checaFabrica(ArrayList<Moto> b, ArrayList<Carro> c, ArrayList<Caminhao> t){
    	for(int i=0;i<b.size();i++){
    		b.get(i).checaFabrica();
    		if(b.get(i).fabrica == true){
    			b.add(b.size(), new Moto((int)(Math.random()*28)+1, (int)(Math.random()*58)+1, 3));
    			b.get(i).setFabrica(false);
    			
    		}
    	}
    	
    		for(int i=0;i<c.size();i++){
	    		c.get(i).checaFabrica();
	    		if(c.get(i).fabrica == true){
	    			c.add(c.size(), new Carro((int)(Math.random()*28)+1, (int)(Math.random()*58)+1, 2));
	    			c.get(i).setFabrica(false);
	    		
    		}
    	}
    	
    		for(int i=0;i<t.size();i++){
    			t.get(i).checaFabrica();
    			if(t.get(i).fabrica == true){
    				t.add(t.size(), new Caminhao((int)(Math.random()*28)+1, (int)(Math.random()*58)+1, 1));
    				t.get(i).setFabrica(false);
    			
    		}
    	}
    	
    }///< detecta fabrica e duplica objeto
  
  public void colisao( ArrayList<Moto> b, ArrayList<Carro> c, ArrayList<Caminhao> t){
  	
  	for(int i=0;i<t.size();i++){
  		for(int j=i+1;j<t.size()-1;j++){
  			if(t.get(i).getX() == t.get(j).getX() & t.get(i).getY() == t.get(j).getY()){
  				
  				t.remove(i);
  				t.remove(j);
  				if(i>0)
  					i--;
  				if(j>0)
  					j--;
  				
  			}
  		}
  	
  	}///< caminhao com caminhao: sai os 2
  	
  	for(int i=0;i<c.size();i++){
  		for(int j=i+1;j<c.size()-1;j++){
  			if(c.get(i).getX() == c.get(j).getX() & c.get(i).getY() == c.get(j).getY()){
  				
  				c.remove(i);
  				c.remove(j);
  				if(i>0)
  					i--;
  				if(j>0)
  					j--;
  				
  			}
  		}
   	}///< carro com carro: sai os 2
  	
  	for(int i=0;i<b.size();i++){
  		for(int j=i+1;j<b.size()-1;j++){
  			if(b.get(i).getX() == b.get(j).getX() & b.get(i).getY() == b.get(j).getY()){
  			
  				b.remove(i);
  				b.remove(j);
  				if(i>0)
  					i--;
  				if(j>0)
  					j--;
  			
  			}
  		}
   	}///< moto com moto: sai os 2
   	
   	for(int i=0;i<t.size();i++){
  		for(int j=0;j<c.size();j++){
  			if(t.get(i).getX() == c.get(j).getX() & t.get(i).getY() == c.get(j).getY()){
  			 
  				
  				c.remove(j);
  				if(i>0)
  					i--;
  				if(j>0)
  					j--;	
  	     }
  		 } 
  	 }///< caminhao com carro = carro com caminhao: sai o carro
  
  	 for(int i=0;i<t.size();i++){
  		for(int j=0;j<b.size();j++){
  			if(t.get(i).getX() == b.get(j).getX() & t.get(i).getY() == b.get(j).getY()){
  			  
  				
  				b.remove(j);
  				if(i>0)
  					i--;
  				if(j>0)
  					j--;
  	     }
  		 } 
  	 }	///< caminhao com moto = moto com caminhao: sai a moto
  	 
  	 for(int i=0;i<c.size();i++){
  		for(int j=0;j<b.size();j++){
  			if(c.get(i).getX() == b.get(j).getX() & c.get(i).getY() == b.get(j).getY()){
  			  
  				
  				b.remove(j);
  				if(i>0)
  					i--;
  				if(j>0)
  					j--;
  	     }
  		 } 
  	 } ///< carro com moto = moto com carro: sai a moto
  }///< colisoes  
    
	
	public void imprimeMundo(ArrayList<Moto> b, ArrayList<Carro> c, ArrayList<Caminhao> t){
	
		System.out.println("\n\n\n\n\n\n\n\n");
		for(int i=0; i<30; i++){
			System.out.println("");
			for(int j=0;j<60;j++){
				System.out.printf("%d", mundo[i][j]);
			}
			
		}	///< print do mundo de grades
		System.out.println("");
		System.out.printf("Caminhoes(representados por 6): %d\n", t.size());
		System.out.printf("Motos(representados por 7): %d\n", b.size());
		System.out.printf("Carros(representados por 8): %d\n", c.size());
		
		
		try{
		Thread.sleep(250);
		}
		catch(InterruptedException e){
			
		}
	}
	
	
	
	
}
