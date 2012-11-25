#ifndef STRUCTS_H_INCLUDED
#define STRUCTS_H_INCLUDED

struct Endereco{
    char rua[40];
    char numero[20];
    int cep;
    char complemento[40];
};

struct DataDeNascimento{
    int dia, mes, ano;
};

struct Telefones{
    int telefone1,telefone2,celular1, celular2;
};

struct PessoaFisica{
    char nome[40], CPF[12];
    int RG;
    struct Telefones telefone;
    struct DataDeNascimento nascimento;
    struct Endereco endereco;
};

struct PessoaJuridica{

    char nomeFantasia[40], rasaoSocial[60];
    int CNPJ;
    struct DataDeNascimento dataCriacaoEmpresa;
    struct Endereco endereco;
    struct Telefones telefone;
};


#endif // STRUCTS_H_INCLUDED
