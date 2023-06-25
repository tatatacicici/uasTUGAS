package org.tubesUAS;
<<<<<<< HEAD

=======
>>>>>>> 6960db9de8066698ba0356a706615d3c9260e15e
public class Kota {
    String infoKota;
    Kota nextKota;
    Jalur jalur;
    
    public Kota(){
        infoKota = null;
        nextKota = null;
        jalur = null;
    }
    
    public Kota(String info){
        this.infoKota= info;
        nextKota = null;
        jalur = null;
    }
    
    public Kota(String info, Kota next){
        this.infoKota = info;
        this.nextKota = next;
        jalur = null;
    }
    
    public Kota(String infoKota, Kota nextKota, Jalur jalur){
        this.infoKota = infoKota;
        this.nextKota= nextKota;
        this.jalur = jalur;
    }
}
