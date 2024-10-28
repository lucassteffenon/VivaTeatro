package br.univates.ticketmasterplus.businessDAO;

public class DuplicatedKeyException extends Exception
{

    public DuplicatedKeyException()
    {
        super("Chave primária duplicada");
    }
    
}
