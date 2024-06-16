package model;

public class ClassificacaoFiscal {

    private int idFigura; 
    private String tipoClassificacao; 
    private double itensIsentos;
    private double itensTaxado ;
    private double icmsSaida; 
    private double cfop; 
    private int cst;
    private double ipi; 
    private double icmsEntrada; 
    private double reducaoBaseIcms;
    private double reducaoAliquota;
    
    
    public ClassificacaoFiscal(int idFigura, String tipoClassificacao, double itensIsentos, double itensTaxado,
            double icmsSaida, double cfop, int cst, double ipi, double icmsEntrada, double reducaoBaseIcms,
            double reducaoAliquota) {
                
        this.idFigura = idFigura;
        this.tipoClassificacao = tipoClassificacao;
        this.itensIsentos = itensIsentos;
        this.itensTaxado = itensTaxado;
        this.icmsSaida = icmsSaida;
        this.cfop = cfop;
        this.cst = cst;
        this.ipi = ipi;
        this.icmsEntrada = icmsEntrada;
        this.reducaoBaseIcms = reducaoBaseIcms;
        this.reducaoAliquota = reducaoAliquota;
    }


    public int getIdFigura() {
        return idFigura;
    }


    public void setIdFigura(int idFigura) {
        this.idFigura = idFigura;
    }


    public String getTipoClassificacao() {
        return tipoClassificacao;
    }


    public void setTipoClassificacao(String tipoClassificacao) {
        this.tipoClassificacao = tipoClassificacao;
    }


    public double getItensIsentos() {
        return itensIsentos;
    }


    public void setItensIsentos(double itensIsentos) {
        this.itensIsentos = itensIsentos;
    }


    public double getItensTaxado() {
        return itensTaxado;
    }


    public void setItensTaxado(double itensTaxado) {
        this.itensTaxado = itensTaxado;
    }


    public double getIcmsSaida() {
        return icmsSaida;
    }


    public void setIcmsSaida(double icmsSaida) {
        this.icmsSaida = icmsSaida;
    }


    public double getCfop() {
        return cfop;
    }


    public void setCfop(double cfop) {
        this.cfop = cfop;
    }


    public int getCst() {
        return cst;
    }


    public void setCst(int cst) {
        this.cst = cst;
    }


    public double getIpi() {
        return ipi;
    }


    public void setIpi(double ipi) {
        this.ipi = ipi;
    }


    public double getIcmsEntrada() {
        return icmsEntrada;
    }


    public void setIcmsEntrada(double icmsEntrada) {
        this.icmsEntrada = icmsEntrada;
    }


    public double getReducaoBaseIcms() {
        return reducaoBaseIcms;
    }


    public void setReducaoBaseIcms(double reducaoBaseIcms) {
        this.reducaoBaseIcms = reducaoBaseIcms;
    }


    public double getReducaoAliquota() {
        return reducaoAliquota;
    }


    public void setReducaoAliquota(double reducaoAliquota) {
        this.reducaoAliquota = reducaoAliquota;
    } 

    
}
