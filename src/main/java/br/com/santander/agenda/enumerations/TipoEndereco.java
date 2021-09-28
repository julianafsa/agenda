package br.com.santander.agenda.enumerations;

public enum TipoEndereco {
	
	RESIDENCIAL("Residencial"),
    COMERCIAL("Comercial");
	
    private String descricao;

    TipoEndereco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
