#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Script para Inteligencia Computacional.
# Practica - DNI
# --------------
#
# Implementación de una red neuronal con 4 nodos
# en la capa oculta que nos predice cual es la letra
# de un DNI introducido por teclado.

# Para la función e^
from math import exp
##==============================================================
# Variables para la red neuronal - coeficientes de la misma.
bias               = [0.332, 0.74434, 0.82913, -0.69767, -0.81547, 0.34962, -0.73776, 0.79188, 6.66122, -21.20508, -28.37516, -12.82364, 28.3411] 
matriz_pesos_ocult = [[5.23843, 0.1743, 24.65981, -3.87259, 5.22669, 0.73526, 2.0117, -5.49345], [6.58451, -5.76147, 15.11261, -0.52493, -2.09466, -5.7721, 0.6898, 6.02468], [-2.63619, 0.08717, 13.8921, 14.53072, -4.10565, -6.82949, 4.54974, 8.03961], [-11.94438, -1.89549, 2.13732, 6.983, -1.73894, -3.4204, 6.35127, 1.92508]]
pesos_salida       = [11.40499, 1.69824, -1.25774, 3.96262]
# Entrada de los datos.
ent                = []
# Letras del DNI.
NIF_L='TRWAGMYFPDXBNJZSQVHLCKE'

# Para el color de la terminal.
class bcolors:
    HEADER = '\033[95m'
    OKBLUE = '\033[94m'
    OKGREEN = '\033[92m'
    WARNING = '\033[93m'
    FAIL = '\033[91m'
    ENDC = '\033[0m'

##===============================================================
# Entrada de los datos.
entrada = input(bcolors.HEADER+"Introduzca el DNI sin letra: " + bcolors.OKBLUE)
# La entrada se normaliza.
ent = [ (int(n)/9) for n in list( entrada )]

##===============================================================
# Primera etapa: Capa oculta.
# ---------------------------
primera_capa = []
res_neurona  = []

# Le aplicamos la función y el producto de la neurona.
for i_pes_n in range(len(matriz_pesos_ocult)):
	mult = [p * e for p, e in zip(ent, matriz_pesos_ocult[i_pes_n])]
	suma = sum(mult) + bias[8 + i_pes_n]
	
	# Le aplicamos la función sigmoidal.
	suma = 1 / (1 + exp(-suma))

	# Guardamos los datos
	res_neurona.append(suma)

# Guardamos los datos de cada entrada.
primera_capa.append(res_neurona)
res_neurona = []

# Última capa: capa de salida.
# ----------------------------
salida = []

for ent in primera_capa:
  # Le aplicamos la función y el producto de la neurona.
  mult = [p * e for p, e in zip(ent, pesos_salida)]
  # El útlimo bias es el de salida.
  # NOTA IMPORTANTE
  # ---------------
  # Cuando se está trabajando con datos NO normalizados en JavaNNS
  # le aplica directamente el bías. Esto se reduce a que a la hora
  # de implementar, no hay que meterle el bías a la capa de salida.
  #suma = sum(mult) #+ bias[ len(bias) - 1 ]
  suma = sum(mult) #+ bias[ len(bias) - 1 ]
  
  # Le aplicamos la función sigmoidal (solo en el caso de los datos
  # noramlizados).
  #suma = 1 / (1 + exp(-suma))
    
  # Guardamos el resultado y discretizamos la salida.
  salida = NIF_L[round(suma)] 

print(bcolors.HEADER + "La letra para el DNI " + bcolors.WARNING + entrada + bcolors.HEADER + " es la: " + bcolors.WARNING + salida)