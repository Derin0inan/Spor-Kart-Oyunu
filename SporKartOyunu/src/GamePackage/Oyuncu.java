package GamePackage;

  import java.util.ArrayList;

  
  public class Oyuncu {
      
    private int oyuncuID;
    private int skor;
    private String oyuncuAdi;
    private int kartNo; 
    public Sporcu[] kartListesi = new Sporcu[8];
 
   
    public Oyuncu(){
        oyuncuID = 0;
        skor = 0;
        oyuncuAdi = "";
        
    }
    
     public Oyuncu(int oyuncuID, int skor, String oyuncuAdi){
          this.oyuncuID = oyuncuID;
          this.skor = skor;
          this.oyuncuAdi = oyuncuAdi;
    }

  
     
   public int SkorGoster()
   {
       return getSkor();
   }

 	public void kartEkle(Sporcu kart)
	{
		if (kartSayisi() == 8)
			return;
		 
                if (kart.getClass().getSimpleName().equals("Futbolcu")) {
                for (int i = 0; i < 4; i++)
		{
			if (this.kartListesi[i] == null)
			{
				this.kartListesi[i] = kart;
				break;
			}
		}
            
               }
                else if (kart.getClass().getSimpleName().equals("Basketbolcu"))
                       {
                        for (int i = 4; i < 8; i++)
		{
			if (this.kartListesi[i] == null)
			{
				this.kartListesi[i] = kart;
				break;
			}
		}
                       }
		
	}
     
   public void  kartSec(Sporcu hedef, int kartTuru) 
   {
    
      for (Sporcu kart : this.kartListesi)
		{
			if (kart.getSporcuIsim()== hedef.getSporcuIsim())
			{
				System.out.println(this.getOyuncuAdi() + " " + hedef.getSporcuIsim()+ " kartini kullandi.");
				kart.KartKullanildi();

				break;
			}
		}
  
       
   }
   
   
     

    public boolean kartVarMi(Sporcu hedef)
	{
		if (kartSayisi() == 0)
			return false;

		for (Sporcu kart : this.kartListesi)
		{
			 
			if (kart.getSporcuIsim() == hedef.getSporcuIsim())
			{
				return true;
			}
		}

		 return false;
	}
    
    	public int kartSayisi()
	{
		int count = 0;
		for (Sporcu kart : this.kartListesi)
		{
			if (kart != null && !kart.getKartKullanildiMi()) //get yaptim
				count++;
		}
		return count;
	}
        
   
     
    public int getOyuncuID() {
        return oyuncuID;
    }

   
    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

  
    public int getSkor() {
        return skor;
    }

    
    public void setSkor(int skor) {
        this.skor = skor;
    }

  
    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

  
  
    public int getKartNo() {
        return kartNo;
    }

    public void setKartNo(int kartNo) {
        this.kartNo = kartNo;
    }
    
 
    
     
   
     
}
