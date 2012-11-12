#ifndef VALIDACOES_H_INCLUDED
#define VALIDACOES_H_INCLUDED
#include<stdio.h>
#include<string.h>

void verificaCaracteresInvalidos(char *nome);
void verificaNumeroDePalavrasNome(char *nome);


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

    if( nome[contador] != ' ' && nome[contador+1] != '\0')
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

#endif // VALIDACOES_H_INCLUDED
