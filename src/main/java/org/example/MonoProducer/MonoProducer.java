package org.example.MonoProducer;

import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public class MonoProducer {

    //O just sempre processa a fonte do dado, mesmo que não haja consumidores
    public static Mono<Integer> MonoProducer(){

        // publisher. Uma fonte produzindo o dado
        return Mono.just(getIntegerData());

    }

    //O supplier somente executa caso haja consumidores
    public static Mono<Integer> MonoProducerComSupplier(){

        // publisher. Uma fonte produzindo o dado
        return Mono.fromSupplier(() -> getIntegerData());

    }

    public static Mono<Integer> MonoProducerComErro(){

        // publisher. Uma fonte produzindo o dado, simulando um erro
        return Mono.just(10)
                .map(integer -> integer/0);

    }

    public static Mono<String> retornaMonoRepository(int userId){

        if (userId == 1)
            return Mono.just("Luiz");
        else if (userId == 2)
            return Mono.empty();
        else
            return Mono.error(new RuntimeException("Erro ao conectar com o Banco de Dados"));

    }

    public static void monoFromRunnable(){

        Mono.fromRunnable(runnableProcess()).subscribe(
                o -> System.out.println("On Next:" + o),
                throwable -> System.out.println("Erro: " + throwable.getMessage()),
                () -> System.out.println("Runnable Executado. Realizar Próximo Procedimento.")
        );


    }

    private static Integer getIntegerData() {

        System.out.println("Gerando o retorno de um Integer");
        return 1;

    }

    private static Runnable runnableProcess() {

        return () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Executando um processo!");
        };


    }

}
