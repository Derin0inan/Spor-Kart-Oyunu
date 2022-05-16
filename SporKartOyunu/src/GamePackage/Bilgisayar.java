package GamePackage;

 
import java.util.Random;
public class Bilgisayar extends  Oyuncu{
    
     public Bilgisayar(){
 //yapici method
      }
     
     public Bilgisayar(int oyuncuID, int skor, String oyuncuAdi){
         super(oyuncuID, skor, oyuncuAdi);         
    }
     
 
     
     
     
    @Override
      public void kartSec(Sporcu hedef, int kartTuru) 
      { 
     
          if (kartTuru==1) { // futbolcu secilecek
              for (int i = 0; i < 4; i++) { //kartListesi 4-8 arasinda bilgisayarın futbolcu kartları var.
                  if (!kartListesi[i].getKartKullanildiMi()) {
                     hedef = kartListesi[i];
                     super.setKartNo(i);
                  }
              }
          }
          
          else if (kartTuru==2) //basketbolcu secilecek
          {
                for (int i = 4; i < 8; i++) { //kartListesi 12 16  arasinda bilgisayarın BASKETBOLCU kartları var.
                  if (!kartListesi[i].getKartKullanildiMi()) {
                     hedef = kartListesi[i];
                       super.setKartNo(i);
                  }
              }
          }
        super.kartSec(hedef, kartTuru);
          
      }
      
      
    
}
