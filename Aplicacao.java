package aep_projeto;
import java.util.Date;

public class Aplicacao {
    private Date data;
    private String unidade;
    private double quantidade;
    
    public Aplicacao(Date data, String unidade, double quantidade){
        this.data = data;
        this.unidade = unidade;
        this.quantidade = quantidade;
    }
    
    public String getDataAplicacao(){
        String mes = Integer.toString(data.getMonth()+1);
        String ano = Integer.toString(1900 + data.getYear());
        String dataCompleta = mes + "/" + ano;
        return dataCompleta;
    }
    
    public String getUnidadeAplicacao(){
        return unidade;
    }
    
    public double getQuantidadeAplicada(){
        return quantidade;
    }
    
}
