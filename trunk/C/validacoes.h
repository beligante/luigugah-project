#ifndef VALIDACOES_H_INCLUDED
#define VALIDACOES_H_INCLUDED
#include<stdio.h>
#include<string.h>

void validaNomes(char *nome){

    int charsNome, charsComparacao, indice[strlen(nome)], contadorIndice = 0;

    for(charsNome = 0; charsNome < strlen(nome); charsNome++){

        printf("%c\n", nome[charsNome]);

        for(charsComparacao = 0; charsComparacao < 65; charsComparacao++)
        {
            if(nome[charsNome] == (char) charsComparacao)
            {
                printf("DENTRO NOME: %c\n", nome[charsNome]);
                printf("DENTRO CHAR: %c\n", charsComparacao);
                printf("DENTRO CHAR: \n", charsComparacao);

                indice[contadorIndice] = charsNome; contadorIndice++;}
        }

        for(charsComparacao = 92; charsComparacao < 97; charsComparacao++)
        {
            if(nome[charsNome] == (char) charsComparacao)
            {indice[contadorIndice] = charsNome; contadorIndice++;}

        }

        for(charsComparacao = 124; charsComparacao < 256; charsComparacao++)
        {
            if(nome[charsNome] == (char) charsComparacao)
            {indice[contadorIndice] = charsNome; contadorIndice++;}
        }

    }
    printf("%i", contadorIndice);

    for(charsComparacao = 0; charsComparacao < contadorIndice; contadorIndice++)
    {
        if(nome[indice[charsComparacao]] != ' ', nome[indice[charsComparacao]] != '\0')
        {
            printf("O nome passado é um nome invalido, por favor corriga-o: \n");
            printf("Char Invalido: %c", nome[charsComparacao]);
            charsComparacao = contadorIndice;
            gets(nome);
        }
    }
}



#endif // VALIDACOES_H_INCLUDED
