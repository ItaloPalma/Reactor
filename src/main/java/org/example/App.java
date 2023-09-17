package org.example;

import org.example.Mono.MonoExample;
import org.example.MonoProducer.MonoProducer;

public class App
{
    public static void main( String[] args )
    {

        MonoExample.retornaMono();

        // O Mono Producer com just, sempre executa a fonte do dado, mesmo que não haja consumidores
        MonoProducer.MonoProducer();

        // O Mono Producer com supplier, somente executa a fonte do dado, caso haja consumidores
        MonoProducer.MonoProducerComSupplier().subscribe();

        MonoExample.retornaMonoComErro();

        MonoProducer.retornaMonoRepository(1).subscribe(user -> System.out.println("O nome do usuario é: " + user),
                throwable -> System.out.println("Erro ao encontrar usuario: " + throwable.getMessage()),
                () -> System.out.println("Usuário não encotrado"));

        MonoProducer.retornaMonoRepository(2).subscribe(user -> System.out.println("O nome do usuario é: " + user),
                throwable -> System.out.println("Erro ao encontrar usuario: " + throwable.getMessage()),
                () -> System.out.println("Usuário não encotrado"));

        MonoProducer.retornaMonoRepository(3).subscribe(user -> System.out.println("O nome do usuario é: " + user),
                throwable -> System.out.println("Erro ao encontrar usuario: " + throwable.getMessage()),
                () -> System.out.println("Usuário não encotrado"));

    }
}
