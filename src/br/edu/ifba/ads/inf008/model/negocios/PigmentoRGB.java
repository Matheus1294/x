package br.edu.ifba.ads.inf008.model.negocios;

public class PigmentoRGB extends Pigmento{
	
	private int red;
	private int green;
	private int blue;
	
	public PigmentoRGB(String id, String nome, int quantidade, float preco,int red, int green, int blue) {
		super(id, nome, quantidade, preco);
		this.setRed(red);
		this.setGreen(green);
		this.setBlue(blue);
	}
		 
	 
	private void setRed(int red) {
	   if(red >= 0 && red <= 255)
		this.red = red;
	}
	private void setGreen(int green) {
	   if(green >= 0 && green <= 255)
		this.green = green;
	}
	private void setBlue(int blue) {
	   if(blue >= 0 && blue <= 255)
		this.blue = blue;
	}
	public int getRed() {
		return red;
	}
	public int getGreen() {
		return green;
	}
	public int getBlue() {
		return blue;
	}

	@Override
	public double getDistancia(PigmentoRGB pigRGB) {
		
		double calculo = Math.sqrt(Math.pow(this.operacao(pigRGB.getRed(), this.getRed()), 2) +  Math.pow(this.operacao(pigRGB.getGreen(), this.getGreen()), 2) + Math.pow(this.operacao(pigRGB.getBlue(),this.getBlue()), 2));

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
