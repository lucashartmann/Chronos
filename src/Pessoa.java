public class Pessoa {
    private int dia;
    private int ano;
    private int mes;
    private int hora;
    private int minuto;

    public Pessoa(int ano, int mes, int dia, int hora, int minuto) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minuto = minuto;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    @Override
    public String toString() {
        return "Pessoa [dia=" + dia + ", ano=" + ano + ", mes=" + mes + ", hora=" + hora + ", minuto=" + minuto + "]";
    }

}
