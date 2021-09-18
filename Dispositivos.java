package aep_projeto;


public class Dispositivos {
    private int codigoDispositivo;
    private String nomeDispositivo;
    private String descricaoDispositivo;
    private boolean dispositivoAtivo;
    private String classeDispositivo;
    private String[] classesCadastradas = {"acidez", "umidade", "vento"};
    
    
    public Dispositivos(int codigoDispositivo, String nomeDispositivo, String descricaoDispositivo, String classeDispositivo){
        for(int classe = 0;classe<=classesCadastradas.length+1;classe++){
            if(classesCadastradas[classe].equals(classeDispositivo)){
                break;
            }
            if(classe>classesCadastradas.length){
                throw new RuntimeException("Classe de dispositivo não cadastrada!");
            }
        }
        this.codigoDispositivo = codigoDispositivo;
        this.nomeDispositivo = nomeDispositivo;
        this.descricaoDispositivo = descricaoDispositivo;
        this.dispositivoAtivo = true;
        this.classeDispositivo = classeDispositivo;
    }
    
    public int getCodigo(){
        return codigoDispositivo;
    }
    public String getNome(){
        return nomeDispositivo;
    }
    public String getDescricao(){
        return descricaoDispositivo;
    }
    public boolean getAtivo(){
        return dispositivoAtivo;
    }
    public String getClasse(){
        return classeDispositivo;
    }
    
//    RETORNOS FIXOS PARA TESTE
    
    public double realizarMedicao(){
        if(classeDispositivo.equals("acidez")){
            return 5.5; // ph
        }
        if(classeDispositivo.equals("umidade")){
            return 35.00; // %
        }
        if(classeDispositivo.equals("vento")){
            return 40.00; // m/s
        }
        throw new RuntimeException("Não foi possível realizar a medição, verifique a classe do dispositivo!");
    }
    
    public void desativarDispositivo(){
        if(!dispositivoAtivo){
            throw new RuntimeException("Dispositivo já desativado!");
        }
        dispositivoAtivo = false;
    }
    
    public void ativarDispositivo(){
        if(dispositivoAtivo){
            throw new RuntimeException("Produto já está ativo!");
        }
        dispositivoAtivo = true;
    }
    
}
