package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(                  //Criado classe Record, por ser menos verboso:
                                                   // Este recurso funciona como se fosse uma classe imutável, para deixarmos o código simples.
                                                    // Isso para não usarmos uma classe tradicional, pois seria necessário digitarmos os métodos getters e setters, criar construtor, e todas as outras verbosidades do Java.

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull @Valid DadosEndereco endereco) {
}

//  DTO - Data Transfer Object ("Objeto de transferência de dados").
// Mapeia os atributos que receberemos do arquivo JSON solicitado no MedicoController.

