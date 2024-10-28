package br.univates.ticketmasterplus.businessDAO;

public class RecordNotFoundException extends Exception
{

    public RecordNotFoundException()
    {
        super("Registro não encontrato");
    }
    
}
