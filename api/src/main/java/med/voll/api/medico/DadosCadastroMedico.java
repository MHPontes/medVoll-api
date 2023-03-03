package med.voll.api.medico;

import jakarta.validation.Valid;                                  //
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(                  //Criado classe Record, por ser menos verboso:
                                                   // Este recurso funciona como se fosse uma classe imutável, para deixarmos o código simples.
                                                    // Isso para não usarmos uma classe tradicional, pois seria necessário digitarmos os métodos getters e setters, criar construtor, e todas as outras verbosidades do Java.

        @NotBlank                   //NotBlack (Bean Validation - Verifica se nao e nulo nem vazio somente para String)
        String nome,
        @NotBlank
        @Email                      //Valida Email (Bean Validation)
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")                      //Expressao Regular para definir que valor deve ter entre 4 e 6 digitos
        String crm,
        @NotNull                                  //Como NotBlank
        Especialidade especialidade,
        @NotNull @Valid DadosEndereco endereco) {
}

//  DTO - Data Transfer Object ("Objeto de transferência de dados").
// Mapeia os atributos que receberemos do arquivo JSON solicitado no MedicoController.

