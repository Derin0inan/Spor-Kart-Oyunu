package GamePackage;

import java.util.Scanner;
import java.util.Random;
 
 

public class Test {
  
    public static Bilgisayar playerBilgisayar = new Bilgisayar(1,0,"Bilgisayar");   // Bilgisayar ve kullanici nesnesi oluştur
    public static  Kullanici playerMe = new Kullanici(2,0,"Kullanici"); //Bu iki nesne globaldir ve statictir
    public static int kullaniciPozPower=0, bilgisayarPozPower=0; //baslangicta guclerini rastgele verdik fark etmez bu
   
  
    public static void main(String[] args) {
   
         
               
    int i=0;
    int siraKimde=3; // 1 ise kullanici 2 ise bilgisayar 3 ise bekleme durumudur.
    int hangiKart=1; // 1 ise futbolcu 2 ise basketbolcu secilmelidir.
      Sporcu[] kartListesi = new Sporcu[16]; // oyundaki toplam kart sayısı
   
     
    String [] futbolcuAdlari = {"Alex","Hagi","Messi","Totti","Drogba","Demba ba","Ronaldo","Terry"};
    String [] futbolcuTakimlari = {"Galatasaray","Fenerbahçe","Beşiktaş","Trabzon","Lazio","Beckham","Bayern","Beşiktaş"};
    
    String [] basketbolcuAdlari = {"Lebron","Nash","O'Neal","Kobe","Micheal","Stephen","Larry","Tim"};
    String [] basketbolcuTakimlari = {"Los Angeles Lakers","Boston","Anadolu Efes","Golden State","Lazio","Cleveland","Galatasaray","Chicago Bulls"};
    
    Futbolcu temp; //gecici bir nesne olusturduk
    Basketbolcu tempB; //gecici basketbolcu nesnesi olusturduk
    
     for(i=0; i<8; i++)   // 0 - 8 arası futbolcu kartlari doldurduk
      {
         temp = new Futbolcu(futbolcuAdlari[i],futbolcuTakimlari[i],rand(0,100),rand(0,100),rand(0,100));
         kartListesi[i] = temp;
        
       
       }
     
       for(i=8; i<16; i++)    // 8 - 16 arası basket kartlari doldurduk
       {
      tempB = new Basketbolcu(basketbolcuAdlari[i-8],basketbolcuTakimlari[i-8],rand(0,100),rand(0,100),rand(0,100));
      kartListesi[i] = tempB;
     
       }
       
        for (int j = 0; j <4; j++) { // Player 0 1 2 3 >> futbolcu 0 1 2 3 
            playerMe.kartEkle(kartListesi[j]); // 0 1 2 3 PLAYER futbolcu
            
        }
      
           for (int j = 4; j <8; j++) {
            playerBilgisayar.kartEkle(kartListesi[j]); // 4 5 6 7 BILGISAYAR futbolcu
            
        }
           for (int j =8 ; j <12; j++) { // Player 4 5 6 7 >> basketbolcu 0 1 2 3
            playerMe.kartEkle(kartListesi[j]); // 8 9 10 11 PLAYER basketbol 
            
        }
         for (int j =12 ; j <16; j++) {
            playerBilgisayar.kartEkle(kartListesi[j]); // 12 13 14 15 BILGISAYAR basketbol
            
           
        }
         
   
     siraKimde = 1; //sirayi kullanıcıdan baslattık
          while(playerMe.kartSayisi() + playerBilgisayar.kartSayisi()>2) //masada kart oldugu surece
      {
           int pcSecilenKart;   int kullaniciSecilenKart=0;
                if (hangiKart==1) { // futbolcu sirasi ise
                    Scanner input = new Scanner (System.in);
                    System.out.println("Kullanici Kart Sayisi " + playerMe.kartSayisi());
                    if (playerMe.kartSayisi()>=1) { //eger kart varsa
                         do {
                            
                           System.out.print("{0,1,2,3} Futbolcu icin bir kart no giriniz: ");
                  kullaniciSecilenKart = input.nextInt(); /// 0 1 2 3 futbolcu
                    } while (playerMe.kartListesi[kullaniciSecilenKart].getKartKullanildiMi()); //kart kullanılıyosa tekrar dönecek 
                    
                    }
                    
                    else
                    {
                    GameOver(); //kullanıcı kartı yoksa oyunu bitir
                    }
                    System.out.println("**********************************");
                 
                 //playerMe.kartListesi[kullaniciSecilenKart].sporcuPuaniGoster(1)
                   System.out.println("Seçtiğiniz kartın ismi:" +playerMe.kartListesi[kullaniciSecilenKart].getSporcuIsim());
                  if (siraKimde==1) { //sira bende ise
                      siraKimde = 2; // sıra bende ise sıra bilgisayara geçti
                      playerMe.kartSec(playerMe.kartListesi[kullaniciSecilenKart], 1); // secilen kart alındı kartTuru = 1 yani futbolcu gonderildi
                       
                 }
                 
                  if (siraKimde==2) { //sıra pcde ise 
                       playerBilgisayar.kartSec(playerBilgisayar.kartListesi[0], 1); //burda kartListesinden rastgele kart yolluyoruz zaten bilgisayar sınıfında bu kart random degisecek
                         pcSecilenKart = playerBilgisayar.getKartNo(); //random degisen kartın numarasını degiskene atadık
                       
                         System.out.println("Bilgisayarın seçtiği kartın ismi:  " +playerBilgisayar.kartListesi[pcSecilenKart].getSporcuIsim());
                     siraKimde = 1; //sırayı tekrar kullanıcıya gecirdik
                 }
         /* PozisyonBilgisi methodunda pozisyonun nasıl belirlendigi aciklanmstir.*/
     
       
          
           pcSecilenKart = playerBilgisayar.getKartNo();
           PozisyonBilgisi(pcSecilenKart,kullaniciSecilenKart,1);
          if (kullaniciPozPower != bilgisayarPozPower) { //eger gelen gücler farklı ise
                       playerMe.kartListesi[kullaniciSecilenKart].setKartKullanildiMi(Boolean.TRUE); //kartları kullanıldı yapıyoruz
                       playerBilgisayar.kartListesi[pcSecilenKart].setKartKullanildiMi(Boolean.TRUE);
                         Karsilasma();            
             }
              else //eger iki pozisyon gücü esit ise
                 {
                     
                     if (playerMe.kartSayisi() + playerBilgisayar.kartSayisi() <= 2) { //son 2 kart kalmiş
                         System.out.println("Son 2 kart!");
                          for (int j = 1; j < 4; j++) {
                             kullaniciPozPower = playerMe.kartListesi[kullaniciSecilenKart].sporcuPuaniGoster(j);
                             bilgisayarPozPower = playerBilgisayar.kartListesi[pcSecilenKart].sporcuPuaniGoster(j);
                             if(kullaniciPozPower != bilgisayarPozPower)
                             {
                             System.out.println("Son 2 kartta farkli pozisyon bulundu!");
                             Karsilasma();
                                GameOver();
                             }
                             
                             else
                             {
                             System.out.println("Tüm pozisyonlar birbirine eşit, oyun bitirildi");
                                    GameOver();
                             }
                             
                             
                         }
                         
                     }
                    else
                     {
                         //Puanlar esit oldugundan kartlari geri dagittik
                         System.out.println("Puanlar eşit, kartlar geri verildi");
                        playerMe.kartListesi[kullaniciSecilenKart].setKartKullanildiMi(Boolean.FALSE); //set yaptim
                       playerBilgisayar.kartListesi[pcSecilenKart].setKartKullanildiMi(Boolean.FALSE);
                     
                     }
                 }      
                 hangiKart = 2; // sira basketbolda
               }
             
                
         else //basketbolcu sirasi ise
             {
                      Scanner input = new Scanner (System.in);
               do {
                          System.out.print("{4,5,6,7} Basketbolcu icin kart no giriniz: ");
                   kullaniciSecilenKart = input.nextInt();    
                    } while (playerMe.kartListesi[kullaniciSecilenKart].getKartKullanildiMi() && ikisiArasindaMi(kullaniciSecilenKart,4,7));
                                    
                           
                 System.out.println("Bir kart seçtiniz!"); //playerMe.kartListesi[kullaniciSecilenKart].sporcuPuaniGoster(1)
                   System.out.println("Seçtiğiniz kartın ismi:" +playerMe.kartListesi[kullaniciSecilenKart].getSporcuIsim());
                            
               if (siraKimde==1) { //sira pcde ise
                      playerMe.kartSec(playerMe.kartListesi[kullaniciSecilenKart], 2); // 20 yerine secilen kart
                       siraKimde = 2;
                 }
                 
                  if (siraKimde==2) {
                       playerBilgisayar.kartSec(playerBilgisayar.kartListesi[2], 2);
                         System.out.println("Bilgisayar bir kart seçti!");
                         pcSecilenKart = playerBilgisayar.getKartNo();
                         System.out.println("Bilgisayarın seçtiği kartın ismi:  " +playerBilgisayar.kartListesi[pcSecilenKart].getSporcuIsim());
                       
                     siraKimde = 1;
                 }
                 
                 
                 
           
           pcSecilenKart = playerBilgisayar.getKartNo();
           PozisyonBilgisi(pcSecilenKart,kullaniciSecilenKart,2);
          if (kullaniciPozPower != bilgisayarPozPower) {
                      playerMe.kartListesi[kullaniciSecilenKart].KartKullanildi();
                       playerBilgisayar.kartListesi[pcSecilenKart].KartKullanildi();
                         Karsilasma();            
             }
              else
                 {
                     
                     if (playerMe.kartSayisi() + playerBilgisayar.kartSayisi() <= 2) { //son 2 kart kalmiş
                         System.out.println("Son 2 kart!");
                          for (int j = 1; j < 4; j++) {
                             kullaniciPozPower = playerMe.kartListesi[kullaniciSecilenKart].sporcuPuaniGoster(j);
                             bilgisayarPozPower = playerBilgisayar.kartListesi[pcSecilenKart].sporcuPuaniGoster(j);
                             if(kullaniciPozPower != bilgisayarPozPower)
                             {
                             System.out.println("Son 2 kartta farkli pozisyon bulundu!");
                             Karsilasma();
                                GameOver();
                             }
                             
                             else
                             {
                             System.out.println("Tüm pozisyonlar birbirine eşit, oyun bitirildi");
                                    GameOver();
                             }
                             
                             
                         }
                         
                     }
                    else
                     {
                         //Puanlar esit oldugundan kartlari geri dagittik
                         System.out.println("Puanlar eşit, kartlar geri verildi");
                        playerMe.kartListesi[kullaniciSecilenKart].setKartKullanildiMi(Boolean.FALSE); //set yaptim
                       playerBilgisayar.kartListesi[pcSecilenKart].setKartKullanildiMi(Boolean.FALSE);
                     
                     }
                 }      
                 hangiKart = 1; // sira basketbolda
                 
  }    
             
         
         
         
      }
       
  GameOver();
    }
    
