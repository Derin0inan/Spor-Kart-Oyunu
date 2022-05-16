package GamePackage;



public class Basketbolcu extends Sporcu {  //Sporcu sinifindan kalitim (inheratince) alindi
    
    private String basketbolcuAdi;
    private  String basketbolcuTakim;
    private  int ikilik, ucluk, serbestAtis;
    private Boolean kartKullanildiMi;
    
    
    public Basketbolcu() //Anakurucu metod
    {
        basketbolcuAdi="";
        basketbolcuTakim="";
        kartKullanildiMi= false;
        
    }
    public Basketbolcu(String basketbolcuAdi, String basketbolcuTakim,int ikilik, int ucluk, int serbestAtis)
    {
        super(basketbolcuAdi, basketbolcuTakim,0);
       this.basketbolcuAdi = basketbolcuAdi;
       this.basketbolcuTakim = basketbolcuTakim;
       this.ikilik = ikilik;
       this.ucluk = ucluk;
       this.serbestAtis = serbestAtis;
           kartKullanildiMi = false;
    }

    @Override
     public int sporcuPuaniGoster(int poz)
      {
            switch (poz) {
         case 1:
         return getIkilik();
    
        case 2:
         return  getUcluk();
   
       case 3:
        return getSerbestAtis();
       default : 
         return 0;
                  
                 
      }
      }
    
    
   //Encapsul Baslangic 
    public String getBasketbolcuAdi() {
        return basketbolcuAdi;
    }

    
    public void setBasketbolcuAdi(String basketbolcuAdi) {
        this.basketbolcuAdi = basketbolcuAdi;
    }

   
    public String getBasketbolcuTakim() {
        return basketbolcuTakim;
    }

    
    public void setBasketbolcuTakim(String basketbolcuTakim) {
        this.basketbolcuTakim = basketbolcuTakim;
    }

    
    public int getIkilik() {
        return ikilik;
    }

 
    public void setIkilik(int ikilik) {
        this.ikilik = ikilik;
    }

  
    public int getUcluk() {
        return ucluk;
    }

   
    public void setUcluk(int ucluk) {
        this.ucluk = ucluk;
    }

    public int getSerbestAtis() {
        return serbestAtis;
    }

    public void setSerbestAtis(int serbestAtis) {
        this.serbestAtis = serbestAtis;
    }

    public Boolean getKartKullanildiMi() {
        return kartKullanildiMi;
    }

    public void setKartKullanildiMi(Boolean kartKullanildiMi) {
        this.kartKullanildiMi = kartKullanildiMi;
    }
    
    
}
