package GamePackage;


public class Kullanici extends Oyuncu {
   
    
    public Kullanici ()
    {
    //Yapici method (constructor)
    }
    
    public Kullanici(int oyuncuID, int skor, String oyuncuAdi){
         super(oyuncuID, skor, oyuncuAdi);
}

    
      @Override
      public void kartSec(Sporcu hedef, int kartTuru) 
      {
        super.kartSec(hedef, kartTuru);
          // super.kartSec(hangiKartTuru, kartNo);
      }
    
}
    