   static int rand(int min, int max) //static e bir nesne olmadan da ulasabilirim. 
    {
         int randSayi = (int)(Math.random() * (max - min + 1) + min);
        return randSayi;
    }
//   
//}
//   
   public static void PozisyonBilgisi(int pcSecilenKart, int kullaniciSecilenKart, int kartTuru)
   {
//  Random rand = new Random();
//       int randSayi = rand.nextInt(4 - 1) + 1;
    int randSayi = rand(1,3);
        if (kartTuru == 1) {
           switch(randSayi)
           {
                   case 1:
                   System.out.println("Secilen pozisyon penalti!!");
                   break;
                   
                   case 2:
                   System.out.println("Secilen pozisyon serbest atis!");
                   break;
                   case 3:
                   System.out.println("Secilen pozisyon kaleci ile karsi karsiya!!");
                   break;
           }
                  
       }
        
        else if(kartTuru == 2)
        {
                    switch(randSayi)
           {
                   case 1:
                   System.out.println("Secilen pozisyon ikilik!!");
                   break;
                   
                   case 2:
                   System.out.println("Secilen pozisyon ucluk");
                   break;
                   case 3:
                   System.out.println("Secilen pozisyon serbest atis");
                   break;
           }
        }
        
        kullaniciPozPower = playerMe.kartListesi[kullaniciSecilenKart].sporcuPuaniGoster(randSayi);
        bilgisayarPozPower = playerBilgisayar.kartListesi[pcSecilenKart].sporcuPuaniGoster(randSayi);
        
         
   }
   
    
   
