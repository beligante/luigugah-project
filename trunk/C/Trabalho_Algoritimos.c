#include<stdio.h>
#include "Structs.h"
#include "flush.h"
#include <string.h>

struct PessoaFisica novoCadastroPessoaFisica(), pessoaFisica[10];
struct PessoaJuridica novoCadastroPessoaJuridica(), pessoaJuridica[10];
void leituraDeParametros();
int quantidadeDePessoasFisicas, quantidadeDePessoasJuridicas, contadorPessoaFisica = 0, contadorPessoaJuridica = 0;

main()
{
    //novoCadastroPessoaFisica();
    leituraDeParametros();
    printf("PF: %i\nPJ: %i", quantidadeDePessoasFisicas, quantidadeDePessoasJuridicas);
}

novoCadastroPessoaFisica()
{

    printf("Cadastro de Nova Pesso Fisica: \n\n");

    printf("Nome: ");
    gets(pessoa.nome);

    printf("RG: ");
    scanf("%i", &pessoa.RG);
    limpaFlush();

    printf("CPF: ");
    gets(pessoa.CPF);

    printf("Dia: ");
    scanf("%i", &pessoa.nascimento.dia);
    limpaFlush();

    printf("Mes: ");
    scanf("%i", &pessoa.nascimento.mes);
    limpaFlush();

    printf("Ano: ");
    scanf("%i", &pessoa.nascimento.ano);
    limpaFlush();

    printf("Rua: ");
    gets(pessoa.endereco.rua);

    printf("Numero: ");
    gets(pessoa.endereco.numero);

    printf("Complemento: ");
    gets(pessoa.endereco.complemento);

    printf("Cep: ");
    scanf("%i", &pessoa.endereco.cep);
    limpaFlush();

    printf("Telefone Residencial: ");
    scanf("%i", &pessoa.telefone.telefone1);
    limpaFlush();

    printf("Telefone Comercial: ");
    scanf("%i", &pessoa.telefone.telefone2);
    limpaFlush();

    printf("Celular 1: ");
    scanf("%i", &pessoa.telefone.celular1);
    limpaFlush();

    printf("Celular 2: ");
    scanf("%i", &pessoa.telefone.celular2);
    limpaFlush();

    contadorPessoaFisica++;

    if(contadorPessoaFisica == 9)
    {
        limpaArrayPessoaFisica();
    }
}

struct PessoaJuridica novoCadastroPessoaJuridica()
{
    struct PessoaJuridica pessoa;

    printf("Cadastro de Nova Pesso Fisica: \n\n");

    printf("Rasao Social: ");
    gets(pessoa.rasaoSocial);

    printf("Nome Fantasia: ");
    gets(pessoa.nomeFantasia);

    printf("CNPJ: ");
    scanf("%i", &pessoa.CNPJ);
    limpaFlush();

    printf("Dia da Criação da Empresa: ");
    scanf("%i", &pessoa.dataCriacaoEmpresa.dia);
    limpaFlush();

    printf("Mes da Criação da Empresa: ");
    scanf("%i", &pessoa.dataCriacaoEmpresa.mes);
    limpaFlush();

    printf("Ano da Criação da Empresa: ");
    scanf("%i", &pessoa.dataCriacaoEmpresa.ano);
    limpaFlush();

    printf("Rua: ");
    gets(pessoa.endereco.rua);

    printf("Numero: ");
    gets(pessoa.endereco.numero);

    printf("Complemento: ");
    gets(pessoa.endereco.complemento);

    printf("Cep: ");
    scanf("%i", &pessoa.endereco.cep);
    limpaFlush();

    printf("Telefone Comercial 1: ");
    scanf("%i", &pessoa.telefone.telefone1);
    limpaFlush();

    printf("Telefone Comercial 2: ");
    scanf("%i", &pessoa.telefone.telefone2);
    limpaFlush();

    printf("Celular 1: ");
    scanf("%i", &pessoa.telefone.celular1);
    limpaFlush();

    printf("Celular 2: ");
    scanf("%i", &pessoa.telefone.celular2);
    limpaFlush();
}

void leituraDeParametros()
{
    FILE *parametros;


    if ((parametros = fopen("param.luis","a+"))==NULL)
    {
        printf("Arquivo nao pode ser aberto");
    }

    fread(&quantidadeDePessoasFisicas, sizeof(int), 1, parametros);
    fseek(parametros, 0, SEEK_END);
    fread(&quantidadeDePessoasJuridicas, sizeof(int), 1, parametros);
}

void salvaPessoaFisica(struct PessoaFisica pessoa)
{
    fseek(arqPessoaFisica, 0, SEEK_END);
    fwrite(&pessoa, sizeof(struct PessoaFisica), 1, arqPessoFisica);
}
