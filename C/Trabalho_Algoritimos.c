#include<stdio.h>
#include "Structs.h"
#include "validacoes.h"
#include <string.h>

struct PessoaFisica novoCadastroPessoaFisica();
struct PessoaJuridica novoCadastroPessoaJuridica();
main()
{

    //printf("%i", contador);
    novoCadastroPessoaFisica();
}

struct PessoaFisica novoCadastroPessoaFisica()
{
    struct PessoaFisica pessoa;

    gets(pessoa.nome);
    validaNomes(pessoa.nome);
}
