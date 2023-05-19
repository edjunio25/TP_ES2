package TP_ES2.Classes;
public class Pessoa{
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private DateTime dataNascimento;
    private Endereco endereco;

    public Pessoa(final String nome
        final String sobrenome,
        final String cpf,
        final String email,
        final DateTime dataNascimento,
        final Endereco endereco)
        {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.cpf = cpf;
            this.email = email;
            this.dataNascimento = dataNascimento; 
            this.endereco = endereco
        }
    
}