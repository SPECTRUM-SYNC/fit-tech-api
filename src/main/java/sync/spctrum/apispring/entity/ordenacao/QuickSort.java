package sync.spctrum.apispring.entity.ordenacao;

import sync.spctrum.apispring.entity.Pessoa;
import sync.spctrum.apispring.entity.Usuario;

import java.util.List;

/**
 * The type Quick sort.
 */
public class QuickSort {

    /**
     * Quick sort.
     *
     * @param v         the v
     * @param indInicio the ind inicio
     * @param indFim    the ind fim
     */
    public static void quickSort(List<Usuario> v, int indInicio, int indFim) {

        Usuario pivo = v.get(indFim);
        int i = indFim;

        for (int j = indFim - 1; j >= indInicio; j--) {

            if (v.get(j).getNome().compareToIgnoreCase(pivo.getNome()) > 0) {
                i--;

                troca(v, i, j);
            }
        }

        troca(v, indFim, i);

        if (indInicio < i) {
            quickSort(v, indInicio, i - 1);
        }
        if (i < indFim) {
            quickSort(v, i + 1, indFim);
        }
    }

    /**
     * Troca.
     *
     * @param v the v
     * @param i the
     * @param j the j
     */
    public static void troca(List<Usuario> v, int i, int j) {
        Usuario temp = v.get(i);
        v.set(i, v.get(j));
        v.set(j, temp);

}
}
