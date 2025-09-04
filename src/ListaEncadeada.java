import java.util.Comparator;

//slides 24 e 25 do professor
public class ListaEncadeada<T> {
    private No<T> first, last;
    private int quantidade;
    private final boolean ordenada; //pelo que entendi, serve como uma flag pros métodos, se for True o método faz a operação dele, se False então não faz
    private Comparator<T> comparador; //comparador pra ordenar e buscar

    /*A definição se a lista será ordenada ou não deve se dar através de um parâmetro passado para o método construtor, na instanciação da lista, e não poderá ser alterado depois. A ordenação, bem como as buscas, deverão ser feitas utilizando-se de um Comparator que também deverá ser passado como parâmetro no construtor.*/
    public ListaEncadeada(boolean ordenada, Comparator<T> comparador) {
        this.first = null;
        this.last = null;
        this.quantidade = 0;
        this.ordenada = ordenada; //o "final" na declaração desse atributo não deixa mudar o valor
        this.comparador = comparador;
    }

    //Métodos que precisa ter: adicionar, contemElemento, pesquisar, remover
    public void adicionar(T novoValor){ //Adiciona um novo elemento na lista
        if(this.ordenada){
            inserirOrdenado(novoValor);
        }
        else{
            inserirNoFinal(novoValor);
        }
    }
    public void inserirOrdenado(T novoValor){ //insere de forma ordenada, usado quando a lista é ordenada
        No<T> novoNo = new No<>(novoValor); //nó pra "guardar" o novo elemento que vai ser inserido
        No<T> atual,anterior;
        atual = this.first;
        anterior = null;
        //se a lista estiver vazia, o novo elemento é o primeiro e o último
        if (this.first == null) { //o first ser nulo significa que está vazia
            this.first = novoNo;
            this.last = novoNo;
        // se não estiver vazia:
        } else {
            while (atual != null && comparador.compare(atual.getValor(), novoValor) < 0) { //loop pra percorrer a lista e encontrar a posição certa
                //o 'atual != null' vai garantir que não vai acessar um nó que não existe
                //'comparador.compare(atual.getValor(), novoValor) < 0)' aqui verifica se o valor do nó >atual< é MENOR que o >novoValor<
                //enquanto for menor, significa que ainda não encontrou a aposição certa pra encaixar esse novoValor
                anterior = atual; //atualiza o anterior pro nó atual pra poder avançar
                atual = atual.getProx(); //avança
            }

            //caso 1: se o 'anterior' for null, significa que não entrou no while, ou seja, o novoValor já é menor que o primeiro valor da lista, logo, se torna o primeiro
            if (anterior == null) {
                novoNo.setProx(this.first); //o próximo do novoNo é agora o antigo primeiro elemento (ele foi pro segundo lugar basicamente)
                this.first = novoNo; //ele vira o primeiro
            }
            //caso 2: se o nó atual for null, significa que percorreu a lista inteira e não achou nenhum elemento MENOR que o novoNo
            //logo, ele é maior que todos os elementos que já estavam presentes na lista, então tem que colocar em último
            else if (atual == null) {
                this.last.setProx(novoNo); //o antigo último nó agora aponta pra esse novoNo maior que ele
                this.last = novoNo; //ele vira o último
            }
            //caso 3: se não for menor ou maior que todos, ele vai entrar no meio da lista
            else {
                //aqui confunde
                anterior.setProx(novoNo); //o 'prox' do 'anterior' deixa de apontar pro nó 'atual' e passa a apontar pro 'novoNo'
                novoNo.setProx(atual); //o 'prox' do 'novoNo' passa a apontar pro 'atual', que se tornou o próximo do novo elemento inserido
            }
        }
        this.quantidade++; //incremento da lista pq adicionou um novo elemento (independente da onde foi inserido, por isso fora do while)
    }

