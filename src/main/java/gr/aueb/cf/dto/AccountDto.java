package gr.aueb.cf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private  Long id;
    private  String accountHolderName;
    private  double balance;

    public AccountDto() {

    }
}