   public static void Karsilasma()
   {
       if (kullaniciPozPower > bilgisayarPozPower) {
           playerMe.setSkor(playerMe.getSkor() + 10);
        System.out.println("Kart puani kullaniciya gidiyor!");
       }
       else if (bilgisayarPozPower > kullaniciPozPower) {
           playerBilgisayar.setSkor(playerBilgisayar.getSkor() + 10);
               System.out.println("Kart puani bilgisayara gidiyor!");
       }
             System.out.println("Kullanici Puani : "+playerMe.getSkor()+" Bilgisayar Puani : " + playerBilgisayar.getSkor());
       
   }
   
   public void KartlariEkrandaGoster()
   {
       //Swing yetismedigi icin bos kaldi...
   }
 
   
   public static void GameOver()
   {
           System.out.println("oyun sona erdi...");
       if (playerMe.getSkor()> playerBilgisayar.getSkor()) {
               System.out.println("Kazanan, "+playerMe.getOyuncuAdi());
       }
       
       else if (playerMe.getSkor()< playerBilgisayar.getSkor()) {
               System.out.println("Kazanan, "+playerBilgisayar.getOyuncuAdi());
       }
   
   }
   
   
   public static Boolean ikisiArasindaMi(int sayi, int birinci, int ikinci)
   {
       if (sayi>=birinci && sayi<=ikinci) {
           return true;
       }
       return false;
   }
}