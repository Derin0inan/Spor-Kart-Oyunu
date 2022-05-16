package GamePackage;


public class Futbolcu extends Sporcu {
    
    private String futbolcuAdi;
    private  String futbolcuTakim;
    private int penalti, serbestAtis, kaleciKarsiKarsiya;
    private   Boolean kartKullanildiMi;
    
    public Futbolcu()
    {
        
        futbolcuAdi = "";
        futbolcuTakim = "";
        kartKullanildiMi= false;
    }
    
    public Futbolcu(String futbolcuAdi, String futbolcuTakim,int penalti, int serbestAtis, int kaleciKarsiKarsiya)
    {
        super(futbolcuAdi, futbolcuTakim,0);

       this.futbolcuAdi = futbolcuAdi;
       this.futbolcuTakim = futbolcuTakim;
       this.penalti = penalti;
       this.serbestAtis = serbestAtis;
       this.kaleciKarsiKarsiya = kaleciKarsiKarsiya;
       kartKullanildiMi = false;
    }
    
     @Override
    public int sporcuPuaniGoster(int poz)
      {
              
    switch (poz) {
         case 1:
         return getPenalti();
    
        case 2:
         return  getSerbestAtis();
   
       case 3:
        return getKaleciKarsiKarsiya();
       default : 
         return 0;
                  
                 
      }
  }
    public String getFutbolcuAdi() {
        return futbolcuAdi;
    }

  
    public void setFutbolcuAdi(String futbolcuAdi) {
        this.futbolcuAdi = futbolcuAdi;
    }

  
    public String getFutbolcuTakim() {
        return futbolcuTakim;
    }

  
    public void setFutbolcuTakim(String futbolcuTakim) {
        this.futbolcuTakim = futbolcuTakim;
    }

    public int getPenalti() {
        return penalti;
    }

    public void setPenalti(int penalti) {
        this.penalti = penalti;
    }

   
    public int getSerbestAtis() {
        return serbestAtis;
    }

    public void setSerbestAtis(int serbestAtis) {
        this.serbestAtis = serbestAtis;
    }

   
    public int getKaleciKarsiKarsiya() {
        return kaleciKarsiKarsiya;
    }

   
    public void setKaleciKarsiKarsiya(int kaleciKarsiKarsiya) {
        this.kaleciKarsiKarsiya = kaleciKarsiKarsiya;
    }

 
    public Boolean getKartKullanildiMi() {
        return kartKullanildiMi;
    }
 
    public void setKartKullanildiMi(Boolean kartKullanildiMi) {
    
        this.kartKullanildiMi = kartKullanildiMi;
    }
}
