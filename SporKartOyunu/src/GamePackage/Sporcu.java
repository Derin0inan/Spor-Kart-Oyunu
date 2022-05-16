package GamePackage;


public class Sporcu {
   private  String sporcuIsim;
   private String sporcuTakim;
   private int kartPuani;
   public Boolean kartKullanildiMi;
   
   
    public Sporcu()
    {
        sporcuIsim = "Atanmadi";
        sporcuTakim = "Atanmadi";
        kartKullanildiMi = false;
    }
    
 
    
      public Sporcu(String sporcuIsim, String sporcuTakim, int kartPuani)
    {
        this.sporcuIsim = sporcuIsim;
        this.sporcuTakim = sporcuTakim;
        this.kartPuani = kartPuani;
        kartKullanildiMi = false;
    }
      
      public int sporcuPuaniGoster(int poz)
      {
          return 0;
      }

    
    public String getSporcuIsim() {
        return sporcuIsim;
    }

    
    public void setSporcuIsim(String sporcuIsim) {
        this.sporcuIsim = sporcuIsim;
    }

    
    public String getSporcuTakim() {
        return sporcuTakim;
    }

    
    public void setSporcuTakim(String sporcuTakim) {
        this.sporcuTakim = sporcuTakim;
    }

  
    public int getKartPuani() {
        return kartPuani;
    }

  
    public void setKartPuani(int kartPuani) {
        this.kartPuani = kartPuani;
    }

    /**
     * @return the kartKullanildiMi
     */
    public Boolean getKartKullanildiMi() {
        return kartKullanildiMi;
    }

    /**
     * @param kartKullanildiMi the kartKullanildiMi to set
     */
    public void setKartKullanildiMi(Boolean kartKullanildiMi) {
        this.kartKullanildiMi = kartKullanildiMi;
    }
    
       public void KartKullanildi()
    {
        this.setKartKullanildiMi((Boolean) true);
    }
}
