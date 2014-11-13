# Script para Inteligencia Computacional.
# Práctica
# --------
#
# Implementar un programa para calcular los errores obtenidos por la red
#  aprendida, tanto con los ejemplos de entrenamiento como de aprendizaje.
#  Vamos a calcular los siguientes tipos de error:
#   a) Error de clasificación.
#   b) Error de aproximación.

# ¡¡NOTA!!: Esto sirve para una red neuronal con 8 de entrada,
#		4 de capa oculta y 1 de salida.
#		Hay que cambiar las cosas para una red de 3 de
#		capa oculta.


from math import exp			# Para la función e^
import subprocess			# Para ejecutar el bash.

# Primero llamamos al script que crea los pesos y los bías.
subprocess.call("./script.sh", shell=True)

#===============================================================
# Lectura del fichero de pesos.
# -----------------------------
# Programa de Python que se encarga de poner en orden las variables para usar en el otro programa.

f_r = open('pesos_bias.txt', 'r')


bias = []			# Este es el vector de bías.
matriz_pesos_ocult = []		# Esta es la matriz de pesos que asocia la capa de entrada con la capa oculta.
pesos_salida = []		# Pesos asociados a la neurona de salida.
pesos = []			# Lista auxiliar.
nom_fich_entrada = 'abalone.pat'# Nombre del fichero de entrada de datos.


# Leemos los bías (que son los 14 primeros números intercalados de 2 en 2).
for i in range(14):
  # El primero no nos interesa
  f_r.readline()
  # El segundo sí.
  b = f_r.readline().replace(",", ".").replace("\n", "")
  
  bias.append(float(b))
# El primero que lee no vale. (Esto es un pequeño parche)
bias.remove(0)

# Ahora vamos a por la matriz de pesos. (que son 8entradax4ocultas = 32pesos)
for i in range(32):
  # Cambiamos las comas por puntos y quitamos el retorno de carro.
  p = f_r.readline().replace(",", ".").replace("\n", "")
  pesos.append(float(p))
  
  # Si ya tenemos 8.
  if len(pesos) == 8:
    # Le damos la vuelta a los pesos puesto que van de mayor 
    #  a menor. ¡Ojo! A mí no siempre me daba la vuelta a los 
    #  pesos. Unas veces aparece 1, 2, 3, 4, 5, 6, 7, 8; y
    #  otras veces aparece 8, 7, 6, 5, 4, 3, 2, 1. (en .net)
    #pesos.reverse()
    # Guardamos los pesos.
    matriz_pesos_ocult.append(pesos)
    pesos = []
    
# Cogemos el resto de los pesos.
for i in range(4):
  p = f_r.readline().replace(",", ".").replace("\n", "")
  print(p)
  pesos_salida.append(float(p))

# Le damos la vuelta a los pesos puesto que van de mayor 
#  a menor. ¡Ojo! A mí no siempre me daba la vuelta a los 
#  pesos. Unas veces aparece 1, 2, 3, 4, 5, 6, 7, 8; y
#  otras veces aparece 8, 7, 6, 5, 4, 3, 2, 1.
#pesos_salida.reverse()
    
f_r.close()

##===============================================================
# Datos de entrada.
entrada = []

# Abrimos el fichero donde están los datos.
f = open(nom_fich_entrada, 'r')

# Las 7 primeras líneas no nos valen.
for i in range(7):
  f.readline()
  
# Leemos cada una de las líneas del fichero.
for linea in f:
  linea = linea.split()
  # Transformamos el string en flotante.
  entrada.append([float(n) for n in linea])
  
f.close()




##===============================================================
# Primera etapa: Capa oculta.
# ---------------------------
primera_capa = []
res_neurona  = []
# Para cada una de las entrada.
for ent in entrada:
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
  suma = sum(mult) #+ bias[ len(bias) - 1 ]
  
  # Le aplicamos la función sigmoidal (solo en el caso de los datos
  # noramlizados).
  #suma = 1 / (1 + exp(-suma))
    
  # Guardamos el resultado.
  salida.append(suma)



##===============================================================
# Como ya tenemos las predicciones y también tenemos el
#  valor de la entrada, lo que vamos a hacer ahora es 
#  comparar el error.

MSE = 0
for i in range(len(entrada)):
  MSE = MSE + pow(salida[i] - entrada[i][8], 2)
  
MSE = MSE / len(entrada)

print("MSE:",  MSE)

print("Salida\t\tEntrada")
print([salida[0], entrada[0][8]])
print([salida[ len(salida) -1], entrada[ len(entrada) -1] [8]])
print()
print(bias)
print(pesos_salida)
