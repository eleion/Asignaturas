/*******************************************************************************
 * Main para la práctica final.                                                *
 * En este programa principal, lo que muestra es la ejecución de todas las fun-*
 * ciones, que recorren un árbol (Todas los recorridos posibles).              *
 * 1)Esto incluye:                                                             *
 *      1)Preorden.                                                            *
 *      2)Postorden.                                                           *
 *      3)Inorden.                                                             *
 *      4)Reverse-preorden.                                                    *
 * 2)Además de recorridos con iteradores.                                      *
 * 3)Otras funciones de prueba como:                                           *
 *      1)Altura de un árbol.                                                  *
 *      2)Podar.                                                               *
 *      3)Reflejar árbol.                                                      *
 *******************************************************************************/

#include <iostream>
#include "ArbolGeneral.h"
#include <string>
#include <string.h>

using namespace std;


int main(int argc, char *argv[]){
    ArbolGeneral<char> a, b, c;

    cin >> a;
    cout << a << endl;

    cout << "Recorridos en preorden: " << endl;
    cout << "\tUsando iteradores: ";
    a.recorrer_preorden();
    cout << endl;
    cout << "\tSin iteradores:    ";
    a.recorrer_preorden2(a.raiz());
    cout << endl;
    cout << "\tOperator--:        ";
    a.recorrer_preorden_al_reves();
    cout << endl;

    cout << "Recorridos en reverse_preorden: " << endl;
    cout << "\tUsando iteradores: ";
    a.recorrer_reverse_preorden();
    cout << endl;
    cout << "\tOperator--:        ";
    a.recorrer_reverse_preorden_al_reves();
    cout << endl;

    cout << "Recorridos en inorden: " << endl;
    cout << "\tUsando iteradores: ";
    a.recorrer_inorden();
    cout << endl;
    cout << "\tSin iteradores:    ";
    a.recorrer_inorden2(a.raiz());
    cout << endl;

    cout << "Recorrido en postorden: " << endl;
    cout << "\tCon iteradores:    ";
    a.recorrer_postorden();
    cout << endl;
    cout << "\tSin iteradores:    ";
    a.recorrer_postorden2(a.raiz());
    cout << endl;

    cout << "Recorrido por niveles: " << endl;
    cout << "\tSin iteradores:    ";
    a.recorrer_por_niveles(a.raiz());
    cout << endl;

    cout << "Altura del ábol: " << a.altura(a.raiz()) << endl;
    cout << "Arbol reflejado:           ";
    a.reflejado(a.raiz());
    a.recorrer_preorden();
    cout << endl;

    cout << "Le podamos el hijo izqda:  ";
    a.podar_hijomasizquierda(a.raiz(), b);
    a.recorrer_preorden();
    cout << endl;
    cout << "La rama cortada es:        ";
    b.recorrer_preorden();
    b.clear();
    b.recorrer_preorden();
    cout << endl;

    cout << "Podamos otro hijo izquierd:";
    a.podar_hijomasizquierda(a.raiz(), b);
    a.recorrer_preorden();
    cout << endl;
    cout << "La rama cortada es:        ";
    b.recorrer_preorden();
    cout << endl;
    
    ArbolGeneral<char>::Nodo ve = 0;
    cout << "\n***";
    cout << "\n***Reconstrucción del árbol anterior.";
    cout << "\n***\n";
    c.recuperar_arbol("1234567", "3215467", "3256471", ve);
    cout << c << endl;
    cout << "Recorridos en preorden: " << endl;
    cout << "\tUsando iteradores: ";
    c.recorrer_preorden();
    cout << endl;
    cout << "\tSin iteradores:    ";
    c.recorrer_preorden2(c.raiz());
    cout << endl;
    cout << "\tOperator--:        ";
    c.recorrer_preorden_al_reves();
    cout << endl;

    cout << "Recorridos en reverse_preorden: " << endl;
    cout << "\tUsando iteradores: ";
    c.recorrer_reverse_preorden();
    cout << endl;
    cout << "\tOperator--:        ";
    c.recorrer_reverse_preorden_al_reves();
    cout << endl;

    cout << "Recorridos en inorden: " << endl;
    cout << "\tUsando iteradores: ";
    c.recorrer_inorden();
    cout << endl;
    cout << "\tSin iteradores:    ";
    c.recorrer_inorden2(c.raiz());
    cout << endl;

    cout << "Recorrido en postorden: " << endl;
    cout << "\tCon iteradores:    ";
    c.recorrer_postorden();
    cout << endl;
    cout << "\tSin iteradores:    ";
    c.recorrer_postorden2(c.raiz());
    cout << endl;

    cout << "Recorrido por niveles: " << endl;
    cout << "\tSin iteradores:    ";
    c.recorrer_por_niveles(c.raiz());
    cout << endl;

    cout << "Altura del ábol: " << c.altura(c.raiz()) << endl;
    cout << "Arbol reflejado:           ";
    c.reflejado(c.raiz());
    c.recorrer_preorden();
    cout << endl;
    

    return 0;
}
