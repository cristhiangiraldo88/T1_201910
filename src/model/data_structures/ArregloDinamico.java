package model.data_structures;

import java.util.Vector;

/**
 * 2019-01-23 Estructura de Datos Arreglo Dinamico de Strings. El arreglo al
 * llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * 
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<K> implements IArregloDinamico {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private Vector<K> elementos;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * 
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico(int max) {
		elementos = new Vector<K>();
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void agregar(K dato) {
		if (tamanoAct == tamanoMax) { // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			Vector<K> copia = elementos;
			elementos = new Vector<K>(tamanoMax);
			for (int i = 0; i < tamanoAct; i++) {
				elementos.set(i,copia.get(i));
			}
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}
		elementos.set(tamanoAct, dato);
		tamanoAct++;
	}

	public int darTamano() {
		// TODO implementar
		return tamanoAct;
	}

	public K darElemento(int i) {
		// TODO implementar

		return elementos.get(i);
	}

	public K buscar(K dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo())
		// definido en Strings.
		K encontrado = null;
		for (int i = 0; i < tamanoAct; i++) {
			if (elementos.get(i).compareTo(dato) == 0) {
				encontrado = elementos.get(i);
			}
		}
		return encontrado;
	}

	public K eliminar(K dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo())
		// definido en Strings.

		K encontrado = buscar(dato);
		int pos = givePos(dato);
		if (encontrado != null&&pos!=-1) {
			for (; pos < tamanoAct - 1; pos++)
				elementos.set(pos, elementos.get(pos+1));
			tamanoAct-=1;
		}
		return encontrado;
	}

	public int givePos(K dato) {
		int pos = -1;
		for (int i = 0; i < tamanoAct - 1; i++) {
			if (elementos.get(i).compareTo(dato) == 0) {
				pos = i;
			}
		}
		return pos;
	}
}
