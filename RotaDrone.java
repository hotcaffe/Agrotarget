package aep_projeto;


public class RotaDrone {
    private int codigoTalhao;
    private int codigoDia;
    private boolean rotaAtiva;
    
    public RotaDrone(int codigoTalhao, int codigoDia){
        if(codigoDia > 7 || codigoDia < 1){
            throw new RuntimeException("Código de dia inválido! O código deve estar entre '1' (segunda-feira) - '7' (domingo)");
        }
        this.codigoTalhao = codigoTalhao;
        this.codigoDia = codigoDia;
        this.rotaAtiva = true;
    }
    
    public int getTalhao(){
        return codigoTalhao;
    }
    public int getDia(){
        return codigoDia;
    }
    public void desativaRota(){
        if(!rotaAtiva){
            throw new RuntimeException("Rota já está inativa!");
        }
        rotaAtiva = false;
    }
    public void ativaRota(){
        if(rotaAtiva){
            throw new RuntimeException("Rota já está ativa!");
        }
        rotaAtiva = true;
    }
    
}
