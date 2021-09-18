package aep_projeto;
import java.util.ArrayList;

public class Drone {
    private int codigoDrone;
    private String nomeDrone;
    private String modeloDrone;
    private boolean droneAtivo;
    private ArrayList<RotaDrone> rotas = new ArrayList<RotaDrone>();
    private int sequenciaRota = 0;
    private String arrayRetorno = "";
    
    public Drone(int codigoDrone, String nomeDrone, String modeloDrone){
        this.codigoDrone = codigoDrone;
        this.nomeDrone = nomeDrone;
        this.modeloDrone = modeloDrone;
        this.droneAtivo = true;
    }
    
    public int getCodigo(){
        return codigoDrone;
    }
    public String getNome(){
        return nomeDrone;
    }
    public String getModelo(){
        return modeloDrone;
    }
    
    public void desativarDrone(){
        if(!droneAtivo){
            throw new RuntimeException("O Drone já está desativado!");
        }
        droneAtivo = false;
    }
    
    public void ativarDrone(){
        if(droneAtivo){
            throw new RuntimeException("O Drone já está ativo!");
        }
        droneAtivo = true;
    }
    
//  MÉTODOS PARA GERENCIAMENTO DAS ROTAS
    
    public void setRota(RotaDrone rota){
        rotas.add(rota);
        this.sequenciaRota++;
    }
    
    public void removeRota(int codigoTalhao, int codigoDia){
        int count = 0;
        for(RotaDrone rota : rotas){
            if(rota.getDia() == codigoDia && rota.getTalhao() == codigoTalhao){
                rotas.remove(count);
                count = -1;
            }
            count++;
        }
        if(count != -1){
            throw new RuntimeException("A Rota especificada não existe!");
        }
    }
    
}
