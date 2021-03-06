package model;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class Email {
    private User user;
    private String addressee;
    private String emailText;
}
