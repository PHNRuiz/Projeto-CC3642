import java.util.Random;

public class Veiculo{
	
	protected int x; ///< linha
	protected int y; ///< coluna
	protected int velocidade;///< velocidade
	protected boolean fabrica;///< pra detectar se passa ou nao pela fabrica
	
	
	public Veiculo(int x, int y, int velocidade){ 
		this.x = x;
		this.y = y;
		this.velocidade = velocidade;
		this.fabrica = false; 
	}///< construtor parametrizado
	
	public void setVelo(int velocidade){
		this.velocidade = velocidade;
	}///< set da velocidade
	
	public void setX(int x){ 
		this.x = x;
	}///< set do x
	
	public void setY(int y){ 
		this.y = y;
	}///< set do y
	
	public void setFabrica(boolean fabrica){
		this.fabrica = fabrica;
	}///< set da fabrica
	
	

	public int getVelo(){
		return velocidade;
	}	///< get da velocidade
	
	public int getX(){
		return x;
	}///< get do x
	
	public int getY(){
		return y;
	}///< get do y

	public boolean getFabrica(){
		return fabrica;
	}///< get da fabrica
	
	
	public void move(){
		Random r = new Random();
		int a = r.nextInt(4);///< gera numero aletorio entre 0-3
		if(a==0){///< vai pra cima
			y -= velocidade;
			if(y < 1){///< se y bater na borda de cima, volta pra baixo
				y = 58;
			}
		}
		
		if(a==1){///< vai pra direita
			x += velocidade;
			if(x > 28){///< se x chegar na borda direita, volta pra esquerda
				x = 1;
			}
		}
		
		if(a==2){///< move pra baixo
			y += velocidade;
			if(y > 58){///< se y chegar na borda de baixo, volta pro alto
				y = 1;
			}
		}
		
		if(a==3){///< vai pra esquerda
			x -= velocidade;
			if(x < 1){///< se x chegar na borda esquerda, volta pra direita
				x = 28;
			}
		}
	}
	
	public void checaFabrica(){ /** 
	                              * checa se na posição é área da fábrica,
	                              * se sim faz atributo fabrica ser true
	                              */
		for(int i=4;i<=6;i++){
			for(int j=6; j<=10;j++){
				if(x == i & y== j){
					this.fabrica = true;
				}
			}
		}
		
		for(int i=4;i<=6;i++){
			for(int j=43; j<=47;j++){
				if(x == i & y== j){
					this.fabrica = true;
				}
			}
		}
		
		for(int i=21;i<=23;i++){
			for(int j=6; j<=10;j++){
				if(x == i & y== j){
					this.fabrica = true;
				}
			}
		}
		
		for(int i=21;i<=23;i++){
			for(int j=43; j<=47;j++){
				if(x == i & y== j){
					this.fabrica = true;
				}
			}
		}
		
		for(int i=13;i<=15;i++){
			for(int j=27; j<=33;j++){
				if(x == i & y== j){
					this.fabrica = true;
				}
			}
		}
		
		
	}
}