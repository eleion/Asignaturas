# Esto lo que hace es coger el fichero .net y busca todos los números.
#  El resultado lo guarda en "pesos_bias.txt" que luego el programa de
#  python se encarga de leer.
cat -vt red_abalone.net | egrep "[-]{0,1}[0-9]{1,2},[0-9]{5}" -o > pesos_bias.txt
