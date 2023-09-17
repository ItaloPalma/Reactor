package org.example.Mono;
import org.example.MonoProducer.MonoProducer;

public class MonoExample {

    // Sempre se inscrever em um Mono ou Flux
    public static void retornaMono(){



        // subscriber. Realizar a inscrição no produtor do dado, e então podemos realizar 3 interações. O Consumo(onNext),
        //                                                         o tratamento em caso de erro(On Error) e
        //                                                         a recepção do término do envio
        MonoProducer.MonoProducer().subscribe(x -> System.out.println("Mono Example: " + x),
                throwable -> System.out.println("Erro: " + throwable.getMessage()),
                () -> System.out.println("Encerrado"));

    }

    public static void retornaMonoComErro(){

        // subscriber
        MonoProducer.MonoProducerComErro().subscribe(x -> System.out.println("Mono Example: " + x),
                throwable -> System.out.println("Erro Interceptado: " + throwable.getMessage()),
                () -> System.out.println("Encerrado"));

    }

}
