#ifndef VALIDACOES_H_INCLUDED
#define VALIDACOES_H_INCLUDED
#include<stdio.h>
#include<string.h>
#include"flush.h"

void verificaCaracteresInvalidos(char *nome);
void verificaNumeroDePalavrasNome(char *nome);
void verificaNumeroDePalavrasNumeroCasa(char *numeroCasa);
void verificaCaracteresInvalidosNumeroCasa(char *numeroCasa);


void validaNomes(char *nome){

    verificaNumeroDePalavrasNome(nome);
    verificaCaracteresInvalidos(nome);

}

void verificaCaracteresInvalidos(char *nome)
{
    int charsNome, charsComparacao, contadorIndice = 0, contador = 0;
    char indice[strlen(nome)];

    for(charsNome = 0; charsNome < strlen(nome); charsNome++){

        for(charsComparacao = 65; charsComparacao < 91; charsComparacao++)
        {
            if(nome[charsNome] != (char)(charsComparacao) )
            {
                contador++;
            }
        }

        for(charsComparacao = 97; charsComparacao < 123; charsComparacao++)
        {
            if(nome[charsNome] != (char)(charsComparacao) )
            {
                contador++;
            }
        }

        if(contador != 51)
        {
            indice[contadorIndice] = nome[charsNome];
            contadorIndice++;
        }

        contador = 0;
    }

    for(charsComparacao = 0; charsComparacao < contadorIndice; charsComparacao++)
    { printf("%c", indice[charsComparacao]);}

    for(charsComparacao = 0; charsComparacao < contadorIndice; charsComparacao++)
    {
        if(indice[charsComparacao] != ' ' )
        {
            if(indice[charsComparacao] != '\0')
            {
                printf("O nome passado é um nome invalido, por favor corriga-o: \n");
                printf("Char Invalido: %c", indice[charsComparacao]);
                charsComparacao = contadorIndice;
                gets(nome);

                validaNomes(nome);
            }
        }
    }
}

void verificaNumeroDePalavrasNome(char *nome)
{
    int contador = 0, numPalavras = 0;

    if( nome[contador] != ' ' ||  nome[contador] != '\0' && nome[contador+1] != '\0')
    {numPalavras = 1;}

    for(contador = 0; contador < strlen(nome); contador++)
    {
        if( nome[contador] == ' ' && nome[contador+1] != ' ' && nome[contador+1] != '\0')
        {
            numPalavras++;
        }
    }

    if(numPalavras == 0)
    {
        printf("O Nome passado parece não conter nenhuma palavra, por favor digite-o novamente: \n");
        gets(nome);
        verificaNumeroDePalavrasNome(nome);
    }
}

void validaDia(int *dia)
{
    if(*dia < 1 || *dia > 31)
    {
        printf("O dia digitado, se refere a um dia invalido!\n");
        printf("Digite novamente: ");
        scanf("%i", dia);
        validaDia(dia);
    }

}

void validaAno(int *ano)
{
    if(*ano < 1900)
    {
        printf("O Ano digitado, se refere a um ano absurdo!\n");
        printf("Digite novamente: ");
        scanf("%i", ano);
        validaAno(ano);
    }
}
void validaMes(int *mes)
{
    if(*mes < 1 || *mes > 12)
    {
        printf("O Mes digitado, se refere a um Mes invalido!\n");
        printf("Digite novamente: ");
        scanf("%i", mes);
        validaMes(mes);
    }
}

void validaCPF(char *cpf)
{
    int icpf[strlen(cpf)];
    int contador,somador=0,digito1,result1,result2,digito2,valor;

    //Efetua a conversao de array de char para um array de int.
    for(contador = 0; contador < 11; contador++)
    {
        icpf[contador] = cpf[contador]-48;
    }

    for(contador = 0; contador < 9; contador++)
    {
        somador+=icpf[contador]*(10-contador);
    }

    result1=somador%11;

    if( (result1==0) || (result1==1) )
    {
        digito1=0;
    }
    else
    {
        digito1 = 11-result1;
    }

    //SEGUNDO DIGITO.

    somador=0;

    for(contador = 0; contador < 10; contador++)
    {
        somador+=icpf[contador]*(11-contador);
    }

    valor=(somador/11)*11;
    result2=somador-valor;

    if( (result2==0) || (result2==1) )
    {
        digito2=0;
    }

    else
    {
        digito2=11-result2;
    }

    //RESULTADOS DA VALIDACAO.

    if((digito1!=icpf[9]) && (digito2!=icpf[10]))
    {
        printf("CPF invalido!\nDigite novamente: ");
        gets(cpf);
        validaCPF(cpf);
    }
}

void validaNumeroCasa(char *numeroCasa)
{
    verificaNumeroDePalavrasNumeroCasa(numeroCasa);
    verificaCaracteresInvalidosNumeroCasa(numeroCasa);
}

void verificaNumeroDePalavrasNumeroCasa(char *numeroCasa)
{
    int contador = 0, numPalavras = 0;

    if( numeroCasa[contador] != ' ')
    {numPalavras = 1;}

    for(contador = 0; contador < strlen(numeroCasa); contador++)
    {
        if( numeroCasa[contador] == ' ' && numeroCasa[contador+1] != ' ' && numeroCasa[contador+1] != '\0')
        {
            numPalavras++;
        }
    }

    if(numPalavras == 0)
    {
        printf("O Numero da Casa passado parece não conter nenhuma palavra, por favor digite-o novamente: \n");
        gets(numeroCasa);
        verificaNumeroDePalavrasNumeroCasa(numeroCasa);
    }
}

void verificaCaracteresInvalidosNumeroCasa(char *numeroCasa)
{
    int charsNome, charsComparacao, contadorIndice = 0, contador = 0;
    char indice[strlen(numeroCasa)];

    for(charsNome = 0; charsNome < strlen(numeroCasa); charsNome++){

        for(charsComparacao = 65; charsComparacao < 91; charsComparacao++)
        {
            if(numeroCasa[charsNome] != (char)(charsComparacao) )
            {
                contador++;
            }
        }

        for(charsComparacao = 97; charsComparacao < 123; charsComparacao++)
        {
            if(numeroCasa[charsNome] != (char)(charsComparacao) )
            {
                contador++;
            }
        }

        if(contador != 51)
        {
            indice[contadorIndice] = numeroCasa[charsNome];
            contadorIndice++;
        }

        contador = 0;
    }

    for(charsComparacao = 0; charsComparacao < contadorIndice; charsComparacao++)
    {
        if(indice[charsComparacao] != ' ' )
        {
            if(indice[charsComparacao] != '\0')
            {
                printf("O Numero da Casa passado é um numero invalido,\nPor favor corriga-o: ");
                charsComparacao = contadorIndice;
                gets(numeroCasa);

                validaNomes(numeroCasa);
            }
        }
    }
}
#endif // VALIDACOES_H_INCLUDED
