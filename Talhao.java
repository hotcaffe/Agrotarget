package aep_projeto;
import java.util.ArrayList;

public class Talhao {
    private int codigoTalhao;
    private float tamanhoTalhao;
    private String[] sistemasDisponiveis = {"monocultura","sucessao","rotacao","integracao"};
    private String sistemaEscolhido = "";
    private SistemaProducao producaoGerada;
    private boolean producaoAtribuida = false;
    private ArrayList<String> culturas = new ArrayList<>();
    private ArrayList<Dispositivos> dispositivos = new ArrayList<>(); 
    private ArrayList<Drone> drones = new ArrayList<>();
    
//    CONSTRUTOR E MÉTODOS BÁSICOS DA CLASSE "TALHAO"
    
    public Talhao(int codigoTalhao, float tamanhoTalhao){
        this.codigoTalhao = codigoTalhao;
        this.tamanhoTalhao = tamanhoTalhao;
    }
    
    public int getCodigo(){
        return codigoTalhao;
    }
    
    public float getTamanho(){
        return tamanhoTalhao;
    }
    
//    MÉTODOS DE DEFINIÇÃO DA PRODUÇÃO DO TALHÃO (O QUE SERÁ PRODUZIDO E COMO)
    
    public void setSistema(String sistemaEsc){
        for(int sistema = 0;sistema<=sistemasDisponiveis.length;sistema++){
            if(sistemasDisponiveis[sistema].equals(sistemaEsc)){
                sistemaEscolhido = sistemaEsc;
                break;
            }
            if(sistema+1>sistemasDisponiveis.length){
                throw new RuntimeException("Tipo de produção não existe, verifique novamente!");
            }
        }
    }
    
    public void addCultura(String cultura){
        culturas.add(cultura);
    }
    
    public void unsetCulturas(){
        culturas.clear();
    }
    
    public void setProducao(){
        if(sistemaEscolhido.equals("")){
            throw new RuntimeException("Nenhum sistema foi escolhido!");
        }
        if(culturas.isEmpty()){
            throw new RuntimeException("Nenhuma cultura foi especificada");
        }
        if(sistemaEscolhido.equals("sucessao") || sistemaEscolhido.equals("rotacao")){;
            boolean culturasDiferentes = false;
            if(culturas.size() == 1){
                throw new RuntimeException("Para os sistemas de sucessão e rotação devem haver ao menos duas culturas diferentes especificadas!");
            }
            for(int elemento = 0; elemento<culturas.size();elemento++){;
                for(String cultura : culturas){
                    if(!cultura.equals(culturas.get(elemento))){
                        culturasDiferentes = true;
                    }
                }
            }
            if(!culturasDiferentes){
                throw new RuntimeException("Para os sistemas de sucessão e rotação devem haver ao menos duas culturas diferentes especificadas!");
            }
        }
        if(producaoAtribuida){
            throw new RuntimeException("Sistema de produção já foi atribuído, exclua o atual para prosseguir!");
        }
        producaoGerada = new SistemaProducao(culturas, sistemaEscolhido);
        producaoAtribuida = true;
    }
    
    public void unsetProducao(){    
        if(!producaoAtribuida){
            throw new RuntimeException("Nenhuma produção foi atribuída ao talhão atual!");
        }
        producaoAtribuida = false;
    }
    
//    RELACIONAMENTO E GERENCIAMENTO DE DISPOSITIVOS PARA COM O TALHÃO EM QUESTÃO
    
    public void addDispositivo(int codigo, String nome, String descricao, String classe){
        boolean dispositivoExiste = false;
        for(Dispositivos dispositivo : dispositivos){
            if(dispositivo.getCodigo() == codigo){
                dispositivoExiste = true;
                break;
            }
        }
        if(dispositivoExiste){
            throw new RuntimeException("Código de dispositivo já cadastrado!");
        }
        dispositivos.add(new Dispositivos(codigo, nome, descricao, classe));
    }
    
    public void removeDispositivo(int codigo){
        int count = 0;
        for(Dispositivos dispositivo : dispositivos){
            if(dispositivo.getCodigo() == codigo){
                dispositivos.remove(count);
                count = -1;
                break;
            }
            count++;
        }
        if(count != -1){
            throw new RuntimeException("Não existe um dispositivo cadastrado com esse código!");
        }
    }
    
    public ArrayList<String> getDispositivos(){
        ArrayList<String> dispositivoFormatado = new ArrayList<>();
        for(Dispositivos dispositivo : dispositivos){
            dispositivoFormatado.add("DP:"+Integer.toString(dispositivo.getCodigo())+" - N: "+dispositivo.getNome()+" - C: "+dispositivo.getClasse());
        }
        return dispositivoFormatado;
    }
    
//    RELACIONAMENTO ENTRE DRONES E O TALHÃO EM QUESTÃO, GERENCIANDO ESTES E SUAS ADICIONANDO ROTAS
    
    public void addDrone(int codigoDrone, String nomeDrone, String modeloDrone){
        boolean droneExiste = false;
        for(Drone drone : drones){
            if(drone.getCodigo() == codigoDrone){
                droneExiste = true;
                break;
            }
        }
        if(droneExiste){
            throw new RuntimeException("Drone já cadastrado com este código!");
        }
        drones.add(new Drone(codigoDrone, nomeDrone, modeloDrone));
    }
    
    public void removeDrone(int codigoDrone){
        int count = 0;
        for(Drone drone : drones){
            if(drone.getCodigo() == codigoDrone){
                drones.remove(count);
                count = -1;
                break;
            }
        }
        if(count != -1){
            throw new RuntimeException("Não existe drone cadastrado com este código!");
        }
    }
    
    public void addRotaDrone(int codigoDrone, int codigoDia){
        int count = 0;
        for(Drone drone : drones){
            if(drone.getCodigo() == codigoDrone){
                drone.setRota(new RotaDrone(this.codigoTalhao, codigoDia));
                count = -1;
                break;
            }
            count++;
        }
        if(count != -1){
            throw new RuntimeException("Drone não cadastrado no sistema, verifique o código!");
        }
    }
    
    public void removeRotaDrone(int codigoDrone, int codigoDia){
        int count = 0;
        for(Drone drone : drones){
            if(drone.getCodigo() == codigoDrone){
                drone.removeRota(this.codigoTalhao, codigoDia);
                count = -1;
                break;
            }
            count++;
        }
        if(count != -1){
            throw new RuntimeException("Drone não cadastrado no sistema, verifique o código!");
        }
    }
    
}
