package aep_projeto;

public class Agrotoxico extends Substancia{
    int codigoToxico;
    double taxaDL50; //dose letal 50
    String tipoToxico; //fungicida, herbicida etc
    String classeToxico; //pouco, altamento toxico etc
   
    public Agrotoxico(int codigoToxico, double taxaDL50, String descricaoToxico, String tipoToxico, String unidade){
        super(descricaoToxico, unidade); 
        this.codigoToxico = codigoToxico;
        this.taxaDL50 = taxaDL50;
        this.tipoToxico = tipoToxico;
        if(taxaDL50 < 5){
            this.classeToxico = "Extrema Toxicidade";
        }
        else if(taxaDL50 < 50){
            this.classeToxico = "Alta Toxicidade";
        }
        else if(taxaDL50 < 500){
            this.classeToxico = "Media Toxicidade";
        }
        else{
            this.classeToxico = "Baixa Toxicidade";
        }
    }
    
    public int getCodigo(){
        return codigoToxico;
    }
    
    public String getToxicidade(){
        String toxicidade = classeToxico + " : " + taxaDL50;
        return toxicidade; 
    }
    
    public String getTipo(){
        return tipoToxico;
    }
}