    public void inserirNoFinal(T novoValor){ //insere no final, usado quando a lista não é ordenada
        No<T> novoNo = new No<>(novoValor);
        if (this.first == null) { //se a lista estiver vazia, ele é o último e o primeiro
            this.first = novoNo;
            this.last = novoNo;
        } else { //se não estiver, coloca no fim
            this.last.setProx(novoNo);
            this.last = novoNo;
        }
        this.quantidade++; //incrementa a quantidade
    }

    public boolean contemElemento(T valor){ //Verifica a existencia de um elemento na lista
        No<T> atual = this.first; //começa do primeiro nó
        while(atual != null){ //percorre a lista até o final
            /*Lembre-se do que comparador.compare(A, B) retorna:
            0: se A for igual a B.
            Um número negativo: se A for menor que B.
            Um número positivo: se A for maior que B.*/
            if (comparador.compare(atual.getValor(), valor) == 0) { //se o valor do nó atual for igual ao valor buscado, vaia retornar 0 no compare, ou seja, encontrou o elemento
                return true; //retorna true e sai do método
            }
            //se a lista for ordenada e o valor do nó atual for maior que o valor buscado, significa que não tem como o valor estar na lista, pq se estivesse, já teria sido encontrado antes
            if (this.ordenada && comparador.compare(atual.getValor(), valor) > 0) { //retorna um número positivo se o valor do nó atual for maior que o valor buscado (regra do compare)
                return false; //retorna false e sai do método, nem termina de percorrer a lista
            }

            atual = atual.getProx(); //avança para o próximo nó se não entrou em nenhum dos ifs
        }
        return false; //se percorreu a lista toda e não encontrou o elemento, o elemento não está e retorna false
    }

    public T pesquisar(T valor){ //Semelhante ao do slide do professor
        No<T> atual = this.first; //começa do primeiro nó
        while(atual != null){ //percorre a lista até o final
            if (comparador.compare(atual.getValor(), valor) == 0) { //se o valor do nó atual for igual ao valor buscado, vaia retornar 0 no compare, ou seja, encontrou o elemento
                return atual.getValor(); //retorna o valor do nó atual e sai do método
            }
            //se a lista for ordenada e o valor do nó atual for maior que o valor buscado, significa que não tem como o valor estar na lista, pq se estivesse, já teria sido encontrado antes
            if (this.ordenada && comparador.compare(atual.getValor(), valor) > 0) { //retorna um número positivo se o valor do nó atual for maior que o valor buscado (regra do compare)
                return null; //retorna null e sai do método, nem termina de percorrer a lista
            }

            atual = atual.getProx(); //avança para o próximo nó se não entrou em nenhum dos ifs
        }
        return null; //se percorreu a lista toda e não encontrou o elemento, o elemento não está e retorna null
    }

    public T remover(T valor){ //Copiado do slide do professor
        No<T> aux = this.first; //começa do primeiro nó
        No<T> anterior = null; //nó anterior começa como null pq o primeiro nó não tem anterior
        while(aux != null){//percorre a lista até o final
            if(aux.getValor().equals(valor)){
                if(aux == this.first){
                    this.first = this.first.getProx();
                    if(aux == this.last)
                        this.last = null;
                }
                if(aux == this.first){
                    this.first = this.first.getProx();
                    if(aux == this.last)
                        this.last = null;
                } else {
                    anterior.setProx(aux.getProx());
                    if(aux == this.last)
                        this.last = anterior;
                }
                this.quantidade--;
                return aux.getValor();
            }
            anterior = aux;
            aux = aux.getProx();
        }
        return null; //se percorreu a lista toda e não encontrou o elemento, o elemento não está e retorna null
    }

    @Override
    public String toString(){
        No aux = this.first;
        String s = "[";
        while(aux != null){
            s += aux.getValor();
            if(aux != this.last)
                s += ", ";
            aux = aux.getProx();
        }
        return (s + "]");
    }

}//chaves da classe
