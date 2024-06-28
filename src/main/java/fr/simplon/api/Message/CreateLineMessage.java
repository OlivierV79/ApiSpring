package fr.simplon.api.Message;

import lombok.Getter;

@Getter
public class CreateLineMessage {
    private Integer quantity;
    private Integer card;
    private Integer product;
}
