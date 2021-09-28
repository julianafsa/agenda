package br.com.santander.agenda.enumerations;

public enum TipoTelefone {
	
	RESIDENCIAL("Residencial"),
    COMERCIAL("Comercial"),
    CELULAR("Celular"),
    RECADO("Recado");
	
    private String descricao;

    TipoTelefone(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
