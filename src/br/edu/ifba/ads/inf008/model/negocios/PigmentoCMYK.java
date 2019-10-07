package br.edu.ifba.ads.inf008.model.negocios;

public class PigmentoCMYK extends Pigmento{
	
	private int cyan;
	private int magenta;
	private int yellow;
	private int key;
	
  
	public PigmentoCMYK(String id, String nome, int quantidade, float preco, int cyan, int magenta, int yellow, int key) {
		 super(id, nome, quantidade, preco);
		 this.setCyan(cyan);
		 this.setMagenta(magenta);
		 this.setYellow(yellow);
		 this.setKey(key);
	}
	public void setCyan(int cyan) {
	   if(cyan >= 0 && cyan <= 100)	
		this.cyan = cyan;
	}
	public void setMagenta(int magenta) {
	   if(magenta >= 0 && magenta <= 100)	
		this.magenta = magenta;
	}
	public void setYellow(int yellow) {
	   if(yellow >= 0 && yellow <= 100)	
		this.yellow = yellow;
	}
	public void setKey(int key) {
	   if(key >= 0 && key <= 100)
		this.key = key;
	}
	public int getCyan() {
		return cyan;
	}
	public int getMagenta() {
		return magenta;
	}
	public int getYellow() {
		return yellow;
	}
	public int getKey() {
		return key;
	}

	public double getDistancia(PigmentoRGB pigRGB) {
		   
		PigmentoRGB pigRGB2 =  new PigmentoRGB(this.getId(), this.getNome(), this.getQuantidade(), this.getPreco(), (255*(1-(this.getCyan()/100))*(1-(this.getKey()/100))), (255*(1-(this.getMagenta()/100))*(1-(this.getKey()/100))),  (255*(1-(this.getYellow()/100))*(1-(this.getKey()/100))));
 	    
		double calculo = Math.sqrt(Math.pow(this.operacao(pigRGB.getRed(), pigRGB2.getRed()), 2) + Math.pow(this.operacao(pigRGB.getGreen(), pigRGB2.getGreen()), 2) +  Math.pow(this.operacao(pigRGB.getBlue(),pigRGB2.getBlue()), 2));

		return calculo;
	}
	@Override
	public int operacao(int a, int b) {
		
		if(a >= b) {
			
		  return a - b;
			
		}
		
		else if(a < b){
			
		   return b - a;
			
		}
		
		else {
			
		   return 0;
			
		}
		
	}
		
	    
    
}
