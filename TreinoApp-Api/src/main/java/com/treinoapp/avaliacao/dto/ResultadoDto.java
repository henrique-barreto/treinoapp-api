package com.treinoapp.avaliacao.dto;

public class ResultadoDto {

	public ResultadoDto(CardGordura cardGordura, CardPeso cardPeso) {
		this.cardGordura = cardGordura;
		this.cardPeso = cardPeso;
	}

	private CardGordura cardGordura;
	private CardPeso cardPeso;

	public CardGordura getCardGordura() {
		return cardGordura;
	}

	public void setCardGordura(CardGordura cardGordura) {
		this.cardGordura = cardGordura;
	}

	public CardPeso getCardPeso() {
		return cardPeso;
	}

	public void setCardPeso(CardPeso cardPeso) {
		this.cardPeso = cardPeso;
	}

}
