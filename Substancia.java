package aep_projeto;
import java.util.ArrayList;
import java.util.Date;

public class Substancia {
    private String descricao;
    private String unidade;
    private Date dataCadastro;
    
    private ArrayList<Aplicacao> registroAplicações = new ArrayList<Aplicacao>();
    
    public Substancia(String descricao, String unidade){
        this.descricao = descricao;
        this.unidade = unidade;
        this.dataCadastro = new Date();
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public int getDataCadastro(){
        int dataCadastroFormatada = dataCadastro.getYear() + 1900;
        return dataCadastroFormatada;
    }
    
    public double calcularEfetividadeMedia(String data){
        double mediaAplicada = 0;
        double totalAplicado = 0;
        int vezesAplicado = 0;
        for(int indice = 0; indice < registroAplicações.size(); indice++){
            Aplicacao registro = registroAplicações.get(indice);
            if(data.equals(registro.getDataAplicacao())){
                totalAplicado = totalAplicado + registro.getQuantidadeAplicada();
                vezesAplicado++;
            }
        }
        return mediaAplicada = totalAplicado / vezesAplicado;
    }
    
    public void aplicarSubstancia(double quantidadeAplicada){
        if(quantidadeAplicada <= 0){
            throw new RuntimeException("A quantidade aplicada deve ser positiva!");
        }
        registroAplicações.add(new Aplicacao(new Date(), this.unidade, quantidadeAplicada));
    }
    
    public String getHistoricoEconomia(){
        Date dataAtual = new Date();
        int diferenca = dataAtual.getYear() - dataCadastro.getYear();
        String tabelaEfetividade = "";
        for(int ano = 0; ano<=diferenca; ano++){
            for(int mes = 1; mes<=12; mes++){
                int anoAtual = dataCadastro.getYear() + ano + 1900;
                String dataFormatada = Integer.toString(mes) + "/" + Integer.toString(anoAtual);
                double efetividadeMes = calcularEfetividadeMedia(dataFormatada);
                if(Double.isNaN(efetividadeMes) ){
                    efetividadeMes = 0;
                }
                tabelaEfetividade = tabelaEfetividade + formataTabela(mes, anoAtual, efetividadeMes);
            }
        }
        
        return tabelaEfetividade;
    }
    
    public double getTaxaEconomia(int mes, int ano){
        double efetividadeMesAnterior = 0;
        double efetividadeMesRecebido = 0;
        double porcentagemCalculada = 0;
        if(mes>12 || mes<0){
            throw new RuntimeException("O mês inserido não é válido!");
        }
        
        efetividadeMesAnterior = calcularEfetividadeMedia(mes-1 + "/" + ano);
        if(mes-1 == 0){
            efetividadeMesAnterior = calcularEfetividadeMedia("12" + "/" + (ano-1));
        }
       
        efetividadeMesRecebido = calcularEfetividadeMedia(mes + "/" + ano);
        if(efetividadeMesRecebido <= 0){
            return 0;
        }
        porcentagemCalculada = efetividadeMesAnterior / efetividadeMesRecebido;
        
        if(porcentagemCalculada >= 1){
            porcentagemCalculada = porcentagemCalculada * 100;
        }else{
            porcentagemCalculada = porcentagemCalculada * -100;
        }    
        return porcentagemCalculada;
    }
    
    private String formataTabela(int mes, int ano, double efetividade){
        String novaLinha = "[" + mes + "/" + ano + "]" + " - " + efetividade + "\n";
        return novaLinha;
    }

}
