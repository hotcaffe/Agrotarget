package aep_projeto;
import java.util.ArrayList;
import java.util.Date;

public class Fertilizante extends Substancia{
    private int codigoFertilizante;
    private String organicidade;
    private ArrayList<Aplicacao> registroAplicações = new ArrayList<Aplicacao>();
    
    public Fertilizante(int codigoFertilizante, String descricaoFertilizante, String organicidade, String unidade){
        super(descricaoFertilizante, unidade);
        if(!organicidade.equals("organico") && !organicidade.equals("inorganico")){
            throw new RuntimeException("A organicidade deve ser do tipo [organico] ou [inorganico]");
        }
        this.codigoFertilizante = codigoFertilizante;
        this.organicidade = organicidade;
    }  
    

    
    public int getCodigo(){
        return codigoFertilizante;
    }
    
    public String getOrganicidade(){
        return organicidade;
    }
    
    
}
